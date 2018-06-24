package com.demo.bs.project.domain;

import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "day")
public class Day {

	@Id
	@GeneratedValue
	@Column(name = "dayid")
	private Long dayId;
	
	private Integer dayNumber;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Match> matches;

	public Day(Integer dayNumber, List<Match> matches) {
		super();
		this.dayNumber = dayNumber;
		this.matches = matches;
	}
	 
}
