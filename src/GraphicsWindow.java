
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.RectangularShape;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.*;

import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;


public class GraphicsWindow extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame window;
	private JButton button;
	private Point mousePos = new Point();
	private Panel panel;
	private final Canvas canvas = new Canvas();
	GraphicsContext gc = canvas.getGraphicsContext2D();
	Graphics graphics;
	private Color activeColor = Color.BLACK;
	public Point lastClicked;
	private boolean mouseClicked;
	public MouseListener mouseListener = new MouseListener(){
		@Override
		public void mouseClicked(java.awt.event.MouseEvent e) {
			int x = e.getX();   // x-coordinate of the mouse click
		    int y = e.getY();   // y-coordinate of the mouse click
		    lastClicked = e.getPoint();
		    System.out.println("clicked"+" "+ x +" " + y);		    
		}
		@Override
		public void mouseEntered(java.awt.event.MouseEvent arg0) {}
		@Override
		public void mouseExited(java.awt.event.MouseEvent arg0) {}
		@Override
		public void mousePressed(java.awt.event.MouseEvent arg0) {}
		@Override
		public void mouseReleased(java.awt.event.MouseEvent arg0) {}	
	};

	private int width = 600, height = 500;
	
	public GraphicsWindow()
	{
		window = new JFrame("Springball");
		window.setSize(width,height+80);
		panel = new Panel();
		window.getContentPane().add(panel,"Center");
		canvas.addMouseListener(mouseListener);
		canvas.setSize(width, height);
		canvas.setBackground(Color.WHITE);
		button = new JButton("Beenden");
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		panel.add(canvas);
		panel.add(button);
		window.add(panel);
		mousePos = new Point();
		window.setVisible(true);
	}
	
	public Canvas getCanvas(){
		return canvas;
	}
	
	public Point mouseClick() {
		try{ 
			synchronized(mouseListener){mouseListener.wait();}
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
		return mousePos;
	}
	
	public void sleep(long millis) {
		try {Thread.sleep(millis);} catch (Exception e){}
	}

	/** Liefert die aktuelle Zeichenfarbe. 
	@return die aktuelle Zeichenfarbe des GraphicsWindow. */
	public Color getColor() {
		return activeColor;
	}

	public void setColor(Color color) {
		this.activeColor = color;
	}
	
	public void paintAll(ArrayList<Ball> baelle) {
		for (Ball ball : baelle) {
			paint(ball);
			System.out.println("Ball nr "+ ball.getID()+" an "+ ball.getPosition());
		}
		canvas.repaint();
	}
	
	public void paint(Ball ball){
		Point point = ball.getPosition();
		int dia = (int) ball.getDiameter();
		graphics = canvas.getGraphics();
		graphics.setColor(Color.BLACK);
		graphics.fillOval((int)point.getX(),(int) point.getY(), dia, dia);
		System.out.println("painted");
	}
	
	public boolean clicked(){
		return mouseClicked;
	}
}

