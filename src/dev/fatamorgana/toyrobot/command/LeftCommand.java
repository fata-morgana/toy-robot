package dev.fatamorgana.toyrobot.command;

import dev.fatamorgana.toyrobot.model.BasicRobot;
import dev.fatamorgana.toyrobot.model.TableTop;

public class LeftCommand implements GenericCommand {

	@Override
	public void execute(BasicRobot robot, TableTop tableTop) {
		robot.turnLeft();
	}

}
