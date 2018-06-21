package com.jatin.bs.project.BO;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
//@Table(name = "team") 
public class TeamBO {
	
	@Id
	@GeneratedValue
	@Column(name = "teamid")
	private Long teamId;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "companyIdRef", referencedColumnName = "companyId")
	private List<PlayerBO> playerList;

	@Column(name = "homeground")
	private CityBO homeground;
	
	@Column(name = "points")
	private Integer points;
	
}
