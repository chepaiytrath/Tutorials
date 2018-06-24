package com.demo.bs.project.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "schedule")
public class Schedule {

	public Schedule(String name, List<Day> days){
		this.name = name;
		this.days = days;
	}
	
	@Id
	@GeneratedValue
	@Column(name = "scheduleid")
	private Long scheduleId;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Day> days;
	
}
