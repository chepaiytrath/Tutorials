package com.demo.bs.project.service;

import org.springframework.stereotype.Service;

import com.demo.bs.project.vo.CreateScheduleRequest;
import com.demo.bs.project.vo.CreateScheduleResponse;

@Service
public interface ScheduleService {
	CreateScheduleResponse createSchedule(CreateScheduleRequest request);
}
