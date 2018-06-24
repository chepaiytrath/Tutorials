package com.demo.bs.project.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bs.project.service.ScheduleService;
import com.demo.bs.project.vo.CreateScheduleRequest;
import com.demo.bs.project.vo.CreateScheduleResponse;
import com.demo.bs.project.vo.DeleteScheduleResponse;
import com.demo.bs.project.vo.ViewScheduleResponse;

@RestController
@RequestMapping(value = "/schedule")
public class ScheduleController {

	@Autowired
	private ScheduleService scheduleService;
	
	@PostMapping
	public ResponseEntity<CreateScheduleResponse> createSchedule(@RequestBody @Valid CreateScheduleRequest request) {
		CreateScheduleResponse response = scheduleService.createSchedule(request);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<ViewScheduleResponse> viewSchedule(@PathVariable Long scheduleId) {
		ViewScheduleResponse response = scheduleService.viewScheduleById(scheduleId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<DeleteScheduleResponse> deleteSchedule(@PathVariable Long scheduleId) {
		DeleteScheduleResponse response = scheduleService.deleteScheduleById(scheduleId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
