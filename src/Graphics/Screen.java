package Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Screen {

	public Screen(JPanel screen){
		JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(screen);
        f.setSize(800,800);
        f.setLocation(200,200);
        f.setVisible(true);
	}
}
