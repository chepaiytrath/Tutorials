package com.demo.bs.project.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.demo.bs.project.annotation.validator.ValidateNumberOfDaysValidator;
import com.demo.bs.project.constant.ErrorConstants;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = ValidateNumberOfDaysValidator.class)
public @interface ValidateNumberOfDays {
	// https://dzone.com/articles/creating-custom-annotations-in-java
	// Processing annotations is accomplished through the Java Reflection API

	// These parameters may be a primitive (such as int or double), String, class,
	// enum, annotation,
	// or an array of any of the five preceding types
	String message() default ErrorConstants.INVALID_NUMBER_OF_DAYS;

	// The variable name value has a special meaning: It defines a Single-Element
	// Annotation
	// and allows users of our annotation to supply a single parameter to the
	// annotation without
	// specifying the name of the parameter. For example, a user can annotate a
	// field using
	// @JsonField("someFieldName") and is not required to declare the annotation as
	// @JsonField(value = "someFieldName")
	String value() default "";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default{};
}
