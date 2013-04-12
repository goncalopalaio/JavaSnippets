

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class GUI {
	// frame
	private JFrame frame = new JFrame("IRIS Brain");
	// panels
	private JPanel panelNorth = new JPanel();
	private JPanel panelSouth = new JPanel();
	private JPanel panelEast = new JPanel();
	private JPanel panelWest = new JPanel();
	private JPanel panelCenter = new JPanel();
	// elements
	private JEditorPane editorPane = new JEditorPane();
	private JScrollPane editorScrollPane = new JScrollPane(editorPane);
	private JButton btnWest = new JButton("West");
	private JButton btnEast = new JButton("East");
	private JButton btnSouth = new JButton("South");
	private JButton btnNorth = new JButton("North");
	// menubar
	private JMenuBar menubar = new JMenuBar();
	private JMenu menuFile = new JMenu("File");
	private JMenuItem menuItemQuit = new JMenuItem("Quit");
	private JMenu menuHelp = new JMenu("Help");
	private JMenuItem menuItemAbout = new JMenuItem("About");

	public GUI() {
		// set menubar
		frame.setJMenuBar(menubar);
		// build menu
		menuFile.add(menuItemQuit);
		menuHelp.add(menuItemAbout);
		menubar.add(menuFile);
		menubar.add(menuHelp);
		// setup editor scroll pane
		editorScrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		editorScrollPane.setPreferredSize(new Dimension(470, 600));
		editorScrollPane.setMinimumSize(new Dimension(10, 10));

		// add elements
		panelCenter.add(editorScrollPane);
		panelNorth.add(btnNorth);
		panelSouth.add(btnSouth);
		panelSouth.add(new JButton("Another Button"));

		panelEast.add(btnEast);
		panelWest.add(btnWest);

		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(panelNorth, BorderLayout.NORTH);
		frame.getContentPane().add(panelSouth, BorderLayout.SOUTH);
		frame.getContentPane().add(panelEast, BorderLayout.EAST);
		frame.getContentPane().add(panelWest, BorderLayout.WEST);
		frame.getContentPane().add(panelCenter, BorderLayout.CENTER);

		frame.addWindowListener(new ListenCloseWindow());
		menuItemQuit.addActionListener(new ListeMenuQuit());

	}
	public void setNativeTheme(){
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void launchFrame() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

}
