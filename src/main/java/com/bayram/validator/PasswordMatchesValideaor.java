package com.bayram.validator;


import javax.validation.ConstraintValidator;


import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;

import com.bayram.validator.annotation.PasswordMatches;

public class PasswordMatchesValideaor implements ConstraintValidator<PasswordMatches, Object> {
	
	
	private String firstFieldName;
	private String secondFieldName;

	@Override
	public void initialize(final PasswordMatches passwordMatches) {
		firstFieldName = passwordMatches.first();
		secondFieldName = passwordMatches.second();
	}

	@Override
	public boolean isValid(final Object value, final ConstraintValidatorContext context) {
		try {
			final Object firstObj = BeanUtils.getProperty(value, firstFieldName);
			final Object secondObj = BeanUtils.getProperty(value, secondFieldName);
			return firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
		} catch (final Exception ignore) {
		}
		return true;
	}

	

}
