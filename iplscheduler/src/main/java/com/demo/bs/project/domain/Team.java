package com.demo.bs.project.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "team")
public class Team {
	@Id
	@GeneratedValue
	@Column(name = "teamid")
	private Long teamId;

	private String name;

}
