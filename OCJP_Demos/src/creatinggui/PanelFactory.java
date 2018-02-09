package creatinggui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class PanelFactory {

	private JPanel panel;
	
	private LayoutManager layoutMgr;
	
	public PanelFactory(){
		panel = new JPanel(new FlowLayout());		
	}
	
	public void setLayout(int layout, Container container){
		
		switch (layout) {
			case 0: layoutMgr = new BorderLayout();break;
			//https://docs.oracle.com/javase/7/docs/api/javax/swing/BoxLayout.html
			
			//Components are laid out the way words are laid out in a line
			case 1: layoutMgr = new BoxLayout(container, BoxLayout.LINE_AXIS);break;
			//Components are laid out the way text lines are laid out on a page,
			case 2: layoutMgr = new BoxLayout(container, BoxLayout.PAGE_AXIS);break;
			//Components are laid out horizontally from left to right.
			case 3: layoutMgr = new BoxLayout(container, BoxLayout.X_AXIS);break;
			//Components are laid out vertically from top to bottom.
			case 4: layoutMgr = new BoxLayout(container, BoxLayout.Y_AXIS);break;
			case 5: layoutMgr = new CardLayout();break;
			case 6: layoutMgr = new FlowLayout();break;
			case 7: layoutMgr = new GridBagLayout();break;
			case 8: layoutMgr = new GridLayout();break;
			case 9: layoutMgr = new GroupLayout(container);break;
			case 10: layoutMgr = new SpringLayout();break;
			case 11: layoutMgr = null;
			default : layoutMgr = new FlowLayout();break;			
		}
			
		panel.setLayout(layoutMgr);
		
	}

	
	public void addComponent (Component component) throws Exception  {
		if (layoutMgr instanceof BorderLayout) {
			throw new Exception ("Error en PanelFactory. Esta especificado BorderLayout, especificar la posicion en el segundo parametro");
		}
		panel.add(component);
	}
	
	public void addComponent (MyComponent component, String position){
		panel.add(component,position);
	}
	
	public Component addLabel (String text){
		JLabel label = new JLabel(text);
		panel.add(label);		
		return label;
	}
	
	public JPanel getPanel(){		
		return panel;
	}
}
