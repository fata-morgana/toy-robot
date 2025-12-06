package dev.fatamorgana.toyrobot.command;

import org.junit.Test;
import org.mockito.Mockito;

import dev.fatamorgana.toyrobot.model.BasicRobot;
import dev.fatamorgana.toyrobot.model.BasicTableTop;
import dev.fatamorgana.toyrobot.model.TableTop;

public class ReportCommandTest {

	@Test
	public void testExecuteReport() {
		BasicRobot robot = Mockito.mock(BasicRobot.class);
		TableTop tableTop = Mockito.mock(BasicTableTop.class);
		
		ReportCommand command = new ReportCommand();
		command.execute(robot, tableTop);
		Mockito.verify(robot, Mockito.times(1)).report();
	}
}
