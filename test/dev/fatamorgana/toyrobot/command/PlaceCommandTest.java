package dev.fatamorgana.toyrobot.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

import dev.fatamorgana.toyrobot.StandardToyRobot;
import dev.fatamorgana.toyrobot.model.BasicRobot;
import dev.fatamorgana.toyrobot.model.BasicTableTop;
import dev.fatamorgana.toyrobot.model.Direction;
import dev.fatamorgana.toyrobot.model.Robot;
import dev.fatamorgana.toyrobot.model.TableTop;

public class PlaceCommandTest {
	private final TableTop tableTop = BasicTableTop.createDefault();
	
	@Test
	public void testValidPlacementBottomLeft() {
		PlaceCommand placeCommand = new PlaceCommand(0, 0, Direction.NORTH);
		BasicRobot toyRobot = (BasicRobot) placeCommand.init(tableTop);
		assertEquals(0, toyRobot.getPositionX());
		assertEquals(0, toyRobot.getPositionY());
		assertEquals(Direction.NORTH, toyRobot.getDirection());
	}
	
	@Test
	public void testValidPlacementUpperRight() {
		PlaceCommand placeCommand = new PlaceCommand(4, 4, Direction.SOUTH);
		BasicRobot toyRobot = (BasicRobot) placeCommand.init(tableTop);
		assertEquals(4, toyRobot.getPositionX());
		assertEquals(4, toyRobot.getPositionY());
		assertEquals(Direction.SOUTH, toyRobot.getDirection());
	}
	
	@Test
	public void testOutOfBoundLeft() {
		PlaceCommand placeCommand = new PlaceCommand(-1, 0, Direction.SOUTH);
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
				() -> placeCommand.init(tableTop));
		assertEquals("[-1,0] is not a valid initial placement.", ex.getMessage());
	}
	
	@Test
	public void testOutOfBoundRight() {
		PlaceCommand placeCommand = new PlaceCommand(5, 4, Direction.SOUTH);
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
				() -> placeCommand.init(tableTop));
		assertEquals("[5,4] is not a valid initial placement.", ex.getMessage());
	}
	
	@Test
	public void testOutOfBoundTop() {
		PlaceCommand placeCommand = new PlaceCommand(4, 5, Direction.SOUTH);
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
				() -> placeCommand.init(tableTop));
		assertEquals("[4,5] is not a valid initial placement.", ex.getMessage());
	}
	
	@Test
	public void testOutOfBoundBottom() {
		PlaceCommand placeCommand = new PlaceCommand(0, -1, Direction.SOUTH);
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
				() -> placeCommand.init(tableTop));
		assertEquals("[0,-1] is not a valid initial placement.", ex.getMessage());
	}
}
