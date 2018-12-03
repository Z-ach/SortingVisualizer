package visualizer.algorithms;
import java.util.ArrayList;

import visualizer.shapes.Rectangle;

public class InsertionSort extends Sort{
	
	private int i = 0;
	
	public InsertionSort() {
		sortName = "Insertion Sort";
	}
	
	public ArrayList<Rectangle> sort(ArrayList<Rectangle> list){
		int checkIndex = i + 1;
		while(checkIndex != 0 && list.get(checkIndex - 1).compareTo(list.get(checkIndex)) > 0) {
			swap(list, checkIndex - 1, checkIndex);
			checkIndex--;
		}
		i++;
		if(i == list.size() - 1) sorted = true;
		return list;
	}
	
	public void reset() {
		i = 0;
		sorted = false;
	}

}
