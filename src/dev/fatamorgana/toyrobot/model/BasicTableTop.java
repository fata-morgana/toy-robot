package dev.fatamorgana.toyrobot.model;

public class BasicTableTop implements TableTop {
	public static final int DEFAULT_LEFT = 0;
	public static final int DEFAULT_BOTTOM = 0;
	public static final int DEFAULT_RIGHT = 4;
	public static final int DEFAULT_TOP = 4;
	private final int topMost;
	private final int rightMost;
	private final int bottomMost;
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
		topMost = DEFAULT_TOP;
		rightMost = DEFAULT_RIGHT;
		bottomMost = DEFAULT_LEFT;
		leftMost = DEFAULT_BOTTOM;
	}
	
	private BasicTableTop(int upperMost, int rightMost) {
		// custom dimension
		this.topMost = upperMost;
		this.rightMost = rightMost;
		bottomMost = 0;
		leftMost = 0;
	}

	public int getTopMost() {
		return topMost;
	}

	public int getRightMost() {
		return rightMost;
	}

	public int getBottomost() {
		return bottomMost;
	}

	public int getLeftMost() {
		return leftMost;
	}
	
	@Override
	public boolean isValidPosition(int x, int y) {
		return x >= leftMost && x <= rightMost && y >= bottomMost && y <= topMost;
	}
}
