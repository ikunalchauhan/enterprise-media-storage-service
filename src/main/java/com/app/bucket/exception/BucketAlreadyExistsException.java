package com.app.bucket.exception;


import com.app.common.exception.StorageException;

public class BucketAlreadyExistsException extends StorageException {

	public BucketAlreadyExistsException(String bucketName) {

		super("Bucket already exists : " + bucketName);
	}
}