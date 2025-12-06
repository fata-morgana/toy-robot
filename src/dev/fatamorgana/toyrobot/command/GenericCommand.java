package dev.fatamorgana.toyrobot.command;

import dev.fatamorgana.toyrobot.model.Robot;
import dev.fatamorgana.toyrobot.model.TableTop;

public interface GenericCommand {
	void execute(Robot robot, TableTop tableTop);
}
