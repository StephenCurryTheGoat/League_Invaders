import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class ObjectManager {
	RocketShip r;
	ArrayList<Projectile> projectile = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	Random ran = new Random();

	ObjectManager(RocketShip r) {
		this.r = r;
	}

	void addProjectiles(ArrayList p) {

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
		for (int i = 0; i < projectile.size(); i++) {
			Projectile pr = projectile.get(i);
			pr.update();
			if (pr.y < -pr.height) {
				pr.isActive = false;
			}
		}
	}

	void draw(Graphics g) {
		r.draw(g);
		for (int i = 0; i < aliens.size(); i++) {
			Alien al = aliens.get(i);
			al.draw(g);
		}
		for (int i = 0; i < projectile.size(); i++) {
			Projectile pr = projectile.get(i);
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
		Iterator<Projectile> iters = projectile.iterator();
		while(iters.hasNext()) {
			Projectile p = iters.next();
			if(p.isActive == false) {
				iters.remove();
			}
		}
	}
}
