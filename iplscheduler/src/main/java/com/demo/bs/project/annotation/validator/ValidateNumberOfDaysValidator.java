package com.demo.bs.project.annotation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.demo.bs.project.annotation.ValidateNumberOfDays;
import com.demo.bs.project.vo.CreateScheduleRequest;

public class ValidateNumberOfDaysValidator implements ConstraintValidator<ValidateNumberOfDays, CreateScheduleRequest> {
	//initialize() method gives you access to the attribute values of the validated constraint and allows you to store 
	//them in a field of the validator
	@Override
	public void initialize(ValidateNumberOfDays constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
	}
	
	//isValid() method contains the actual validation logic.
	@Override
	public boolean isValid(CreateScheduleRequest value, ConstraintValidatorContext context) {
		int numberOfTeamsRequest = 0;
		int numberOfDaysRequest = 0;
		if(value != null) {
			numberOfTeamsRequest = value.getTeamIdList().size();
			numberOfDaysRequest = value.getNumberOfDays();
		}
		
		int requiredNumberOfDays = (numberOfTeamsRequest * (numberOfTeamsRequest - 1)) / 2;
		
		if(numberOfDaysRequest < requiredNumberOfDays) {
			return false;
		}
		
		return true;
	}


}
