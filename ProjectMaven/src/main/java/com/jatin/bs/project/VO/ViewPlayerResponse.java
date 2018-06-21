package com.jatin.bs.project.VO;

import java.util.ArrayList;
import java.util.List;

import com.jatin.bs.project.BO.PlayerBO;

import lombok.Data;

@Data
public class ViewPlayerResponse {
	
	private List<PlayerBO> players = new ArrayList<>();

}
