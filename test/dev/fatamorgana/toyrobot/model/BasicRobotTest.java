package dev.fatamorgana.toyrobot.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class BasicRobotTest {
	private static final int INIT_X_POS = 1;
	private static final int INIT_Y_POS = 1;

	@Test
	public void testMove() {
		testMoveOnNorth();
		testMoveOnEast();
		testMoveOnSouth();
		testMoveOnWest();
	}
	
	public void testMoveOnNorth() {
		BasicRobot testRobot = createTestingRobot(Direction.NORTH);
		testRobot.move();
		assertEquals(1, testRobot.getPositionX());
		assertEquals(2, testRobot.getPositionY());
		assertEquals(Direction.NORTH, testRobot.getDirection());
	}

	public void testMoveOnEast() {
		BasicRobot testRobot = createTestingRobot(Direction.EAST);
		testRobot.move();
		assertEquals(2, testRobot.getPositionX());
		assertEquals(1, testRobot.getPositionY());
		assertEquals(Direction.EAST, testRobot.getDirection());
	}

	public void testMoveOnSouth() {
		BasicRobot testRobot = createTestingRobot(Direction.SOUTH);
		testRobot.move();
		assertEquals(1, testRobot.getPositionX());
		assertEquals(0, testRobot.getPositionY());
		assertEquals(Direction.SOUTH, testRobot.getDirection());
	}

	public void testMoveOnWest() {
		BasicRobot testRobot = createTestingRobot(Direction.WEST);
		testRobot.move();
		assertEquals(0, testRobot.getPositionX());
		assertEquals(1, testRobot.getPositionY());
		assertEquals(Direction.WEST, testRobot.getDirection());
	}
	
	@Test
	public void testTurnLeft() {
		BasicRobot testRobot = createTestingRobot(Direction.NORTH);
		testRobot.turnLeft();
		assertEquals(Direction.WEST, testRobot.getDirection());
		testRobot.turnLeft();
		assertEquals(Direction.SOUTH, testRobot.getDirection());
		testRobot.turnLeft();
		assertEquals(Direction.EAST, testRobot.getDirection());
		testRobot.turnLeft();
		assertEquals(Direction.NORTH, testRobot.getDirection());
	}
	
	@Test
	public void testTurnRight() {
		BasicRobot testRobot = createTestingRobot(Direction.NORTH);
		testRobot.turnRight();
		assertEquals(Direction.EAST, testRobot.getDirection());
		testRobot.turnRight();
		assertEquals(Direction.SOUTH, testRobot.getDirection());
		testRobot.turnRight();
		assertEquals(Direction.WEST, testRobot.getDirection());
		testRobot.turnRight();
		assertEquals(Direction.NORTH, testRobot.getDirection());
	}
	
	@Test
	public void testReport() {
		BasicRobot testRobot = createTestingRobot(Direction.NORTH);
		assertEquals("1,1,NORTH", testRobot.report());
	}
	
	private BasicRobot createTestingRobot(Direction direction) {
		return new BasicRobot(INIT_X_POS, INIT_Y_POS, direction);
	}
}
