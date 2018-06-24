package com.demo.bs.project.vo;

import java.util.List;
import java.util.Map;
import lombok.Data;

@Data
public class CreateScheduleResponse {
	
	private boolean success;
	
	private String name;

	Map<String, List<MatchVO>> map;
}
