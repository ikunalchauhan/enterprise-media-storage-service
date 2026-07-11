package com.app.metadata.exception;

import com.app.common.exception.StorageException;

public class MetadataNotFoundException extends StorageException {

	public MetadataNotFoundException(String id) {

		super("Metadata not found : " + id);
	}
}