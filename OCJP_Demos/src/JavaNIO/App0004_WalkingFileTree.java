//References
//
//FileChooser
//https://docs.oracle.com/javase/8/docs/api/javax/swing/JFileChooser.html
//http://www.java2s.com/Code/Java/Swing-JFC/SelectadirectorywithaJFileChooser.htm
//--walkFileTree

package JavaNIO;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.EnumSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.SwingConstants;

public class App0004_WalkingFileTree {

	private JFrame frmWalkingFileTree;
	private JFileChooser fileChooser;
	private JLabel lblStartDir;
	private MyFileVisitor<Path> myFileVisitor;
	private JButton btnGo;
	private Path startPath;
	private JTextPane outputConsole;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App0004_WalkingFileTree window = new App0004_WalkingFileTree();
					window.frmWalkingFileTree.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App0004_WalkingFileTree() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmWalkingFileTree = new JFrame();

		frmWalkingFileTree.setTitle("Walking File Tree Demo");
		frmWalkingFileTree.setBounds(100, 100, 597, 488);
		frmWalkingFileTree.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWalkingFileTree.getContentPane().setLayout(null);

		JLabel lblStartDirectory = new JLabel("Start Directory");
		lblStartDirectory.setBounds(5, 9, 71, 14);
		frmWalkingFileTree.getContentPane().add(lblStartDirectory);
		
		lblStartDir = new JLabel("c:\\");
		lblStartDir.setHorizontalAlignment(SwingConstants.LEFT);
		lblStartDir.setMaximumSize(new Dimension(0, 0));
		lblStartDir.setMinimumSize(new Dimension(0, 0));
		lblStartDir.setBounds(81, 9, 319, 14);
		lblStartDir.setForeground(new Color(0, 100, 0));
		lblStartDir.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblStartDir.setBackground(new Color(176, 224, 230));		
		frmWalkingFileTree.getContentPane().add(lblStartDir);

		btnGo = new JButton("GO!");
		btnGo.setBounds(509, 5, 69, 23);
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					fileChooser.setVisible(false);
					outputConsole.setVisible(true);
					outputConsole.setText("Reading...");
					Files.walkFileTree(startPath, EnumSet.of(FileVisitOption.FOLLOW_LINKS), Integer.MAX_VALUE,
							myFileVisitor);
					outputConsole.setText(myFileVisitor.getVisitorMessage());

				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});

		frmWalkingFileTree.getContentPane().add(btnGo);
		
		
		JButton btnChange = new JButton("change");
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnChange.setBounds(410, 5, 89, 23);
		btnChange.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				fileChooser.setVisible(true);
				outputConsole.setVisible(false);
				int returnVal = fileChooser.showOpenDialog(frmWalkingFileTree);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					startPath = Paths.get(fileChooser.getSelectedFile().getPath());

					lblStartDir.setText(fileChooser.getSelectedFile().getPath());
				}
			}
		});
		
		frmWalkingFileTree.getContentPane().add(btnChange);
				
		// --init the file chooser
		fileChooser = new JFileChooser();
		fileChooser.setBounds(5, 33, 582, 397);
		fileChooser.setVisible(false);
		fileChooser.setCurrentDirectory(new java.io.File(".")); // ref. #2
		fileChooser.setDialogTitle("choose a start directory");
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileChooser.setAcceptAllFileFilterUsed(false);
		frmWalkingFileTree.getContentPane().add(fileChooser);
				
				scrollPane = new JScrollPane();
				scrollPane.setBounds(15, 42, 563, 374);
				frmWalkingFileTree.getContentPane().add(scrollPane);
		
				outputConsole = new JTextPane();
				scrollPane.setViewportView(outputConsole);
				outputConsole.setText("PRUEBA");
				outputConsole.setEditable(false);
		
		myFileVisitor = new MyFileVisitor<Path>();
	}
}
