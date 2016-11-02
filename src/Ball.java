import java.awt.Point;
import java.awt.Color;
import java.util.Observable;

public class Ball extends Observable {
	private Point randpunkt;
	private double pos_x;
	private double pos_y;
	private double dx;
	private double dy;
	private long lastupdate;
	private double speedX;
	private double speedY;
	private Color farbe = Color.BLACK;

	
	
	public Ball(Point randpunkt, Point startpunkt, double dx, double dy, Color farbe) {
		this.randpunkt = randpunkt;
		this.pos_x = startpunkt.getX();
		this.pos_y = startpunkt.getY();
		this.dx = dx;
		this.dy = dy;
		this.lastupdate = System.currentTimeMillis();
		this.farbe = farbe;
	}

	public Ball(Point randpunkt, Point startpunkt, double dx, double dy) {
		this(randpunkt, startpunkt, dx, dy, Color.BLACK);
	}
	
	public void updatePosition() {
		long aktuellezeit = System.currentTimeMillis();
		long verstrichen = aktuellezeit - lastupdate;
		pos_x += dx * verstrichen / 1000;
		pos_y += dy * verstrichen / 1000;
		lastupdate = aktuellezeit;
		if (pos_x<0 || pos_x>randpunkt.x) {
			dx *= -1;
			pos_x = (2*randpunkt.x - pos_x) % randpunkt.x;
		}
		if (pos_y<0 || pos_y>randpunkt.y) {
			dy *= -1;
			pos_y = (2*randpunkt.y - pos_y) % randpunkt.y;
		}
	}
	
}
