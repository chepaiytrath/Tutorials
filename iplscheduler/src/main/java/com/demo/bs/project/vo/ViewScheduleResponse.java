package com.demo.bs.project.vo;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class ViewScheduleResponse {
	
	private boolean success;

	private String name;

	Map<String, List<MatchVO>> map;
}
