package com.jatin.bs.project.dao;

import org.springframework.beans.factory.annotation.Qualifier;

import com.jatin.bs.project.BO.PlayerBO;

@Qualifier("dao")
public interface IPLDao {

	public void addPlayer(PlayerBO player);

	public void deletePlayerById(long playerid);

}
