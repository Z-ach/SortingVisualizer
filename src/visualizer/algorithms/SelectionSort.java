package visualizer.algorithms;
import java.util.ArrayList;

import visualizer.shapes.Rectangle;
import visualizer.shapes.Shape;

public class SelectionSort extends Sort {
	
	private int i = 0;
	
	public SelectionSort() {
		sortName = "SelectionSort";
	}

	@Override
	public ArrayList<Shape> sort(ArrayList<Shape> list) {
		if(i == list.size() - 1) {
			sorted = true;
			return list;
		}
		int min = list.get(i).getValue();
		int last_index = i;
		for(int j = i + 1; j < list.size(); j++) {
			if(list.get(j).getValue() < min) {
				min = list.get(j).getValue();
				last_index = j;
			}
		}
		swap(list, i, last_index);
		i++;
		return list;
	}

	@Override
	public void reset() {
		sorted = false;
		i = 0;
	}

}
