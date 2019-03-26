//Import Utilities
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

//Create a Circle class that is based off of the parent class 'Shape'
public class Circle extends Shape {
	
	//Circle class constructor
	public Circle(Color shapeColor, int length, int width, int xPosition, int yPosition, int xSpeed, int ySpeed) {
		super(shapeColor, length, width, xPosition, yPosition, xSpeed, ySpeed);		
	}
	
	//Overridden drawshape function that creates a Circle and smoothes the edge
	@Override
	public void drawShape(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setColor(getShapeColor());	
		g.fillOval(getxPosition(),getyPosition(), getShapeWidth(), getLength());
	}
}
