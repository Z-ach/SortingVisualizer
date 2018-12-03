package visualizer.shapes;

import java.awt.Graphics;

import visualizer.Main;

public class Circle extends Shape {
	
	public Circle(int width, int value){
		this.width = width;
		this.value = value;
	}

	@Override
	public void display(Graphics g, int arrPos) {
		g.fillOval(arrPos * width, Main.HEIGHT - value, width - 1, width - 1);
	}

}
