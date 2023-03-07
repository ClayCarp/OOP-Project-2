//Clay Carpenter
//OOP Project 2
package project2gui;
import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class PushCounter {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Push Counter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PushCounterPanel panel = new PushCounterPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		frame.pack();
		frame.setVisible(true);
		
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				panel.doClose();
			}
		});
	}
}





