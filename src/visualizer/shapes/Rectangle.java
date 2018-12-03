package visualizer.shapes;

import java.awt.Graphics;

import visualizer.Main;

public class Rectangle extends Shape{
	
	public Rectangle(int width, int value) {
		this.value = value;
		this.width = width;
	}
	
	public void display(Graphics g, int arrPos) {
		g.fillRect(arrPos * width, (Main.HEIGHT - value), width - 1, value);
	}
	
	
}
