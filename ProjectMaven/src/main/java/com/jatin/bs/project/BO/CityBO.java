package com.jatin.bs.project.BO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
//@Table(name = "city") 
public class CityBO {
	
	@Id
	@GeneratedValue
	private Long cityId;
	
	private String name;
	
}
