package visualizer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;
import javax.swing.Timer;

import visualizer.algorithms.*;
import visualizer.shapes.*;

public class Visual extends JPanel implements ActionListener, KeyListener{
	
	private static final long serialVersionUID = 1L;
	
	private Timer timer;
	private int defaultRefresh = 5;
	private int refresh = defaultRefresh;
	private int numbRects = 50;
	private int scale = (Main.HEIGHT - 20) / numbRects;
	
	private long startTime = 0;
	
	private boolean shouldSort = false;
	
	private Sort sorter;
	
	private enum SortType {BUBBLE, INSERTION, SELECTION, BOGO};
	
	int validationIndex = 0;
	
	private ArrayList<Shape> array;
	
	
	public Visual() {
		timer = new Timer(refresh, this);
		timer.start();
		this.setPreferredSize(new Dimension(Main.WIDTH, Main.HEIGHT));
		this.addKeyListener(this);
		this.setFocusable(true);
		
		array = initArray(numbRects);
		
		sorter = new BubbleSort();
		
	}
	
	private void changeSort(SortType type) {
		switch(type) {
		case BUBBLE:
			sorter = new BubbleSort();
			break;
		case INSERTION:
			sorter = new InsertionSort();
			break;
		case SELECTION:
			sorter = new SelectionSort();
			break;
		case BOGO:
			sorter = new BogoSort();
			break;
		}
	}
	
	
	private ArrayList<Shape> initArray(int size){
		ArrayList<Shape> list = new ArrayList<Shape>(size);
		for(int i = 0; i < size; i++) {
			list.add(new Circle((int)((Main.WIDTH) / size), (i+1)*scale));
		}
		Collections.shuffle(list);
		return list;
	}
	
	
	public void paint(Graphics g) {
		super.paint(g);
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Main.WIDTH, Main.HEIGHT);
		
		if(!sorter.sorted && shouldSort) sorter.sort(array);
		
		if(sorter.sorted && startTime != 0) {
			System.out.println("Alg took " + (System.currentTimeMillis() - startTime) + " ms");
			startTime = 0;
			validationIndex = 0;
		}
		
		for(int k = 0; k < numbRects; k++) {
			if(sorter.sorted && k <= validationIndex)
				g.setColor(Color.GREEN);
			else g.setColor(Color.WHITE);
			array.get(k).display(g, k);
		}
		
		g.setColor(Color.WHITE);
		g.drawString(Integer.toString(refresh), 5, 15);
		g.drawString(sorter.sortName, 5, 35);
		g.drawString(shouldSort ? "Sort Running" : "Sort Paused", 5, 55);
		
		if(sorter.sorted && validationIndex < numbRects) validationIndex++;

	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.repaint();
	}

	@Override
	public void keyPressed(KeyEvent key) {
		switch(key.getKeyCode()) {
		case KeyEvent.VK_S:
			Collections.shuffle(array);
			sorter.reset();
			break;
		case KeyEvent.VK_SPACE:
			shouldSort = !shouldSort;
			if(shouldSort) {
				startTime = System.currentTimeMillis();
			}
			break;
		case KeyEvent.VK_UP:
			if(refresh > 0) refresh--;
			timer.setDelay(refresh);
			break;
		case KeyEvent.VK_DOWN:
			refresh++;
			timer.setDelay(refresh);
			break;
		case KeyEvent.VK_NUMPAD8:
			refresh = refresh < 100 ? 0 : refresh - 100;
			timer.setDelay(refresh);
			break;
		case KeyEvent.VK_NUMPAD2:
			refresh += 100;
			timer.setDelay(refresh);
			break;
		case KeyEvent.VK_R:
			refresh = defaultRefresh;
			timer.setDelay(refresh);
			break;
		case KeyEvent.VK_1:
			changeSort(SortType.BUBBLE);
			break;
		case KeyEvent.VK_2:
			changeSort(SortType.INSERTION);
			break;
		case KeyEvent.VK_3:
			changeSort(SortType.SELECTION);
			break;
		case KeyEvent.VK_4:
			changeSort(SortType.BOGO);
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
