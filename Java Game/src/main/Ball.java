package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {
	private static final int DIAMETER = 30;
	int x = 0, y = 0, xa = 1, ya = 1;
	private Window game;
	
	public Ball(Window game) {
		this.game = game;
	}
	
	void move() {
		if (x + xa < 0)
			xa = 1;
		if(x + xa > game.getWidth() - DIAMETER)
			xa = -1;
		if(y + ya < 0)
			ya = 1;
		if(y + ya > game.getHeight() - DIAMETER)
			game.gameOver();
		if(collision()) {
			ya = -1;
			y = game.racquet.getTopY() - DIAMETER;
		}
		
		x += xa; y += ya;
	}
	
	private boolean collision() {
		return game.racquet.getBounds().intersects(getBounds());
	}
	
	public void paint(Graphics2D g) {
		g.setColor(Color.BLUE);
		g.fillOval(x, y, DIAMETER, DIAMETER);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}
}
