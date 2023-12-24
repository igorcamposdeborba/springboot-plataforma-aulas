package com.devsuperior.dslearnbds.entities.learnship.classroom.enums;

public enum DeliverStatus {
	PENDING (1),
	ACCEPTED (2),
	REJECTED (3);

	private int status;
	
	DeliverStatus(int status) {
		this.status = status;
	}
	
	public int getStatus() {
		return status;
	}
}
