package com.jatin.bs.project.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.jatin.bs.project.BO.PlayerBO;
import com.jatin.bs.project.VO.CommitPlayerRequest;
import com.jatin.bs.project.dao.IPLDao;
import com.jatin.bs.project.repository.PlayerRepository;
import com.jatin.bs.project.service.PlayerService;

public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private IPLDao iplDao;

	@Autowired
	private PlayerRepository playerRepository;

	@Override
	public Optional<PlayerBO> viewPlayerById(Long playerId) {
		return playerRepository.findById(playerId);
	}

	@Override
	public List<PlayerBO> viewAllPlayers() {
		return playerRepository.findAll();
	}

	@Override
	public void deletePlayerById(long playerid) {
		iplDao.deletePlayerById(playerid);

	}

	@Override
	@Transactional
	public PlayerBO addPlayer(CommitPlayerRequest request) {
		PlayerBO player = new PlayerBO();
		player.setName(request.getName());
		player.setAge(request.getAge());
		return player;
	}

}
