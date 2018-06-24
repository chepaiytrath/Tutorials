package com.demo.bs.project.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.bs.project.domain.Day;
import com.demo.bs.project.domain.Match;
import com.demo.bs.project.domain.Schedule;
import com.demo.bs.project.domain.Team;
import com.demo.bs.project.repository.DayRepository;
import com.demo.bs.project.repository.ScheduleRepository;
import com.demo.bs.project.repository.TeamRepository;
import com.demo.bs.project.service.ScheduleService;
import com.demo.bs.project.service.helper.ScheduleServiceHelper;
import com.demo.bs.project.vo.CreateScheduleRequest;
import com.demo.bs.project.vo.CreateScheduleResponse;
import com.demo.bs.project.vo.DeleteScheduleResponse;
import com.demo.bs.project.vo.MatchVO;
import com.demo.bs.project.vo.ViewScheduleResponse;

@Component("ScheduleService")
public class ScheduleServiceImpl implements ScheduleService {

	@Autowired
	private TeamRepository teamRepository;

	@Autowired
	private ScheduleRepository scheduleRepository;

	@Autowired
	private DayRepository dayRepository;

	@Autowired
	private ScheduleServiceHelper scheduleServiceHelper;
	
	
	@Override
	public CreateScheduleResponse createSchedule(CreateScheduleRequest request) {
		CreateScheduleResponse response = new CreateScheduleResponse();
		response.setName(request.getName());
		List<Team> teamListDB = (List<Team>) teamRepository.findAllById(request.getTeamIdList());
		List<Day> dayList = scheduleServiceHelper.createDayList(teamListDB, request);
		//dayRepository.saveAll(dayList);
		Schedule schedule = new Schedule(request.getName(), dayList);
		scheduleRepository.save(schedule);
		return response;
	}

	@Override
	public DeleteScheduleResponse deleteScheduleById(Long scheduleId) {
		DeleteScheduleResponse deleteScheduleResponse = new DeleteScheduleResponse();
		scheduleRepository.deleteById(scheduleId);
		deleteScheduleResponse.setSuccess(true);
		return deleteScheduleResponse;
	}

	@Override
	public ViewScheduleResponse viewScheduleById(Long scheduleId) {
		ViewScheduleResponse viewScheduleResponse = new ViewScheduleResponse();
		Schedule schedule = scheduleRepository.getOne(scheduleId);
		viewScheduleResponse.setSuccess(true);
		return viewScheduleResponse;
	}
}
