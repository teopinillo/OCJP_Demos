package creatinggui;

import java.awt.BorderLayout;
import java.awt.Component;

public class MyComponent extends Component {
	String borderLayoutPosition = BorderLayout.CENTER;
	Component component;

	public MyComponent() {
		borderLayoutPosition = BorderLayout.CENTER;
	}
	
	public MyComponent(Component component) {		
		this.component = component;
		borderLayoutPosition = BorderLayout.CENTER;
	}

	public MyComponent(Component component, String position) {
		this.component = component;
		borderLayoutPosition = position;
	}

	// Pone el layout como las horas del reloj
	public MyComponent(int position) {
		switch (position) {
		case 3:
			borderLayoutPosition = BorderLayout.EAST;
			break;
		case 6:
			borderLayoutPosition = BorderLayout.SOUTH;
			break;
		case 9:
			borderLayoutPosition = BorderLayout.WEST;
			break;
		case 12:
			borderLayoutPosition = BorderLayout.NORTH;
			break;
		}
	}

	public String getPosition(){
		return borderLayoutPosition;
	}
	
	public Component getComponent(){
		return component;
	}
}
