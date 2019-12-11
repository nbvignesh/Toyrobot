package com.toyrobot.service;

import com.toyrobot.model.DirectionEnum;
import com.toyrobot.model.ToyRobot;

public class ToyRobotService {
	
	private static final Integer maximumRow = 4;
	private static final Integer maximumColumn = 4;
	
	private ToyRobot toyRobot; 
	
	public ToyRobotService() {
		
		toyRobot = new ToyRobot();
	}
	
	public void place(Integer row, Integer column, DirectionEnum directionEnum) {
		
		if(validPosition(row,column)) {
			
			setToyRobotPosition(row, column, directionEnum);
		}
	}
	
	public void faceLeft() {

		DirectionEnum currentDirection = toyRobot.getCurrentDirection();
		DirectionEnum newDirection = null;
		if(currentDirection != null) {
			switch (currentDirection) {
			
			case EAST:
				newDirection=DirectionEnum.NORTH;
				break;
			case NORTH:
				newDirection=DirectionEnum.WEST;
				break;
			case SOUTH:
				newDirection=DirectionEnum.EAST;
				break;
			case WEST:
				newDirection=DirectionEnum.SOUTH;
				break;
			default:
				break;
			}

			if(newDirection != null) {
				toyRobot.setCurrentDirection(newDirection);
			}
		}
	}

	public void faceRight() {

		DirectionEnum currentDirection = toyRobot.getCurrentDirection();
		DirectionEnum newDirection = null;
		if(currentDirection != null) {
			switch (currentDirection) {

				case EAST:
					newDirection=DirectionEnum.SOUTH;
					break;
				case NORTH:
					newDirection=DirectionEnum.EAST;
					break;
				case SOUTH:
					newDirection=DirectionEnum.WEST;
					break;
				case WEST:
					newDirection=DirectionEnum.NORTH;
					break;
				default:
					break;
			}

			if(newDirection != null) {
				toyRobot.setCurrentDirection(newDirection);
			}
		}
	}

	public void move() {

		DirectionEnum currentDirection = toyRobot.getCurrentDirection();
		Integer currentRow = toyRobot.getCurrentRow();
		Integer currentColumn = toyRobot.getCurrentColoumn();
		
		Integer newRow = null;
		Integer newColumn = null;
		
		if(currentDirection != null) {
			switch (currentDirection) {

				case EAST:
					newRow = currentRow + 1;
					newColumn = currentColumn;
					break;
				case NORTH:
					newRow = currentRow;
					newColumn = currentColumn + 1;
					break;
				case SOUTH:
					newRow = currentRow;
					newColumn = currentColumn - 1;
					break;
				case WEST:
					newRow = currentRow - 1;
					newColumn = currentColumn;
					break;
				default:
					break;
			}

			if(validPosition(newRow,newColumn)) {

				setToyRobotPosition(newRow,newColumn,currentDirection);
			}
		}

	}
	
	public ToyRobot report() {
		
		System.out.println("Output:"+toyRobot.getCurrentRow()+","+toyRobot.getCurrentColoumn()+","+toyRobot.getCurrentDirection());
		return toyRobot;
	}

	private void setToyRobotPosition(Integer row, Integer column, DirectionEnum directionEnum) {
		
		toyRobot.setCurrentRow(row);
		toyRobot.setCurrentColoumn(column);
		toyRobot.setCurrentDirection(directionEnum);

	}

	private boolean validPosition(Integer row, Integer column) {
		
		return (row < 0 || row > maximumRow || column < 0 || column > maximumColumn) ? false : true;
	}

}
