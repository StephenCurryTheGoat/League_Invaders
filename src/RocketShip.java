import java.awt.Color;
import java.awt.Graphics;

public class RocketShip extends GameObject {

	
		

	RocketShip(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	

	void draw(Graphics g) {
g.setColor(Color.blue);
g.fillRect(x,y,width,height);
	}
}
