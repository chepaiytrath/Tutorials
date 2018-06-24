package com.demo.bs.project.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bs.project.service.ScheduleService;
import com.demo.bs.project.vo.CreateScheduleRequest;
import com.demo.bs.project.vo.CreateScheduleResponse;

@RestController
@RequestMapping(value = "/schedule")
public class ScheduleController {

	@Autowired
	private ScheduleService scheduleService;
	
	/*@PostMapping
	public CreateScheduleResponse createSchedule(@RequestBody @Valid CreateScheduleRequest request) {
		CreateScheduleResponse response = scheduleService.createSchedule(request);
		return response;
	}*/
	
	@PostMapping
	public ResponseEntity<CreateScheduleResponse> createSchedule2(@RequestBody @Valid CreateScheduleRequest request) {
		CreateScheduleResponse response = scheduleService.createSchedule(request);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
