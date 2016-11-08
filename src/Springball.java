
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;

import javafx.application.Application;
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class Springball extends Application
{
	private final static int max_x = 640;     
	private final static int max_y = 480;
	private final static int diameter = 20;
	public final static Point boundaryPoint = new Point(max_x-diameter,max_y-diameter);
	public ArrayList<Ball> baelle;
	
	public static double GRAVITY = 0.03;
	public static double SPRING = 0.05;

	private GraphicsWindow gw;

	public static void main (String[] args)throws InterruptedException 
	{
		GraphicsWindow gw = new GraphicsWindow();
		ArrayList<Ball> baelle = new ArrayList<Ball>();
		Ball b = new Ball(boundaryPoint, new Point(50,60), diameter, 1, baelle);
		baelle.add(b);
		gw.paint(b);
		System.out.println("ID ="+b.getID());
		Springball sb = new Springball(baelle, gw);
		//while( true ) {
			for (Ball ball : baelle) {
				ball.updatePosition();
			}
			gw.paintAll(baelle);
			Point click = gw.mouseClick();
			System.out.println("Click at : "+click);
			Random zufall = new Random(); 
			//gw.sleep(8000);
			//System.exit(0);
		//}
	}
	
	public Springball(ArrayList<Ball> baelle, GraphicsWindow gw) {
		this.baelle = baelle;
		this.gw = gw;	
	}

	public ArrayList<Ball> getBalls(){
		return baelle;
	}

	public void newBall(Point point){
		Ball b = new Ball(boundaryPoint, point, diameter, baelle.size(), baelle);
		baelle.add(b);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
}

