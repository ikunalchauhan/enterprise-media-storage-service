package com.app.dto;


import jakarta.validation.constraints.NotBlank;

public class BucketRequest {

    @NotBlank(message = "Bucket name is required")
    private String bucketName;

    public BucketRequest() {
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }
}