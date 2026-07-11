package com.app.object.exception;

import com.app.common.exception.StorageException;

public class FileDownloadException extends StorageException {

	public FileDownloadException(String message) {

		super(message);
	}
}