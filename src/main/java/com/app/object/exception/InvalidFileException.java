package com.app.object.exception;

import com.app.common.exception.StorageException;

public class InvalidFileException extends StorageException {

	public InvalidFileException(String message) {

		super(message);
	}
}