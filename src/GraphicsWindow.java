
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

import java.awt.Color;
import java.awt.Label;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

public class GraphicsWindow implements Observer{

	private int width;
    private int height;
    private JFrame dasFenster;
    private static int fensterZahl;
    private static int fensterNr;
    private Label label;
    private Point mousePos;
    private Color activeColor = Color.BLACK;
    final private Color backColor = Color.WHITE;
    
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}
