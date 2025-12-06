package dev.fatamorgana.toyrobot.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class BasicCommandParserTest {
	private static final CommandParser commandParser = new BasicCommandParser();
	
	@Test
	public void testParseInitCommandTooFewParam() {
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
				() -> commandParser.parseInitCommand("PLACE"));
		assertEquals("Unsupported command:PLACE", ex.getMessage());
	}
	
	@Test
	public void testParseInitCommandTooManyArgsParam() {
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
				() -> commandParser.parseInitCommand("PLACE 1,1,NORTH 2,2,SOUTH"));
		assertEquals("Unsupported command:PLACE 1,1,NORTH 2,2,SOUTH", ex.getMessage());
	}
	
	@Test
	public void testParserInitCommandUnsupported() {
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
				() -> commandParser.parseInitCommand("NOTPLACE 1,1,NORTH"));
		assertEquals("Unsupported command:NOTPLACE 1,1,NORTH", ex.getMessage());
	}
	
	@Test
	public void testParseInitCommandTooFewArg() {
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
				() -> commandParser.parseInitCommand("PLACE 1,1"));
		assertEquals("Unsupported PLACE arguments:1,1", ex.getMessage());
	}
	
	@Test
	public void testParseInitCommandTooManyArg() {
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
				() -> commandParser.parseInitCommand("PLACE 1,1,NORTH,WHAT"));
		assertEquals("Unsupported PLACE arguments:1,1,NORTH,WHAT", ex.getMessage());
	}
	
	@Test
	public void testParseInitCommandUnparsablePlace() {
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
				() -> commandParser.parseInitCommand("PLACE 1,1,SomeWhere"));
		assertEquals("Unsupported PLACE arguments:1,1,SomeWhere", ex.getMessage());
	}
	
	@Test
	public void testParseInitCommandPass() {
		InitializeCommand command = commandParser.parseInitCommand("PLACE 1,1,NORTH");
		assertTrue(command.getClass() == PlaceCommand.class);
	}
	
	@Test
	public void testUnsuportedCommand() {
		GenericCommand command = commandParser.parseGenericCommand("SomeUnknownCommand");
		assertTrue(command.getClass() == NullCommand.class);
	}
	
	@Test
	public void testLeftCommand() {
		GenericCommand command = commandParser.parseGenericCommand("LEFT");
		assertTrue(command.getClass() == LeftCommand.class);
	}
	
	@Test
	public void testRightCommand() {
		GenericCommand command = commandParser.parseGenericCommand("RIGHT");
		assertTrue(command.getClass() == RightCommand.class);
	}
	
	@Test
	public void testMoveCommand() {
		GenericCommand command = commandParser.parseGenericCommand("MOVE");
		assertTrue(command.getClass() == MoveCommand.class);
	}
	
	@Test
	public void testReportCommand() {
		GenericCommand command = commandParser.parseGenericCommand("REPORT");
		assertTrue(command.getClass() == ReportCommand.class);
	}
}
