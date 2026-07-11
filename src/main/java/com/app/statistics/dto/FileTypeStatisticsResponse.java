package com.app.statistics.dto;

public class FileTypeStatisticsResponse {

    private String fileType;
    private long totalFiles;
    private long totalSize;
    private String readableSize;

    public FileTypeStatisticsResponse() {
    }

    public FileTypeStatisticsResponse(String fileType,
                                      long totalFiles,
                                      long totalSize,
                                      String readableSize) {
        this.fileType = fileType;
        this.totalFiles = totalFiles;
        this.totalSize = totalSize;
        this.readableSize = readableSize;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
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