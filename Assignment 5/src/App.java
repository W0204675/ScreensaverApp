//Import Utilities
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.Rectangle;

//Jframe class called 'App'
public class App extends JFrame {

	public static final JButton btnAddShape = null;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	//Frame to duplicate in order to make it easier to obtain the frames width and height. See 'move' method in shape class
	public static DrawingPanel frame1;
	
	//Initiate Assignment5 GUI 
	public App() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		//Initiate DrawingPanel onto the main GUI
		DrawingPanel DP = new DrawingPanel();
		
		//Copy over the DrawingPanel to the frame1 variable
		frame1 = DP;
		contentPane.add(DP, "name_175449442043574");
		DP.setBackground(SystemColor.activeCaption);
		
		//This is a button that adds a shape to the canvas when its clicked
		JButton btnAddShape = new JButton("Click me to add a shape");
		btnAddShape.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Drawing panel's addShape function. See at line 62 of the DrawingPanel class
				DP.addShape();
			}
		});
		btnAddShape.setBounds(new Rectangle(9, 0, 0, 0));
		btnAddShape.setAlignmentX(Component.CENTER_ALIGNMENT);
		DP.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		btnAddShape.setFont(new Font("Tahoma", Font.PLAIN, 15));
		DP.add(btnAddShape);
	}
}