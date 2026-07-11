import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;
  
public class GamePanel extends JPanel implements ActionListener, KeyListener{
	final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState = MENU;
    Font titleFont;
    Font titleFont2;
    Timer frameDraw;
    RocketShip ship = new RocketShip(250,700,50,50);
    ObjectManager manager = new ObjectManager(ship);
    
    GamePanel(){
        titleFont = new Font("Arial", Font.PLAIN, 48);
        titleFont2 = new Font("Arial", Font.PLAIN, 20);
        frameDraw = new Timer(1000/60,this);
        frameDraw.start();
    }

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
	}
	 void updateMenuState() {  
		 
	 }
	 void updateGameState() {  
		 manager.draw(getGraphics());
	 }
	 void updateEndState()  {  
		 
	 }
	void drawMenuState(Graphics g) { 
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("League Invaders", 80, 50);
		g.setFont(titleFont2);
		g.setColor(Color.yellow);
		g.drawString("Press ENTER to start", 170, 300);
		g.setFont(titleFont2);
		g.setColor(Color.yellow);
		g.drawString("Press SPACE for instructions", 130, 600);
		
	}
	void drawGameState(Graphics g) { 
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.drawString("ship", LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		ship.draw(g);
	}
	void drawEndState(Graphics g)  {  
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("League Invaders", 80, 50);
		g.setFont(titleFont2);
		g.setColor(Color.yellow);
		g.drawString("Youve killed" + " enemies", 170, 300);
		g.setFont(titleFont2);
		g.setColor(Color.yellow);
		g.drawString("Press ENTER to restart", 130, 600);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
		System.out.println("action");
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		    } else {
		        currentState++;
		    }
		} 
		if (e.getKeyCode()==KeyEvent.VK_UP) {
		    System.out.println("UP");
		    ship.up();
		    if(ship.y < 0) {
		    	ship.y = 0;
		    }
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
			System.out.println("DOWN");
			ship.down();
			if(ship.y > LeagueInvaders.HEIGHT - ship.height) {
				ship.y = LeagueInvaders.HEIGHT - ship.height;
			}
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
		    System.out.println("RIGHT");
		  ship.right();
		  if(ship.x > LeagueInvaders.WIDTH - ship.width) {
			  ship.x = LeagueInvaders.WIDTH - ship.width;
		  }
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
		    System.out.println("LEFT");
		    ship.left();
		    if(ship.x < 0) {
		    	ship.x = 0;
		    }
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
