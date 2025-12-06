package dev.fatamorgana.toyrobot;

import java.io.InputStream;
import java.io.OutputStream;

import dev.fatamorgana.toyrobot.command.factory.StandardRobotFactory;

public class App {
	public static boolean DEBUG_MODE = true; // TODO this can be toggled
	
	public static void main(String[] args) {
		InputStream in = System.in;
		OutputStream out = System.out;
		
		StandardToyRobot toyRobot = new StandardToyRobot(new StandardRobotFactory());
		toyRobot.run(in, out);
		
	}
}
