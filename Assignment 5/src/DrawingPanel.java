//Import Utilities
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;

//Initiate Class 'DrawingPanel' to be the canvas for the shapes
public class DrawingPanel extends JPanel implements ActionListener{

	//Initiate Timer called 'timer' that is 10 milliseconds long
	Timer timer = new Timer(2, this);
	
	//Make Arraylist to store the shapes 
	public static ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	//This is used to replicate the size of the shapes arraylist due to errors when putting "shapes.size() into the for loops 
	Object[] shapesIndex = shapes.toArray();
	int Shapes = shapesIndex.length - 1;
	
	//paintComponent Method
	public void paintComponent(Graphics g)
	{
		//This resets the canvas
		super.paintComponent(g);
		
		//Initiate graphics2D variable
		Graphics2D g2d = (Graphics2D)g;	
			
		//This for loop grabs all of the shapes in the shapes arraylist and draws them onto the canvas
		for (int x = 0; x <= Shapes; x++)
		{
			//X ticker goes up to 3 which is a static max index.
			shapes.get(x).drawShape(g2d);	
		}
		
		//Start the timer
		timer.start();		
	}
	
	//actionPerformed variable starts when the application is run
	public void actionPerformed(ActionEvent e) {

		//for loop perform the move action for all of the shapes in the shapes arraylist
		for (int x = 0; x <= Shapes; x++)
		{
			shapes.get(x).move();			
		}
		
		//The canvas is repainted every time the timer starts again(10 Milliseconds). The shapes position updates every 10 milliseconds
		repaint();			
	}
	
	//This function is called in the main App file and it adds a random shape with a random color to the canvas
	public void addShape() {
		
		//Generate random numbers to draw a shape and color
		Random random = new Random();
		int randNum = random.nextInt(4) + 1;
		int randColor = random.nextInt(8) + 1;
		
		//Color list to hold colors
		Color[] colors = {Color.BLUE,Color.RED,Color.YELLOW,Color.CYAN,Color.MAGENTA,Color.WHITE,Color.GRAY,Color.PINK,Color.ORANGE};
		
		//If statements determine which random number was drawn and add it to the shapes arraylist
		if (randNum == 1)
		{
			shapes.add(new Square(colors[randColor], 60, 60, 0, 0, 1, 1));
		}
		
		else if (randNum == 2)
		{
			shapes.add(new Square(colors[randColor], 60, 60, 330, 0, 1, 1));
		}
		
		else if (randNum == 3)
		{
			shapes.add(new Circle(colors[randColor], 90, 90, 330, 200, 1, 1));
		}
		
		else if (randNum == 4)
		{
			shapes.add(new Circle(colors[randColor], 60, 60, 0, 230, 1, 1));
		}
		
		//The replication of the shapes arraylist's size gets updated everytime a new shape is added to the canvas
		Object[] shapesIndex = shapes.toArray();
		Shapes = shapesIndex.length - 1;
	}
}