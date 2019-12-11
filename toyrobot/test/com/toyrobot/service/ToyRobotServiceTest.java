package com.toyrobot.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.toyrobot.model.DirectionEnum;
import com.toyrobot.model.ToyRobot;

public class ToyRobotServiceTest {

	@Test
	public void testPlaceToyRobotService_AcceptanceTests() {

		ToyRobotService testee = new ToyRobotService();

		testee.place(0, 0, DirectionEnum.NORTH);

		testee.move();

		assertPositions(testee.report(), 0, 1, DirectionEnum.NORTH);

		testee.place(0, 0, DirectionEnum.NORTH);

		testee.faceLeft();

		assertPositions(testee.report(), 0, 0, DirectionEnum.WEST);

		testee.place(1, 2, DirectionEnum.EAST);

		testee.move();

		testee.move();

		testee.faceLeft();

		testee.move();

		assertPositions(testee.report(), 3, 3, DirectionEnum.NORTH);

	}

	@Test
	public void testPlaceToyRobotService_Exception_Conditions_Should_NOT_Alter_Current_State() {

		ToyRobotService testee = new ToyRobotService();
		
		testee.place(0, 0, DirectionEnum.NORTH);
		
		assertPositions(testee.report(), 0, 0, DirectionEnum.NORTH);
		
		// invalid position should not impact current position.
		testee.place(5, 0, DirectionEnum.NORTH);
		
		assertPositions(testee.report(), 0, 0, DirectionEnum.NORTH);
		
		testee.place(4, 4, DirectionEnum.EAST);
		
		assertPositions(testee.report(), 4, 4, DirectionEnum.EAST);
		
		//invalid position should not impact current position
		testee.move();
		
		assertPositions(testee.report(), 4, 4, DirectionEnum.EAST);
		
		testee.place(4, 4, DirectionEnum.WEST);
		testee.move();
		
		assertPositions(testee.report(), 3, 4, DirectionEnum.WEST);

	}

	private void assertPositions(ToyRobot robot, Integer row, Integer column, DirectionEnum directionEnum) {

		assertEquals(row, robot.getCurrentRow());
		assertEquals(column, robot.getCurrentColoumn());
		assertEquals(directionEnum, robot.getCurrentDirection());
	}

}
