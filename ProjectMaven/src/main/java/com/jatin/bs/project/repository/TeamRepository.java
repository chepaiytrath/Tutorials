package com.jatin.bs.project.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jatin.bs.project.BO.TeamBO;

@Repository
public class TeamRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public TeamBO findById(Long id) {
		return jdbcTemplate.queryForObject("select * from team where playerid=?", new Object[] { id },
				new BeanPropertyRowMapper<TeamBO>(TeamBO.class));
	}

}