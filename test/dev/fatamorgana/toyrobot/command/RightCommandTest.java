package dev.fatamorgana.toyrobot.command;

import org.junit.Test;
import org.mockito.Mockito;

import dev.fatamorgana.toyrobot.model.BasicRobot;
import dev.fatamorgana.toyrobot.model.BasicTableTop;
import dev.fatamorgana.toyrobot.model.TableTop;

public class RightCommandTest {


	@Test
	public void testRightCommand() {
		BasicRobot robot = Mockito.mock(BasicRobot.class);
		TableTop tableTop = Mockito.mock(BasicTableTop.class);
		GenericCommand command = new RightCommand();
		Mockito.doNothing().when(robot).turnRight();
		command.execute(robot, tableTop);
		
		Mockito.verify(robot, Mockito.times(1)).turnRight();		
		Mockito.verify(robot, Mockito.times(0)).turnLeft();
	}
}
