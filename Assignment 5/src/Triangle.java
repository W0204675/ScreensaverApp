//Import Utilities
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

//Create a Triangle class that is based off of the parent class 'Shape'
public class Triangle extends Shape {

	//Triangle class constructor
	public Triangle(Color shapeColor, int length, int width, int xPosition, int yPosition, int xSpeed, int ySpeed) {
		super(shapeColor, length, width, xPosition, yPosition, xSpeed, ySpeed);		
	}

	//Overridden drawshape function that creates a Triangle and smoothes the edges
	@Override
	public void drawShape(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setColor(getShapeColor());
		
		int x[]={100,70,130};
		int y[]={50,100,100};
		g.fillPolygon(x,y,3);		
	}

}
