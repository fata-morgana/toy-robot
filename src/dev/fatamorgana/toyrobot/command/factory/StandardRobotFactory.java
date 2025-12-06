package dev.fatamorgana.toyrobot.command.factory;

import dev.fatamorgana.toyrobot.command.BasicCommandParser;
import dev.fatamorgana.toyrobot.command.CommandParser;
import dev.fatamorgana.toyrobot.model.BasicTableTop;
import dev.fatamorgana.toyrobot.model.TableTop;

public class StandardRobotFactory implements RobotFactory {

	@Override
	public CommandParser createCommandParser() {
		return new BasicCommandParser();
	}

	@Override
	public TableTop createTableTop() {
		return BasicTableTop.createDefault();
	}

}
