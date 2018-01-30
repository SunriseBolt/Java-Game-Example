package main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


@SuppressWarnings("serial")
public class Window extends JPanel{
	
	Ball ball = new Ball(this);
	Racquet racquet = new Racquet(this);
	
	public Window() {
		addKeyListener(new KeyListener(){
			@Override
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyReleased(KeyEvent e){
				racquet.keyReleased(e);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				racquet.keyPressed(e);
			}
	});
		setFocusable(true);
	}
	
	private void move() {
		ball.move();
		racquet.move();
	}
	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		ball.paint(g2d);
		racquet.paint(g2d);
	}
	
	public void gameOver() {
		JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}
	
	
	
	public static void main(String args[]) throws InterruptedException
	{
		JFrame Window = new JFrame("The Game");
		Window game = new Window();
		Window.add(game);
		Window.setSize(400,400);
		Window.setVisible(true);
		Window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		while(true) {
			game.move();
			game.repaint();
			Thread.sleep(10);
		}
	}
}
