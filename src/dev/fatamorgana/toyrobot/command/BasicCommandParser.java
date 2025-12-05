package dev.fatamorgana.toyrobot.command;

import dev.fatamorgana.toyrobot.model.Direction;

public class BasicCommandParser {
	public InitializeCommand parseInit(String input) {
		if (input == null) {
			throw new IllegalArgumentException("Input is null.");
		}
		String[] token = input.split(" ");
		if (token.length !=2)
			throw new IllegalArgumentException("Unsupported command:" + input);
		String command = token[0];
		if (!"PLACE".equalsIgnoreCase(command))
			throw new IllegalArgumentException("Unsupported command:" + input);
		String[] args = token[1].split(",");
		if (args.length !=3) {
			throw new IllegalArgumentException("Unsupported PLACE arguments:" + input);
		}
		try {
			int positionX = Integer.parseInt(args[0]);
			int positionY = Integer.parseInt(args[1]);
			Direction direction = Direction.valueOf(args[2].toUpperCase());
			return new PlaceCommand(positionX, positionY, direction);
		} catch(Exception e) {
			throw new IllegalArgumentException("Unsupported PLACE arguments:" + input);
		}
	}
	
	public GenericCommand parseGenericCommand(String input) {
		if (input == null) {
			throw new IllegalArgumentException("Input is null.");
		}
		String testing = input.trim().toUpperCase();
		switch(testing) {
			case "MOVE": return new MoveCommand();
			case "LEFT": return new LeftCommand();
			case "RIGHT": return new RightCommand();
			case "REPORT": return new ReportCommand();
			default: return new NullCommand();
		}
	}
}
