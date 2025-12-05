package dev.fatamorgana.toyrobot.command;

import dev.fatamorgana.toyrobot.StandardToyRobot;
import dev.fatamorgana.toyrobot.model.BasicTableTop;
import dev.fatamorgana.toyrobot.model.Direction;
import dev.fatamorgana.toyrobot.model.Robot;
import dev.fatamorgana.toyrobot.model.TableTop;

public class PlaceCommand extends BasePlaceCommand implements InitializeCommand {
	private final int robotPositionX;
	private final int robotPositionY;
	private final Direction robotDirection;
	public PlaceCommand(int robotPositionX, int robotPostionY, Direction robotDirection) {
		this.robotPositionX = robotPositionX;
		this.robotPositionY = robotPostionY;
		this.robotDirection = robotDirection;
	}
	
	protected Robot newRobot() {
		return new Robot(robotPositionX, robotPositionY, robotDirection);
	}
	
	protected TableTop newTableTop() {
		return BasicTableTop.createDefault(); 
	}

}
