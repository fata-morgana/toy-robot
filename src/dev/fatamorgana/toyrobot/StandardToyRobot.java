package dev.fatamorgana.toyrobot;

import dev.fatamorgana.toyrobot.model.Robot;
import dev.fatamorgana.toyrobot.model.TableTop;

public class StandardToyRobot {
	private Robot robot;
	private TableTop tableTop;
	
	public StandardToyRobot(Robot robot, TableTop tableTop) {
		super();
		this.robot = robot;
		this.tableTop = tableTop;
	}
	
	public Robot getRobot() {
		return robot;
	}
	public TableTop getTableTop() {
		return tableTop;
	}
}
