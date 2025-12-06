package dev.fatamorgana.toyrobot;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import dev.fatamorgana.toyrobot.command.CommandParser;
import dev.fatamorgana.toyrobot.command.GenericCommand;
import dev.fatamorgana.toyrobot.command.InitializeCommand;
import dev.fatamorgana.toyrobot.command.factory.RobotFactory;
import dev.fatamorgana.toyrobot.model.BasicRobot;
import dev.fatamorgana.toyrobot.model.TableTop;

public class StandardToyRobot {
	private static boolean IS_ROBOT_PLACE = false;
	private final CommandParser commandParser;
	private final TableTop tableTop;
	
	public StandardToyRobot(RobotFactory robotFactory) {
		this.commandParser = robotFactory.createCommandParser();
		this.tableTop = robotFactory.createTableTop();
	}
	
	public void run(InputStream in, OutputStream out) {
		final PrintStream originalOut = System.out;
		System.setOut(new PrintStream(out));
		
		System.out.println("Welcome to Toy Robot simulator. CTRL+D to exit. Enter command:");
		try (Scanner scanner = new Scanner(in)) {
			BasicRobot robot = null;
			while(scanner.hasNextLine() ) {
				String input = scanner.nextLine();
				
				// Until valid PLACE command is entered, other commands are rejected
				if (!IS_ROBOT_PLACE) {
					try {
						InitializeCommand initCommand = commandParser.parseInitCommand(input);
						robot = (BasicRobot) initCommand.init(tableTop);
					} catch (IllegalArgumentException ex) {
						if (App.DEBUG_MODE)
							System.out.println("[DEBUG] " + ex.getMessage());
						System.out.println("Valid `PLACE` must be the first command.");
						continue;
					}
					IS_ROBOT_PLACE = true;
				}
				else {
					try {
						GenericCommand command = commandParser.parseGenericCommand(input);
						command.execute(robot, tableTop);
					} catch (IllegalArgumentException ex) {
						if (App.DEBUG_MODE)
							System.out.println(">>>" + ex.getMessage());
						continue;
					}
				}
			}
		}
		System.setOut(originalOut);
	}
}
