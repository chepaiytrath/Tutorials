package com.jatin.bs.project.BO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
//@Table(name = "player") 
public class PlayerBO {
	
	@Id
	@GeneratedValue
	@Column(name = "playerid")
	private Long playerId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "age")
	private Integer age;
	
}
