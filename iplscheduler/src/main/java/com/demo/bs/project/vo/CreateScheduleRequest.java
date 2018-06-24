package com.demo.bs.project.vo;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.demo.bs.project.annotation.ValidateNumberOfDays;
import com.demo.bs.project.annotation.ValidateNumberOfTeams;
import com.demo.bs.project.constant.ErrorConstants;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@ValidateNumberOfDays
public class CreateScheduleRequest {
	
	private String name;
	
	@NotEmpty(message=ErrorConstants.TEAM_LIST_EMPTY)
	@JsonProperty("teamids")
	@ValidateNumberOfTeams
	private List<Long> teamIdList;
	
	@NotNull(message=ErrorConstants.NUMBER_OF_DAYS_EMPTY)
	@JsonProperty("days")
	private Integer numberOfDays;
	
	@JsonProperty("matchesperday")
	private Integer matchesPerDay;
	
	//Each team will play the other n-1 teams twice over x days period - numberofrounds=2
	@JsonProperty("numberofrounds")
	private Integer numberOfRounds;
	
}
