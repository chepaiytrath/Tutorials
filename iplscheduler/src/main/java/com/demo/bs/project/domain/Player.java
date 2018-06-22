package com.demo.bs.project.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "player")
public class Player {
	@Id
	@GeneratedValue
	@Column(name = "playerid")
	private Long playerId;

	private String name;

	private Integer age;
}
