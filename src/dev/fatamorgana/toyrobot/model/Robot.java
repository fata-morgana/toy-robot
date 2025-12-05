package dev.fatamorgana.toyrobot.model;

public class Robot {
	private int positionX;
	private int positionY;
	private Direction direction;
	
	public Robot(int positionX, int positionY, Direction direction) {
		super();
		this.positionX = positionX;
		this.positionY = positionY;
		this.direction = direction;
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
	
	public void turnLeft() {
		direction = direction.left();
	}
	
	public void turnRight() {
		direction = direction.right();
	}
}
