package dev.fatamorgana.toyrobot.command;

import dev.fatamorgana.toyrobot.App;
import dev.fatamorgana.toyrobot.model.BasicRobot;
import dev.fatamorgana.toyrobot.model.Robot;
import dev.fatamorgana.toyrobot.model.TableTop;

public class MoveCommand implements GenericCommand {

	@Override
	public void execute(Robot robot, TableTop tableTop) {
		BasicRobot currentRobot = (BasicRobot) robot;
		BasicRobot newRobot = new BasicRobot(currentRobot.getPositionX(), currentRobot.getPositionY(), currentRobot.getDirection());
		newRobot.move();
		if (tableTop.isValidPosition(newRobot.getPositionX(), newRobot.getPositionY()))
			robot.move();
		else
			if(App.DEBUG_MODE)
				System.out.println("[DEBUG] Move command failed. Can't move out of bound.");
	}

}
