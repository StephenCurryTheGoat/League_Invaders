import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
static final int WIDTH = 500;
static final int HEIGHT = 800;
	JFrame frame;
	GamePanel panel;
	public static void main(String[] args) {
		LeagueInvaders invaders = new LeagueInvaders();
		invaders.setUp();
		
	}

	LeagueInvaders(){
		frame = new JFrame();
		panel = new GamePanel();
	}
	void setUp() {
	frame.add(panel);
		
		panel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
	frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(panel);
		frame.pack();
		
	}
	
}

