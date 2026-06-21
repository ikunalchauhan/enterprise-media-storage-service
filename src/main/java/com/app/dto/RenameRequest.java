package com.app.dto;

import jakarta.validation.constraints.NotBlank;

public class RenameRequest {

    @NotBlank(message = "Bucket name is required")
    private String bucketName;

    @NotBlank(message = "Old name is required")
    private String oldName;

    @NotBlank(message = "New name is required")
    private String newName;

    public RenameRequest() {
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }
}