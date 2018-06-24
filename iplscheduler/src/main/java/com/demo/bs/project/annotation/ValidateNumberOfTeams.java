package com.demo.bs.project.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.demo.bs.project.annotation.validator.ValidateNumberOfTeamsValidator;
import com.demo.bs.project.constant.ErrorConstants;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = ValidateNumberOfTeamsValidator.class)
public @interface ValidateNumberOfTeams {
	String message() default ErrorConstants.INVALID_TEAM_LIST;

	String value() default "";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default{};
}
