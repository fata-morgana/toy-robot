package dev.fatamorgana.toyrobot.model;

public class BasicTableTop implements TableTop{
	public static final int DEFAULT_LEFT = 0;
	public static final int DEFAULT_BOTTOM = 0;
	public static final int DEFAULT_RIGHT = 4;
	public static final int DEFAULT_TOP = 4;
	private final int upperMost;
	private final int rightMost;
	private final int lowerMost;
	private final int leftMost;
	
	public static BasicTableTop createDefault() {
		return new BasicTableTop();
	}
	
	public static BasicTableTop createWithDimension(int height, int width) {
		if (height < 0) {
			throw new IllegalArgumentException("Height must be positive.");
		}
		if (width < 0) {
			throw new IllegalArgumentException("Width must be positive.");
		}
		
		return new BasicTableTop(height -1, width -1);
	}
	
	private BasicTableTop() {
		// default dimension
		upperMost = DEFAULT_TOP;
		rightMost = DEFAULT_RIGHT;
		lowerMost = DEFAULT_LEFT;
		leftMost = DEFAULT_BOTTOM;
	}
	
	private BasicTableTop(int upperMost, int rightMost) {
		// custom dimension
		this.upperMost = upperMost;
		this.rightMost = rightMost;
		lowerMost = 0;
		leftMost = 0;
	}

	public int getUpperMost() {
		return upperMost;
	}

	public int getRightMost() {
		return rightMost;
	}

	public int getLowerMost() {
		return lowerMost;
	}

	public int getLeftMost() {
		return leftMost;
	}
	
	@Override
	public boolean isValidPosition(int x, int y) {
		return x >= leftMost && x <= rightMost && y >= lowerMost && y <= upperMost;
	}
}
