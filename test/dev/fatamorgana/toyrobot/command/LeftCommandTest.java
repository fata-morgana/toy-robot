package dev.fatamorgana.toyrobot.command;

import org.junit.Test;
import org.mockito.Mockito;

import dev.fatamorgana.toyrobot.model.BasicRobot;
import dev.fatamorgana.toyrobot.model.BasicTableTop;
import dev.fatamorgana.toyrobot.model.TableTop;

public class LeftCommandTest {

	@Test
	public void testLeftCommand() {
		BasicRobot robot = Mockito.mock(BasicRobot.class);
		TableTop tableTop = Mockito.mock(BasicTableTop.class);
		GenericCommand command = new LeftCommand();
		Mockito.doNothing().when(robot).turnLeft();
		command.execute(robot, tableTop);
		
		Mockito.verify(robot, Mockito.times(1)).turnLeft();		
		Mockito.verify(robot, Mockito.times(0)).turnRight();
	}
}
