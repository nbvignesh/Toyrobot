package com.toyrobot.model;

public class ToyRobot {
	
	private Integer currentRow;
	private Integer currentColoumn;
	private DirectionEnum currentDirection;
	
	public Integer getCurrentRow() {
		return currentRow;
	}
	public void setCurrentRow(Integer currentRow) {
		this.currentRow = currentRow;
	}
	public Integer getCurrentColoumn() {
		return currentColoumn;
	}
	public void setCurrentColoumn(Integer currentColoumn) {
		this.currentColoumn = currentColoumn;
	}
	public DirectionEnum getCurrentDirection() {
		return currentDirection;
	}
	public void setCurrentDirection(DirectionEnum currentDirection) {
		this.currentDirection = currentDirection;
	}

}
