package dev.fatamorgana.toyrobot.command;

import dev.fatamorgana.toyrobot.App;
import dev.fatamorgana.toyrobot.model.BasicRobot;
import dev.fatamorgana.toyrobot.model.TableTop;

public class MoveCommand implements GenericCommand {

	@Override
	public void execute(BasicRobot robot, TableTop tableTop) {
		BasicRobot newRobot = new BasicRobot(robot.getPositionX(), robot.getPositionY(), robot.getDirection());
		newRobot.move();
		if (tableTop.isValidPosition(newRobot.getPositionX(), newRobot.getPositionY()))
			robot.move();
		else
			if(App.DEBUG_MODE)
				System.out.println("Move command failed. Can't move out of bound.");
	}

}
