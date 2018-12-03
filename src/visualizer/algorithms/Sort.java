package visualizer.algorithms;
import java.util.ArrayList;

import visualizer.shapes.Rectangle;

public abstract class Sort {
	
	public boolean sorted;
	public String sortName;
	
	public abstract ArrayList<Rectangle> sort(ArrayList<Rectangle> list);
	public abstract void reset();
	
	protected ArrayList<Rectangle> swap(ArrayList<Rectangle> list, int i, int j){
		Rectangle temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
		return list;
	}
	
}
