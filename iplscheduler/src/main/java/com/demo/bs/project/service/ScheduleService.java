package com.demo.bs.project.service;

import org.springframework.stereotype.Service;

import com.demo.bs.project.vo.CreateScheduleRequest;
import com.demo.bs.project.vo.CreateScheduleResponse;
import com.demo.bs.project.vo.DeleteScheduleResponse;
import com.demo.bs.project.vo.ViewScheduleResponse;

@Service
public interface ScheduleService {
	CreateScheduleResponse createSchedule(CreateScheduleRequest request);

	ViewScheduleResponse viewScheduleById(Long scheduleId);
	
	DeleteScheduleResponse deleteScheduleById(Long scheduleId);
}
