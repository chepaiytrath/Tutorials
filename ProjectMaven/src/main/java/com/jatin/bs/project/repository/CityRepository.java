package com.jatin.bs.project.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jatin.bs.project.BO.CityBO;

@Repository
public class CityRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public CityBO findById(Long id) {
		return jdbcTemplate.queryForObject("select * from city where cityid=?", new Object[] { id },
				new BeanPropertyRowMapper<CityBO>(CityBO.class));
	}

}