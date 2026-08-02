import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class ObjectManager implements ActionListener {
	RocketShip r;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	Random ran = new Random();
	int score = 0;

	ObjectManager(RocketShip r) {
		this.r = r;
	}

	void addProjectile(Projectile p) {
		projectiles.add(p);
	}

	void addAlien() {
		aliens.add(new Alien(ran.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));

	}

	void update() {
		for (int i = 0; i < aliens.size(); i++) {
			Alien al = aliens.get(i);
			al.update();
			if (al.y > LeagueInvaders.HEIGHT) {
				al.isActive = false;
			}
		}
		for (int i = 0; i < projectiles.size(); i++) {
			Projectile pr = projectiles.get(i);
			pr.update();
			if (pr.y < -pr.height) {
				pr.isActive = false;
			}
		}
		checkCollision();
		purgeObjects();
	}

	void draw(Graphics g) {
		r.draw(g);
		for (int i = 0; i < aliens.size(); i++) {
			Alien al = aliens.get(i);
			al.draw(g);
		}
		for (int i = 0; i < projectiles.size(); i++) {
			Projectile pr = projectiles.get(i);
			pr.draw(g);
		}
	}

	void purgeObjects() {
		Iterator<Alien> iter = aliens.iterator();
		while (iter.hasNext()) {
			Alien a = iter.next();
			if (a.isActive == false) {
				iter.remove();
			}
		}
		Iterator<Projectile> iters = projectiles.iterator();
		while (iters.hasNext()) {
			Projectile p = iters.next();
			if (p.isActive == false) {
				iters.remove();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();
	}
	
	void checkCollision() {
		for(Alien alien: aliens) {
			for(Projectile r : projectiles) {
				if(r.collisionBox.intersects(alien.collisionBox)) {
					alien.isActive = false;
					r.isActive = false;
					score++;
				}
			}
		}
		
	
	}
	void getScore() {
		
	}
}
		
	

