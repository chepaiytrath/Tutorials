package com.jatin.bs.project.VO;

import lombok.Data;

@Data
public class CommitPlayerResponse {
	private boolean success;

	public void setSuccess(boolean b) {
		this.success = b;
	}
}
