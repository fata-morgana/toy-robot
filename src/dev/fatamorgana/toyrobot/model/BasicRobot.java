package dev.fatamorgana.toyrobot.model;

public class BasicRobot implements Robot, SelfReportable {
	private int positionX;
	private int positionY;
	private Direction direction;
	
	public BasicRobot(int positionX, int positionY, Direction direction) {
		super();
		this.positionX = positionX;
		this.positionY = positionY;
		this.direction = direction;
	}
	
	@Override
	public void move() {
		switch(direction) {
		    case NORTH: moveUp(); break;
		    case EAST: moveRight(); break;
		    case SOUTH: moveDown(); break;
		    case WEST: moveLeft(); break;
		}
	}
	
	protected void moveUp() {
		positionY++;
	}
	
	protected void moveDown() {
		positionY--;
	}
	
	protected void moveRight() {
		positionX++;
	}
	
	protected void moveLeft() {
		positionX--;
	}
	
	@Override
	public void turnLeft() {
		direction = direction.left();
	}
	
	@Override
	public void turnRight() {
		direction = direction.right();
	}

	@Override
	public String report() {
		return String.format("%s,%s,%s", getPositionX(), getPositionY(), getDirection());
	}

	public int getPositionX() {
		return positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public Direction getDirection() {
		return direction;
	}

	protected void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	protected void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	protected void setDirection(Direction direction) {
		this.direction = direction;
	}
	
}
