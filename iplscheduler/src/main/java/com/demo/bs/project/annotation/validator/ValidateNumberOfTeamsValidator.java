package com.demo.bs.project.annotation.validator;

import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.demo.bs.project.annotation.ValidateNumberOfTeams;

public class ValidateNumberOfTeamsValidator implements ConstraintValidator<ValidateNumberOfTeams, List<Long>> {
	
	@Override
	public void initialize(ValidateNumberOfTeams constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
	}
	
	@Override
	public boolean isValid(List<Long> value, ConstraintValidatorContext context) {
		if(value != null && value.size() < 3) {
			return false;
		}
		return true;
	}
}
