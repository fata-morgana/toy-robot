package dev.fatamorgana.toyrobot;

import dev.fatamorgana.toyrobot.model.BasicRobot;
import dev.fatamorgana.toyrobot.model.TableTop;

public class StandardToyRobot {
	private final BasicRobot robot;
	private final TableTop tableTop;
	
	public StandardToyRobot(BasicRobot robot, TableTop tableTop) {
		this.robot = robot;
		this.tableTop = tableTop;
	}
	
	public BasicRobot getRobot() {
		return robot;
	}
	public TableTop getTableTop() {
		return tableTop;
	}
}
