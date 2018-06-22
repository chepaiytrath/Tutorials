package com.demo.bs.project.service.impl;

import org.springframework.stereotype.Component;

import com.demo.bs.project.service.PlayerService;

@Component("playerService")
public class PlayerServiceImpl implements PlayerService {

	public void whoami() {
		System.out.println("I am PlayerServiceImpl");
		
	}
	

}
