package com.app.object.service;

import java.io.InputStream;
import java.util.List;

import com.app.object.dto.CopyRequest;
import com.app.object.dto.MoveRequest;
import com.app.object.dto.RenameRequest;
import com.app.storage.entity.FileMetadata;
import org.springframework.web.multipart.MultipartFile;

public interface ObjectService {

    FileMetadata upload(
            MultipartFile file,
            String bucketName,
            String uploadedBy);

    InputStream download(String metadataId);

    void delete(String metadataId);

    List<String> listObjects(String bucketName);

    void copy(CopyRequest request);

    void move(MoveRequest request);

    void rename(RenameRequest request);
}