package visualizer.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import visualizer.shapes.Shape;

public class MergeSort extends Sort {
	
	private boolean privSorted = false;
	private boolean initCall = true;
	private int size = 0;
	private Queue<ArrayList<Shape>> history = new LinkedList<ArrayList<Shape>>();
	
	public MergeSort() {
		sortName = "Merge Sort";
	}
	
	@Override
	public ArrayList<Shape> sort(ArrayList<Shape> list) {
		if(initCall) {
			initCall = false;
			size = list.size();
		}
		if(list.size() == 1) return list;
		
		int max = list.size();
		
		System.out.println("Left is from " + 0 + " to " + max/2);
		ArrayList<Shape> left = new ArrayList<Shape>(list.subList(0, max / 2));
		printList(left);
		
		System.out.println("Right is from " + (max/2) + " to " + max);
		ArrayList<Shape> right = new ArrayList<Shape>(list.subList(max / 2, max));
		printList(right);
		
		left = sort(left);
		right = sort(right);
		
		return merge(left, right);
	}
	
	private ArrayList<Shape> mergeSort(ArrayList<Shape> list, int left, int right){
		int currentSize = right - left;
		if(currentSize == 1) return list;
		
		ArrayList<Shape> leftL = mergeSort(list, left, (right - left) / 2);
		ArrayList<Shape> rightL = mergeSort(list, (right - left) / 2, right);
		
		
		return list;
	}
	
	private ArrayList<Shape> merge(ArrayList<Shape> list, int left, int right) {
		ArrayList<Shape> result = new ArrayList<Shape>(list.size());
		
		
		
		return result;
	}
	
	
	public void printList(ArrayList<Shape> list) {
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).getValue() + " ");
		}
		System.out.println();
	}
	
	public ArrayList<Shape> merge(ArrayList<Shape> left, ArrayList<Shape> right) {
		ArrayList<Shape> result = new ArrayList<Shape>(left.size() + right.size());
		
		while(!left.isEmpty() && !right.isEmpty()) {
			if(left.get(0).compareTo(right.get(0)) > 0)
				result.add(right.remove(0));
			else result.add(left.remove(0));
		}
		
		while(!left.isEmpty())
			result.add(left.remove(0));
		
		while(!right.isEmpty())
			result.add(right.remove(0));
		
		System.out.println("Merged into: ");
		printList(result);
		
		if(result.size() == size) sorted = true;
		
		return result;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub

	}

}
