package dev.fatamorgana.toyrobot.command.factory;

import dev.fatamorgana.toyrobot.command.CommandParser;
import dev.fatamorgana.toyrobot.model.TableTop;

public interface RobotFactory {
	CommandParser createCommandParser();
	TableTop createTableTop();
}
