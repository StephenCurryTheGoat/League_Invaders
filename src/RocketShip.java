import java.awt.Color;
import java.awt.Graphics;


public class RocketShip extends GameObject {


		public void right() {
       x+=speed;
    }
    public void left() {
        x-=speed;
        
    }
    public void down() {
        y+=speed;
    }
    public void up() {
        y-=speed;
    }

	RocketShip(int x, int y, int width, int height) {
		super(x, y, width, height);
		 speed = 10; 	
		}
 
	

	void draw(Graphics g) {
g.setColor(Color.blue);
g.fillRect(x,y,width,height);
	}
  

}
