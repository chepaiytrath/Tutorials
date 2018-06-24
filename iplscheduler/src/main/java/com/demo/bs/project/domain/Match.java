package com.demo.bs.project.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "match")
public class Match {
	@Id
	@GeneratedValue
	@Column(name = "matchid")
	private Long matchId;

	@JoinColumn(name = "team1_id")
	@OneToOne
	private Team team1;
	
	@JoinColumn(name = "team2_id")
	@OneToOne
	private Team team2;

	@Column(name = "venue")
	private String venue;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Match [matchId=");
		builder.append(matchId);
		builder.append(", team1=");
		builder.append(team1.getTeamId());
		builder.append(", team2=");
		builder.append(team2.getTeamId());
		builder.append(", venue=");
		builder.append(venue);
		builder.append("]");
		return builder.toString();
	}
	
}
