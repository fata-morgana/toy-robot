package dev.fatamorgana.toyrobot.command;

import dev.fatamorgana.toyrobot.model.Robot;
import dev.fatamorgana.toyrobot.model.TableTop;

public class NullCommand implements GenericCommand {

	@Override
	public void execute(Robot robot, TableTop tableTop) {
		System.out.println("");
	}

}
