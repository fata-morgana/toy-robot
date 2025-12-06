package dev.fatamorgana.toyrobot.command;

import dev.fatamorgana.toyrobot.model.Robot;
import dev.fatamorgana.toyrobot.model.TableTop;

public class RightCommand implements GenericCommand {

	@Override
	public void execute(Robot robot, TableTop tableTop) {
		robot.turnRight();
	}

}
