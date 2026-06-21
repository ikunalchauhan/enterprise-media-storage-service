package com.app.service.impl;

import com.app.dto.CopyRequest;
import com.app.dto.MoveRequest;
import com.app.dto.RenameRequest;
import com.app.entity.FileMetadata;
import com.app.exception.FileDownloadException;
import com.app.exception.FileUploadException;
import com.app.exception.MetadataNotFoundException;
import com.app.repository.FileMetadataRepository;
import com.app.service.ObjectService;
import com.app.util.ChecksumUtil;
import com.app.util.FileNameGenerator;
import com.app.util.FileStatus;
import com.app.util.FileTypeUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;

import java.io.InputStream;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ObjectServiceImpl implements ObjectService {

    private final S3Client s3Client;
    private final FileMetadataRepository repository;

    public ObjectServiceImpl(S3Client s3Client, FileMetadataRepository repository) {
        this.s3Client = s3Client;
        this.repository = repository;
    }

    @Override
    public FileMetadata upload(MultipartFile file, String bucketName, String uploadedBy) {

        try {
            String originalName = file.getOriginalFilename();

            String storedName = FileNameGenerator.generate(originalName);
            String checksum = ChecksumUtil.sha256(file.getInputStream());

            PutObjectRequest request = PutObjectRequest.builder().bucket(bucketName).key(storedName).contentType(file.getContentType()).build();

            PutObjectResponse response = s3Client.putObject(request, RequestBody.fromBytes(file.getBytes()));

            FileMetadata metadata = new FileMetadata();
            metadata.setOriginalName(originalName);
            metadata.setStoredName(storedName);
            metadata.setBucketName(bucketName);
            metadata.setFileSize(file.getSize());
            metadata.setContentType(file.getContentType());
            metadata.setUploadedBy(uploadedBy);
            metadata.setUploadedAt(Instant.now());
            metadata.setChecksum(checksum);
            metadata.setEtag(response.eTag());
            metadata.setStatus(FileStatus.ACTIVE);
            metadata.setFileType(FileTypeUtil.determineType(file.getContentType()));

            return repository.save(metadata);
        } catch (Exception ex) {
            throw new FileUploadException(ex.getMessage());
        }
    }

    @Override
    public InputStream download(String metadataId) {
        try {
            FileMetadata metadata = repository.findById(metadataId).orElseThrow(() -> new MetadataNotFoundException(metadataId));

            GetObjectRequest request = GetObjectRequest.builder().bucket(metadata.getBucketName()).key(metadata.getStoredName()).build();

            return s3Client.getObject(request);
        } catch (Exception ex) {
            throw new FileDownloadException(ex.getMessage());
        }
    }

    @Override
    public void delete(String metadataId) {

        FileMetadata metadata = repository.findById(metadataId).orElseThrow(() -> new MetadataNotFoundException(metadataId));

        DeleteObjectRequest request = DeleteObjectRequest.builder().bucket(metadata.getBucketName()).key(metadata.getStoredName()).build();

        s3Client.deleteObject(request);

        repository.delete(metadata);
    }

    @Override
    public List<String> listObjects(String bucketName) {

        ListObjectsV2Request request = ListObjectsV2Request.builder().bucket(bucketName).build();

        ListObjectsV2Response response = s3Client.listObjectsV2(request);

        return response.contents().stream().map(S3Object::key).collect(Collectors.toList());
    }

    @Override
    public void copy(CopyRequest request) {

        CopyObjectRequest copyRequest = CopyObjectRequest.builder().sourceBucket(request.getSourceBucket()).sourceKey(request.getObjectKey()).destinationBucket(request.getTargetBucket()).destinationKey(request.getObjectKey()).build();

        s3Client.copyObject(copyRequest);
    }

    @Override
    public void move(MoveRequest request) {

        CopyRequest copyRequest = new CopyRequest();

        copyRequest.setSourceBucket(request.getSourceBucket());

        copyRequest.setTargetBucket(request.getTargetBucket());

        copyRequest.setObjectKey(request.getObjectKey());

        copy(copyRequest);

        DeleteObjectRequest deleteRequest = DeleteObjectRequest.builder().bucket(request.getSourceBucket()).key(request.getObjectKey()).build();

        s3Client.deleteObject(deleteRequest);

//        bug fix - metaData Update with target bucket name
        FileMetadata metaData = repository.findBystoredName(request.getObjectKey()).orElseThrow(() -> new MetadataNotFoundException(request.getObjectKey()));

        metaData.setBucketName(request.getTargetBucket());

        repository.save(metaData);
    }

    @Override
    public void rename(RenameRequest request) {
        CopyObjectRequest copyRequest = CopyObjectRequest.builder().sourceBucket(request.getBucketName()).sourceKey(request.getOldName()).destinationBucket(request.getBucketName()).destinationKey(request.getNewName()).build();

        s3Client.copyObject(copyRequest);

        DeleteObjectRequest deleteRequest = DeleteObjectRequest.builder().bucket(request.getBucketName()).key(request.getOldName()).build();

        s3Client.deleteObject(deleteRequest);
    }
}