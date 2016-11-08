import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Observable;

public class Ball extends Observable{
	private Point boundarypoint;
	private double posX, posY;
	private double diameter;
	private double vx, vy;
	private double dx;
	private double dy;
	private int id;
	private Color color = Color.BLACK;
	private long lastUpdate;
	private ArrayList<Ball> others;
	
	public Ball(Point boundarypoint, Point startPoint, double diameter, int id, ArrayList<Ball> others){
		this.boundarypoint = boundarypoint;
		this.posX = startPoint.x;
		this.posY = startPoint.y;
		this.diameter = diameter;
		this.id = id;
		this.lastUpdate = System.currentTimeMillis();
		this.others = others;
	}
	
	public double getX(){
		return posX;
	}
	public double getY(){
		return posY;
	}
	public double getDiameter(){
		return diameter;
	}
	public int getID(){
		return id;
	}
	
	public Color getColor(){
		return color;
	}
	public Point getPosition() {
		return new Point((int) Math.round(posX), (int) Math.round(posY));
	}
	public void updatePosition() {
		long aktuellezeit = System.currentTimeMillis();
		long verstrichen = aktuellezeit - lastUpdate;			
		posX += dx * verstrichen / 1000;
		posY += dy * verstrichen / 1000;			
		lastUpdate = aktuellezeit;
		if (posX<0 || posX>boundarypoint.x) {
			dx *= -1;
			posX = (2*boundarypoint.x - posX) % boundarypoint.x; 
		}
		if (posY<0 || posY>boundarypoint.y) {
			dy *= -1;
			posY = (2*boundarypoint.y - posY) % boundarypoint.y; 
		}				
	}
}