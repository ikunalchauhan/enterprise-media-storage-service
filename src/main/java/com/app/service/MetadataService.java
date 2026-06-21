package com.app.service;

import com.app.entity.FileMetadata;
import org.springframework.data.domain.Page;

public interface MetadataService {

    Page<FileMetadata> getAllFiles(int page, int size, String sortBy);

    FileMetadata getById(String id);

    Page<FileMetadata> searchByFileType(String fileType, int page, int size);

    Page<FileMetadata> searchByFileName(String fileName, int page, int size);

    Page<FileMetadata> searchByBucket(String bucketName, int page, int size);

    Page<FileMetadata> searchByUser(String uploadedBy, int page, int size);

    Page<FileMetadata> searchByStatus(String status, int page, int size);
}