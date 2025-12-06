package dev.fatamorgana.toyrobot.command;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;
import org.mockito.Mockito;

import dev.fatamorgana.toyrobot.model.BasicRobot;
import dev.fatamorgana.toyrobot.model.TableTop;

public class NullCommandTest {
	private final NullCommand command = new NullCommand();
	@Test
	public void testNullCommand() {
		PrintStream originalOut = System.out;
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		command.execute(Mockito.mock(BasicRobot.class), Mockito.mock(TableTop.class));
		assertEquals("Doing nothing. Unsupported operation.\n", outContent.toString());
		
		System.setOut(originalOut);
	}
}
