package JavaNIO;

import java.nio.file.*;

import javax.swing.JOptionPane;

import creatinggui.CreateGUI;
import creatinggui.JConsole;
import creatinggui.PanelFactory;

//class to illustrate how to use Path
//interface and its methods.

public class PathInterfaceTest {

	public static void main(String[] args) throws Exception {
		
		JConsole console = new JConsole();		
		CreateGUI app = new CreateGUI();
		PanelFactory panelF= new PanelFactory();
	
		panelF.addComponent(console);
		app.addPanel(panelF.getPanel());			
		app.showMe();		
		
		Object value = JOptionPane.showInputDialog(app.getFrame(), "File to Test");
		String testPath = (String)value;
		console.writeLine("File: "+testPath);
		
		//Create a path object by calling static method get()
		//in Paths class
		Path testFilePath = Paths.get (testPath);
		
		//Retrieve basic information about path
		console.writeLine ("Printing file information: ");
		console.writeLine ("\t file name: "+ testFilePath.getFileName());
		console.writeLine ("\t root of the path: "+ testFilePath.getRoot());
		console.writeLine ("\t parent of the path: "+ testFilePath.getParent());
		
		//Print the path elements	
		console.writeLine ("Printing elements of the path: ");
		for (Path element : testFilePath){
			console.writeLine("\t path element: "+element);
		}

	}

}
