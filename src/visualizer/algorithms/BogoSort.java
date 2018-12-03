package visualizer.algorithms;
import java.util.ArrayList;
import java.util.Collections;

import visualizer.shapes.Rectangle;

public class BogoSort extends Sort{

	public BogoSort() {
		sortName = "Bogo Sort";
	}
	
	
	public ArrayList<Rectangle> sort(ArrayList<Rectangle> list) {
		Collections.shuffle(list);
		ArrayList<Rectangle> sortedArray = (ArrayList<Rectangle>) list.clone();
		Collections.sort(sortedArray);
		sorted = true;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getValue() != sortedArray.get(i).getValue()) {
				sorted = false;
				break;
			}
		}
		return list;
	}

	
	public void reset() {
		sorted = false;
	}

}
