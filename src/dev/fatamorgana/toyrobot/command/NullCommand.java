package dev.fatamorgana.toyrobot.command;

import dev.fatamorgana.toyrobot.App;
import dev.fatamorgana.toyrobot.model.BasicRobot;
import dev.fatamorgana.toyrobot.model.TableTop;

public class NullCommand implements GenericCommand {

	@Override
	public void execute(BasicRobot robot, TableTop tableTop) {
		if (App.DEBUG_MODE)
			System.out.println("Doing nothing. Unsupported operation.");
	}

}
