package com.app.object.exception;

import com.app.common.exception.StorageException;

public class ObjectNotFoundException extends StorageException {

	public ObjectNotFoundException(String objectName) {

		super("Object not found : " + objectName);
	}
}