package com.app.service.impl;

import com.app.entity.FileMetadata;
import com.app.exception.MetadataNotFoundException;
import com.app.repository.FileMetadataRepository;
import com.app.service.MetadataService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class MetadataServiceImpl implements MetadataService {

    private final FileMetadataRepository repository;

    public MetadataServiceImpl(FileMetadataRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<FileMetadata> getAllFiles(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).descending());
        return repository.findAll(pageable);
    }

    @Override
    public FileMetadata getById(String id) {
        return repository.findById(id).orElseThrow(() -> new MetadataNotFoundException(id));
    }

    @Override
    public Page<FileMetadata> searchByFileName(String fileName, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findByOriginalNameContainingIgnoreCase(fileName, pageable);
    }

    @Override
    public Page<FileMetadata> searchByBucket(String bucketName, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findByBucketName(bucketName, pageable);
    }

    @Override
    public Page<FileMetadata> searchByUser(String uploadedBy, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findByUploadedBy(uploadedBy, pageable);
    }

    @Override
    public Page<FileMetadata> searchByStatus(String status, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findByStatus(status, pageable);
    }
}