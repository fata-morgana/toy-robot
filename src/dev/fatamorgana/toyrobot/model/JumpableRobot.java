package dev.fatamorgana.toyrobot.model;

public class JumpableRobot extends BasicRobot implements Jumpable {
	
	public static JumpableRobot create(int positionX, int positionY, Direction direction) {
		return new JumpableRobot(positionX, positionY, direction);
	}

	private JumpableRobot(int positionX, int positionY, Direction direction) {
		super(positionX, positionY, direction);
	}

	@Override
	public void jump() {
		switch(getDirection()) {
		    case NORTH: jumpUp(); break;
		    case EAST: jumpRight(); break;
		    case SOUTH: jumpDown(); break;
		    case WEST: jumpLeft(); break;
		}
	}

	
	protected void jumpUp() {
		setPositionY(getPositionY() + 2);
	}
	
	protected void jumpDown() {
		setPositionY(getPositionY() - 2);
	}
	
	protected void jumpRight() {
		setPositionX(getPositionX() + 2);
	}
	
	protected void jumpLeft() {
		setPositionX(getPositionX() - 2);
	}

}
