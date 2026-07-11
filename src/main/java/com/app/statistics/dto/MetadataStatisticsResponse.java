package com.app.statistics.dto;

public class MetadataStatisticsResponse {

    private long activeFiles;
    private long archivedFiles;
    private long deletedFiles;

    public MetadataStatisticsResponse() {
    }

    public MetadataStatisticsResponse(long activeFiles,
                                      long archivedFiles,
                                      long deletedFiles) {
        this.activeFiles = activeFiles;
        this.archivedFiles = archivedFiles;
        this.deletedFiles = deletedFiles;
    }

    public long getActiveFiles() {
        return activeFiles;
    }

    public void setActiveFiles(long activeFiles) {
        this.activeFiles = activeFiles;
    }

    public long getArchivedFiles() {
        return archivedFiles;
    }

    public void setArchivedFiles(long archivedFiles) {
        this.archivedFiles = archivedFiles;
    }

    public long getDeletedFiles() {
        return deletedFiles;
    }

    public void setDeletedFiles(long deletedFiles) {
        this.deletedFiles = deletedFiles;
    }
}