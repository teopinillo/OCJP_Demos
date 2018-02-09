package creatinggui;

import javax.swing.JLabel;

public class JConsole extends JLabel {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	private String text="";
	
	public JConsole(){
		super();		
	}
	
	public JConsole(String text){
		super("<html>"+text+"</html>");	
		this.text = text;
			
	}
	
	public void writeLine (String text){
		this.text+="<br>"+text;
		setText("<html>"+this.text+"</html>");
		repaint();
	}

}
