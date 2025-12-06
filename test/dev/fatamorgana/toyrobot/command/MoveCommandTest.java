package dev.fatamorgana.toyrobot.command;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dev.fatamorgana.toyrobot.model.BasicRobot;
import dev.fatamorgana.toyrobot.model.BasicTableTop;
import dev.fatamorgana.toyrobot.model.Direction;
import dev.fatamorgana.toyrobot.model.TableTop;

public class MoveCommandTest {
	private final MoveCommand moveCommand = new MoveCommand();

	private ByteArrayOutputStream outContent = null;
	private final PrintStream originalOut = System.out;

	TableTop tableTop = BasicTableTop.createWithDimension(3, 3);
	
	@Test
	public void testValidMove() {		
		BasicRobot robot1 = new BasicRobot(1, 1, Direction.NORTH);
		moveCommand.execute(robot1, tableTop);
		assertEquals(robot1.getPositionX(), 1);
		assertEquals(robot1.getPositionY(), 2);
		
		BasicRobot robot2 = new BasicRobot(1, 1, Direction.EAST);
		moveCommand.execute(robot2, tableTop);
		assertEquals(robot2.getPositionX(), 2);
		assertEquals(robot2.getPositionY(), 1);
		
		BasicRobot robot3 = new BasicRobot(1, 1, Direction.SOUTH);
		moveCommand.execute(robot3, tableTop);
		assertEquals(robot3.getPositionX(), 1);
		assertEquals(robot3.getPositionY(), 0);
		
		BasicRobot robot4 = new BasicRobot(1, 1, Direction.WEST);
		moveCommand.execute(robot4, tableTop);
		assertEquals(robot4.getPositionX(), 0);
		assertEquals(robot4.getPositionY(), 1);		
	}
	
	@Test
	public void testInvalidMoveNorth() throws IOException {
		BasicRobot robot1 = new BasicRobot(1, 2, Direction.NORTH);
		moveCommand.execute(robot1, tableTop);
		assertEquals("Move command failed. Can't move out of bound.\n", outContent.toString());
		
	}
	
	@Test
	public void testInvalidMoveEast() throws IOException {
		BasicRobot robot2 = new BasicRobot(2, 1, Direction.EAST);
		moveCommand.execute(robot2, tableTop);
		assertEquals("Move command failed. Can't move out of bound.\n", outContent.toString());
	}
	
	@Test
	public void testInvalidMoveSouth() throws IOException {		
		BasicRobot robot3 = new BasicRobot(1, 0, Direction.SOUTH);
		moveCommand.execute(robot3, tableTop);
		assertEquals("Move command failed. Can't move out of bound.\n", outContent.toString());
	}
	
	@Test
	public void testInvalidMoveWest() throws IOException {
		BasicRobot robot4 = new BasicRobot(0, 1, Direction.WEST);
		moveCommand.execute(robot4, tableTop);
		assertEquals("Move command failed. Can't move out of bound.\n", outContent.toString());
	}


	@Before
	public void setUp() {
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
	}
	
	@After
	public void tearDown() {
		System.setOut(originalOut);
	}
}
