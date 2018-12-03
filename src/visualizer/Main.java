package visualizer;
import javax.swing.JFrame;

public class Main extends JFrame{

	private static final long serialVersionUID = 1L;

	
	public static final int WIDTH = 1920;
	public static final int HEIGHT = 1080;
	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Sorting");
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new Visual());
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
	}
	
}
