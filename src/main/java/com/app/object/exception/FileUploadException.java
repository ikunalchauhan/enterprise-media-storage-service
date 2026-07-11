package com.app.object.exception;

import com.app.common.exception.StorageException;

public class FileUploadException extends StorageException {

	public FileUploadException(String message) {

		super(message);
	}
}