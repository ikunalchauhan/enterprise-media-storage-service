package com.app.bucket.exception;

import com.app.common.exception.StorageException;

public class BucketNotFoundException extends StorageException {

	public BucketNotFoundException(String bucketName) {

		super("Bucket not found : " + bucketName);
	}
}