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
import com.demo.bs.project.vo.CreateScheduleRequest;
import com.demo.bs.project.vo.CreateScheduleResponse;
import com.demo.bs.project.vo.MatchVO;

@Component("ScheduleService")
public class ScheduleServiceImpl implements ScheduleService {

	@Autowired
	private TeamRepository teamRepository;

	@Autowired
	private ScheduleRepository scheduleRepository;

	@Autowired
	private DayRepository dayRepository;

	@Override
	public CreateScheduleResponse createSchedule(CreateScheduleRequest request) {

		CreateScheduleResponse response = new CreateScheduleResponse();
		response.setName(request.getName());
		List<Team> teamListDB = (List<Team>) teamRepository.findAllById(request.getTeamIdList());
		List<Day> dayList = createDayList(teamListDB, request);
		dayRepository.saveAll(dayList);
		Schedule schedule = new Schedule(request.getName(), dayList);
		scheduleRepository.save(schedule);
		return response;
	}

	private List<Day> createDayList(List<Team> teamListDB, CreateScheduleRequest request) {
		if (teamListDB.size() % 2 != 0) {
			Team dummy = new Team();
			dummy.setDummy(true);
			teamListDB.add(dummy);
		}
		List<Match> matchList = createMatchList(teamListDB);
		List<Day> days = new ArrayList<>();
		Day day = null;
		int daycounter = 0;
		for(int i = 0; i < matchList.size(); i++) {
			if(i % request.getMatchesPerDay() == 0) {
				daycounter++;
				day = new Day(daycounter, new ArrayList<Match>());
			}
			day.getMatches().add(matchList.get(i));
			if((i+1) % request.getMatchesPerDay() == 0) {
				days.add(day);
			}
		}
		return days;
	}

	private List<Match> createMatchList(List<Team> teamListDB) {
		List<Match> matchList = new ArrayList<>();
		Team[][] originalTeamArr = new Team[2][teamListDB.size() / 2];
		originalTeamArr = initializeTeamArr(originalTeamArr, teamListDB);
		
		Team tempTeam = originalTeamArr[1][0];
		populateMatchList(matchList, originalTeamArr, true);
		rotateLeft(2, teamListDB.size() / 2, originalTeamArr);
		while(originalTeamArr[1][0] != tempTeam) {
			populateMatchList(matchList, originalTeamArr, true);
			rotateLeft(2, teamListDB.size() / 2, originalTeamArr);
		}
		populateMatchList(matchList, originalTeamArr, false);
		rotateLeft(2, teamListDB.size() / 2, originalTeamArr);
		while(originalTeamArr[1][0] != tempTeam) {
			populateMatchList(matchList, originalTeamArr, false);
			rotateLeft(2, teamListDB.size() / 2, originalTeamArr);
		}
		return matchList;
	}

	private void rotateLeft(int m, int n, Team[][] mat) {
		int row = 0, col = 0;
		Team prev, curr;

		while (row < m && col < n) {
			if (row + 1 == m || col + 1 == n)
				break;
			prev = mat[row + 1][col];
			for (int i = 1; i < n; i++) {
				curr = mat[row][i];
				mat[row][i] = prev;
				prev = curr;
			}
			row++;
			for (int i = row; i < m; i++) {
				curr = mat[i][n - 1];
				mat[i][n - 1] = prev;
				prev = curr;
			}
			n--;
			if (row < m) {
				for (int i = n - 1; i >= col; i--) {
					curr = mat[m - 1][i];
					mat[m - 1][i] = prev;
					prev = curr;
				}
			}
			m--;
			if (col < n) {
				for (int i = m - 1; i >= row; i--) {
					curr = mat[i][col];
					mat[i][col] = prev;
					prev = curr;
				}
			}
			col++;
		}
	}

	private void populateMatchList(List<Match> matchList, Team[][] teamArr, boolean b) {
		for (int i = 0; i < teamArr[0].length; i++) {
			Match match = new Match();
			match.setTeam1(teamArr[0][i]);
			match.setTeam2(teamArr[1][i]);
			match.setVenue(b == true ? teamArr[0][i].getHomeGround() : teamArr[1][i].getHomeGround());
			matchList.add(match);
		}
	}

	private Team[][] initializeTeamArr(Team[][] teamArr, List<Team> teamListDB) {
		int halfLength = teamListDB.size() / 2;
		int curr = 0, listIndex = 0;
		for(int i = 0; i < 2; i++) {
			curr = 0;
			while(curr < halfLength) {
				teamArr[i][curr] = teamListDB.get(listIndex);
				curr++;
				listIndex++;
			}
		}
		return teamArr;
	}

	private void populatDummyResponse(CreateScheduleResponse response) {
		List<MatchVO> matches = new ArrayList<>();
		MatchVO match = new MatchVO();
		match.setTeam1("RCB");
		match.setTeam2("CSK");
		match.setVenue("M.Chinnaswamy Stadium");
		matches.add(match);

		match = new MatchVO();
		match.setTeam1("MI");
		match.setTeam2("SRH");
		match.setVenue("Wankhede Stadium");
		matches.add(match);

		Map<String, List<MatchVO>> map = new HashMap<>();
		map.put("Day1", matches);

		response.setMap(map);
		response.setName("Schedule1");
	}

}
