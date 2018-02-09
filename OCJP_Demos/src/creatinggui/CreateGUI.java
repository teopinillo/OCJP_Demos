package creatinggui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Transparency;
import static java.awt.GraphicsDevice.WindowTranslucency.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CreateGUI extends JFrame {

	// private JFrame appFrame;
	// Ask for window decorations provided by the look and feel.
	// JFrame.setDefaultLookAndFeelDecorated(true);

	/*
	 * @PARAM _width app width
	 * @PARAM _height app height
	 * 
	 */
	
	
	
	public CreateGUI(int _width, int _height) {
		super("My App");
		setDefaultLookAndFeelDecorated(true);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// --Other Options
		// appFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		// appFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		// appFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// Color's
		setBackground(Color.GREEN);
		setForeground(Color.MAGENTA);

		// Dimensions, Localization
		setAlwaysOnTop(false);
		setLocation(20, 20);
		setSize(_width, _height);
		setMinimumSize(new Dimension(800, 400));

		// Transaparency
		// Transparency.TRANSLUCENT;
		// if (supportOpacity()) setOpacity(Transparency.OPAQUE);

		setLayout(new FlowLayout());

	}
	
	public CreateGUI (){
		this (800,400);
	}
	


	// Si se desea usar opacidad primero comprobar que este soportada
	private boolean supportOpacity() {
		// https://docs.oracle.com/javase/tutorial/uiswing/misc/trans_shaped_windows.html
		// Determine if the GraphicsDevice supports translucency.
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();

		// If translucent windows aren't supported, exit.
		if (!gd.isWindowTranslucencySupported(TRANSLUCENT)) {
			return false;
		}
		return true;
	}

	public void showMe() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// Display the window
				pack();
				setVisible(true);
			}
		});

	}

	public void addPanel(JPanel panel) {
		getContentPane().add(panel);
	}

	public JFrame getFrame() {
		return this;
	}

}
