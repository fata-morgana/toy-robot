package dev.fatamorgana.toyrobot.command;

import dev.fatamorgana.toyrobot.StandardToyRobot;
import dev.fatamorgana.toyrobot.model.Robot;
import dev.fatamorgana.toyrobot.model.TableTop;

public abstract class BasePlaceCommand implements InitializeCommand {

	@Override
	public StandardToyRobot init() {
		return new StandardToyRobot(newRobot(), newTableTop());
	}
	
	protected abstract Robot newRobot();
	protected abstract TableTop newTableTop();

}
