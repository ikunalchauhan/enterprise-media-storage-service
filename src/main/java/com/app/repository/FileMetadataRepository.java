package com.app.repository;

import com.app.entity.FileMetadata;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface FileMetadataRepository extends MongoRepository<FileMetadata, String> {

    List<FileMetadata> findByUploadedBy(String uploadedBy);

    List<FileMetadata> findByStatus(String status);

    List<FileMetadata> findByBucketName(String bucketName);

    List<FileMetadata> findByOriginalNameContainingIgnoreCase(String name);

    Optional<FileMetadata> findBystoredName(String storedName);

    Page<FileMetadata> findByOriginalNameContainingIgnoreCase(String originalName, Pageable pageable);

    Page<FileMetadata> findByBucketName(String bucketName, Pageable pageable);

    Page<FileMetadata> findByUploadedBy(String uploadedBy, Pageable pageable);

    Page<FileMetadata> findByStatus(String status, Pageable pageable);
}