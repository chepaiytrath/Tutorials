package com.jatin.bs.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.jatin.bs.project.BO.PlayerBO;
import com.jatin.bs.project.VO.CommitPlayerRequest;

@Component
public interface PlayerService {
	List<PlayerBO> viewAllPlayers();

	Optional<PlayerBO> viewPlayerById(Long playerId);

	void deletePlayerById(long playerid);

	PlayerBO addPlayer(CommitPlayerRequest request);

}
