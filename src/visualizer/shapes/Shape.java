package visualizer.shapes;

import java.awt.Graphics;

public abstract class Shape implements Comparable<Shape>{
	
	protected int value;
	protected int width;
	
	
	public abstract void display(Graphics g, int arrPos);
	
	public int getValue() {
		return value;
	}

	@Override
	public int compareTo(Shape other) {
		return this.value > other.getValue() ? 1 : -1;
	}
}
