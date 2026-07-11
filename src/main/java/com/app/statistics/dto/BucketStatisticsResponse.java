package com.app.statistics.dto;

public class BucketStatisticsResponse {

    private String bucketName;
    private long totalFiles;
    private long totalSize;
    private String readableSize;

    public BucketStatisticsResponse() {
    }

    public BucketStatisticsResponse(String bucketName,
                                    long totalFiles,
                                    long totalSize,
                                    String readableSize) {
        this.bucketName = bucketName;
        this.totalFiles = totalFiles;
        this.totalSize = totalSize;
        this.readableSize = readableSize;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public long getTotalFiles() {
        return totalFiles;
    }

    public void setTotalFiles(long totalFiles) {
        this.totalFiles = totalFiles;
    }

    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }

    public String getReadableSize() {
        return readableSize;
    }

    public void setReadableSize(String readableSize) {
        this.readableSize = readableSize;
    }
}