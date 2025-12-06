package dev.fatamorgana.toyrobot.command;

import dev.fatamorgana.toyrobot.model.Direction;
import dev.fatamorgana.toyrobot.model.Robot;
import dev.fatamorgana.toyrobot.model.BasicRobot;
import dev.fatamorgana.toyrobot.model.TableTop;

public class PlaceCommand implements InitializeCommand {
	private final int robotPositionX;
	private final int robotPositionY;
	private final Direction robotDirection;
	
	public PlaceCommand(int robotPositionX, int robotPositionY, Direction robotDirection) {
		this.robotPositionX = robotPositionX;
		this.robotPositionY = robotPositionY;
		this.robotDirection = robotDirection;
	}	

	@Override
	public Robot init(TableTop tableTop) {
		if(tableTop.isValidPosition(robotPositionX, robotPositionY))
			return new BasicRobot(robotPositionX, robotPositionY, robotDirection);
		
		throw new IllegalArgumentException(String.format("[%s,%s] is not a valid initial placement.", robotPositionX, robotPositionY));
	}
}
