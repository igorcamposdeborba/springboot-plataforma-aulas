package com.devsuperior.dslearnbds.entities.learnship.enums;

public enum ResourceType {
	LESSON_ONLY (0),
	LESSON_TASK (1),
	FORUM (2),
	EXTERNAL_LINK (3);
	
	private final int option;
	
	ResourceType(int option) {
		this.option = option;
	}
	
	public int getOption() {
		return option;
	}
	
}
