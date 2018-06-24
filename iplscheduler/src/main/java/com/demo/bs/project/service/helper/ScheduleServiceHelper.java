package com.demo.bs.project.service.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.demo.bs.project.domain.Day;
import com.demo.bs.project.domain.Match;
import com.demo.bs.project.domain.Team;
import com.demo.bs.project.vo.CreateScheduleRequest;

@Component
public class ScheduleServiceHelper {
	
	public List<Day> createDayList(List<Team> teamListDB, CreateScheduleRequest request) {
		if (teamListDB.size() % 2 != 0) {
			Team dummy = new Team();
			dummy.setDummy(true);
			teamListDB.add(dummy);
		}
		List<Match> matchList = createMatchList(teamListDB);
		List<Day> days = new ArrayList<>();
		Day day = null;
		int daycounter = 0;
		for (int i = 0; i < matchList.size(); i++) {
			if (i % request.getMatchesPerDay() == 0) {
				daycounter++;
				day = new Day(daycounter, new ArrayList<Match>());
			}
			day.getMatches().add(matchList.get(i));
			if ((i + 1) % request.getMatchesPerDay() == 0) {
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
		while (originalTeamArr[1][0] != tempTeam) {
			populateMatchList(matchList, originalTeamArr, true);
			rotateLeft(2, teamListDB.size() / 2, originalTeamArr);
		}
		populateMatchList(matchList, originalTeamArr, false);
		rotateLeft(2, teamListDB.size() / 2, originalTeamArr);
		while (originalTeamArr[1][0] != tempTeam) {
			populateMatchList(matchList, originalTeamArr, false);
			rotateLeft(2, teamListDB.size() / 2, originalTeamArr);
		}
		return matchList;
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
		for (int i = 0; i < 2; i++) {
			curr = 0;
			while (curr < halfLength) {
				teamArr[i][curr] = teamListDB.get(listIndex);
				curr++;
				listIndex++;
			}
		}
		return teamArr;
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

}
