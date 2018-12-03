package visualizer.algorithms;
import java.util.ArrayList;

import visualizer.shapes.Shape;

public abstract class Sort {
	
	public boolean sorted;
	public String sortName;
	
	public abstract ArrayList<Shape> sort(ArrayList<Shape> list);
	public abstract void reset();
	
	protected ArrayList<Shape> swap(ArrayList<Shape> list, int i, int j){
		Shape temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
		return list;
	}
	
}
