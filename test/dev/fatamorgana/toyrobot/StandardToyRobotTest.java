package dev.fatamorgana.toyrobot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dev.fatamorgana.toyrobot.command.factory.RobotFactory;
import dev.fatamorgana.toyrobot.command.factory.StandardRobotFactory;

public class StandardToyRobotTest {

	private ByteArrayOutputStream outContent = null;
	private final InputStream originalIn = System.in;
	private final PrintStream originalOut = System.out;
	
	private final RobotFactory robotFactory = new StandardRobotFactory();
	
	@Test
	public void testHappyScenario() {
        String input =
                "PLACE 0,0,NORTH\n" +
                "MOVE\n" +
                "REPORT\n";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        
        new StandardToyRobot(robotFactory).run(in, new PrintStream(outContent));
        
        assertEquals("Welcome to Toy Robot simulator. CTRL+D to exit. Enter command:\n"
        		+ "0,1,NORTH\n", outContent.toString());
	}
	
	@Test
	public void testValidPlaceIsNotAFirstCommand() {
        String input =
        		"MOVE\n" +
                "PLACE A,B,C\n";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        
        new StandardToyRobot(robotFactory).run(in, new PrintStream(outContent));
        
        assertEquals("Welcome to Toy Robot simulator. CTRL+D to exit. Enter command:\n" +
        		"[DEBUG] Unsupported command:MOVE\n" +
        		"Valid `PLACE` must be the first command.\n" +
        		"[DEBUG] Unsupported PLACE arguments:A,B,C\n" +
        		"Valid `PLACE` must be the first command.\n", outContent.toString());
	}

	@Before
	public void setUp() {
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
	}
	
	@After
	public void tearDown() {
		System.setIn(originalIn);
		System.setOut(originalOut);
	}
}
