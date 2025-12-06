package dev.fatamorgana.toyrobot.command;

import dev.fatamorgana.toyrobot.model.BasicRobot;
import dev.fatamorgana.toyrobot.model.TableTop;

public interface GenericCommand {
	void execute(BasicRobot robot, TableTop tableTop);
}
