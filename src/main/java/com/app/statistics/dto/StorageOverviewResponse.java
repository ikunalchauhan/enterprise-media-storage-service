package com.app.statistics.dto;

public class StorageOverviewResponse {

    private long totalFiles;
    private long totalBuckets;
    private long totalStorageBytes;
    private String totalStorageReadable;

    public StorageOverviewResponse() {
    }

    public StorageOverviewResponse(long totalFiles,
                                   long totalBuckets,
                                   long totalStorageBytes,
                                   String totalStorageReadable) {
        this.totalFiles = totalFiles;
        this.totalBuckets = totalBuckets;
        this.totalStorageBytes = totalStorageBytes;
        this.totalStorageReadable = totalStorageReadable;
    }

    public long getTotalFiles() {
        return totalFiles;
    }

    public void setTotalFiles(long totalFiles) {
        this.totalFiles = totalFiles;
    }

    public long getTotalBuckets() {
        return totalBuckets;
    }

    public void setTotalBuckets(long totalBuckets) {
        this.totalBuckets = totalBuckets;
    }

    public long getTotalStorageBytes() {
        return totalStorageBytes;
    }

    public void setTotalStorageBytes(long totalStorageBytes) {
        this.totalStorageBytes = totalStorageBytes;
    }

    public String getTotalStorageReadable() {
        return totalStorageReadable;
    }

    public void setTotalStorageReadable(String totalStorageReadable) {
        this.totalStorageReadable = totalStorageReadable;
    }
}