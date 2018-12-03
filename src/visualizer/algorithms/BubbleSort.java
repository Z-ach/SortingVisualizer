package visualizer.algorithms;
import java.util.ArrayList;

import visualizer.shapes.Rectangle;

public class BubbleSort extends Sort{
	
	private int i = 0;
	private int j = 0;
	
	public BubbleSort() {
		sortName = "Bubble Sort";
	}
	
	public ArrayList<Rectangle> sort(ArrayList<Rectangle> list){
		if (sorted) return list;
		if(list.get(j).compareTo(list.get(j + 1)) > 0) {
			Rectangle temp = list.get(j);
			list.set(j, list.get(j + 1));
			list.set(j + 1, temp);
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
