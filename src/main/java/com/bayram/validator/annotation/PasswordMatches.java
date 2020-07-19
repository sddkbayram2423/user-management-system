package com.bayram.validator.annotation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;


import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.bayram.validator.PasswordMatchesValideaor;

@Documented
@Retention(RUNTIME)
@Target({ TYPE, ANNOTATION_TYPE })
@Constraint(validatedBy =PasswordMatchesValideaor.class )
public @interface PasswordMatches {
	
	String message() default "{constraints.field-match}";
	
	Class<?>[] groups() default{};
	
	Class<? extends Payload>[] payload()  default{};
	
	String first();
	
	String second();
	
	@Target({ TYPE, ANNOTATION_TYPE })
	@Retention(RUNTIME)
	@Documented
	@interface List {
		PasswordMatches[] value();
	}
	

}
