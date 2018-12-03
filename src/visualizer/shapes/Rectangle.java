package visualizer.shapes;

import java.awt.Graphics;

import visualizer.Main;

public class Rectangle implements Comparable<Rectangle>{
	
	private int value;
	private int width;
	
	public Rectangle(int width, int value) {
		this.value = value;
		this.width = width;
	}
	
	public void display(Graphics g, int arrPos) {
		g.fillRect(arrPos * width, (Main.HEIGHT - value), width - 1, value);
	}
	
	public int getValue() {
		return value;
	}

	@Override
	public int compareTo(Rectangle other) {
		return this.value > other.getValue() ? 1 : -1;
	}
	
}
