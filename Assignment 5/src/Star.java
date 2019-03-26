//Import Utilities
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

//Create a Star class that is based off of the parent class 'Shape'
public class Star extends Shape {
	
	//Star class constructor
	public Star(Color shapeColor, int length, int width, int xPosition, int yPosition, int xSpeed, int ySpeed) {
		super(shapeColor, length, width, xPosition, yPosition, xSpeed, ySpeed);		
	}
	
	//Overridden drawshape function that creates a Polygon and smoothes the edges
	@Override
	public void drawShape(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setColor(getShapeColor());
	}

}
