//Import Utilities
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

//Create Parent class 'Shape' for all shapes to be based off of
public abstract class Shape {
	
	//Initiate appropriate shape values
	private Color shapeColor;
	private int length;
	private int width;
	private int xPosition;
	private int yPosition;
	private int xSpeed;
	private int ySpeed;
	
	//Shape Constructor Method
	public Shape(Color shapeColor, int length, int width, int xPosition, int yPosition, int xSpeed, int ySpeed)
	{
		this.shapeColor = shapeColor;
		this.length = length;
		this.width = width;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(xPosition, yPosition, width, length);
	}
	
	
	//Move method that moves the shapes when called to a shape
	public void move()
	{	
		//Line 39-56 are collision detection against other shapes. I researched this and found a great tutorial on how this is done
		//Link is: https://www.youtube.com/watch?v=8KNwjOsdn8I
		
		//Create a rectangle that surrounds the shape and is used to compare the bounds of other shapes
		Rectangle shapeToCheck = this.getBounds();
		
		//for loop that goes through each shape is the shapes arraylist and compares their bounds
		for (Shape shape : DrawingPanel.shapes)
		{
			//Create another rectangle to surround the other shape that the checked shape is being compared to
			Rectangle otherShape = shape.getBounds();
			
			//If the compared shapes rectangle intersects with another shape: reverse the direction(bounce them away from each other)
			if (shape != this && otherShape.intersects(shapeToCheck))
			{
				int tempXDirection = this.xSpeed;
				int tempYDirection = this.ySpeed;
				
				this.xSpeed = shape.xSpeed;
				this.ySpeed = shape.ySpeed;
				
				shape.xSpeed = tempXDirection;
				shape.ySpeed = tempYDirection;
			}
		}
		
		//If the position collides with the wall of the GUI window then the shape bounces off of the wall
		if (this.getxPosition() < 0 || this.getxPosition() > App.frame1.getWidth() - this.getShapeWidth())
		{
			//The negative speed makes the shape go the opposite direction
			this.setxSpeed(-(this.getxSpeed()));
		}
		if (this.getyPosition() < 0 || this.getyPosition() > App.frame1.getHeight() - this.getLength())
		{
			//The negative speed makes the shape go the opposite direction
			this.setySpeed(-(this.getySpeed()));
		}
		
		//The shapes position updates based off of their speed
		this.xPosition += getxSpeed();
		this.yPosition += getySpeed();
	}
	
	//Abstract draw shape function
	public abstract void drawShape(Graphics2D g);
	
	//Getters and setters for each shape value
	public Color getShapeColor() {
		return shapeColor;
	}

	public void setShapeColor(Color shapeColor) {
		this.shapeColor = shapeColor;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getShapeWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getxPosition() {
		return xPosition;
	}

	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public int getyPosition() {
		return yPosition;
	}

	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	public int getxSpeed() {
		return xSpeed;
	}

	public void setxSpeed(int xSpeed) {
		this.xSpeed = xSpeed;
	}

	public int getySpeed() {
		return ySpeed;
	}

	public void setySpeed(int ySpeed) {
		this.ySpeed = ySpeed;
	}	
}
