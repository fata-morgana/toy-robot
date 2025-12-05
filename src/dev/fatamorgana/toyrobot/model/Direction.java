package dev.fatamorgana.toyrobot.model;

public enum Direction {
	NORTH, EAST, SOUTH, WEST;
	
	public Direction left() {
		switch(this) {
			case NORTH: return WEST;
			case WEST: return SOUTH;
			case SOUTH: return EAST;
			case EAST: return NORTH;
		}
		throw new RuntimeException("Direction " + this + "not support.");
	}
	
	public Direction right() {
		switch(this) {
			case NORTH: return EAST;
			case EAST: return SOUTH;
			case SOUTH: return WEST;
			case WEST: return NORTH;
		}
		throw new RuntimeException("Direction " + this + "not support.");
	}
}
