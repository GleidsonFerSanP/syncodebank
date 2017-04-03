package com.extra.validators;

import com.extra.exceptions.FieldNullOrEmptyException;
import com.extra.exceptions.InvalidOldPasswordException;
import com.extra.exceptions.ObjectNotFoundException;
import com.extra.exceptions.PreconditionFailedException;

public interface IValidator {

	void validate(Object obj) throws FieldNullOrEmptyException, ObjectNotFoundException, InvalidOldPasswordException, PreconditionFailedException;
	
}
