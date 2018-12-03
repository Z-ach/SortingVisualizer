package visualizer.algorithms;
import java.util.ArrayList;

import visualizer.shapes.Shape;

public class BubbleSort extends Sort{
	
	private int i = 0;
	private int j = 0;
	
	public BubbleSort() {
		sortName = "Bubble Sort";
	}
	
	public ArrayList<Shape> sort(ArrayList<Shape> list){
		if (sorted) return list;
		if(list.get(j).compareTo(list.get(j + 1)) > 0) {
			swap(list, j, j + 1);
		}
		
		j += 1;
		if(j >= list.size() - i - 1) {
			j = 0;
			i += 1;
		}
		if(i == list.size() - 1) sorted = true;
		
		return list;
	}
	
	public void reset() {
		i = j = 0;
		sorted = false;
	}
	
}
