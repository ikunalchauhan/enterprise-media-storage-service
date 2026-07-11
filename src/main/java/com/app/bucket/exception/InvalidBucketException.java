package com.app.bucket.exception;

import com.app.common.exception.StorageException;

public class InvalidBucketException
        extends StorageException {

    public InvalidBucketException(
            String message) {

        super(message);
    }
}