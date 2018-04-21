
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;


public class Game {
	JFrame window;
	Container con;
	JPanel titleNamePanel, startButtonPanel, loadButtonPanel, exitButtonPanel;
	JLabel titleNameLabel;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
	JButton startButton, loadButton, exitButton;
	

	public static void main(String[] args) {
		new Game();

	}
	public Game() {
		
		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		window.setVisible(true);
		con = window.getContentPane();
		
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 150);
		titleNamePanel.setBackground(Color.blue);
		titleNameLabel = new JLabel("Eriekith");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(100, 400, 200, 100);
		startButtonPanel.setBackground(Color.black);
		
		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		
		loadButtonPanel = new JPanel();
		loadButtonPanel.setBounds(300, 400, 200, 100);
		loadButtonPanel.setBackground(Color.black);
		
		loadButton = new JButton("LOAD");
		loadButton.setBackground(Color.black);
		loadButton.setForeground(Color.white);
		loadButton.setFont(normalFont);
		
		exitButtonPanel = new JPanel();
		exitButtonPanel.setBounds(500, 400, 200, 100);
		exitButtonPanel.setBackground(Color.black);
		
		exitButton = new JButton("EXIT");
		exitButton.setBackground(Color.black);
		exitButton.setForeground(Color.white);
		exitButton.setFont(normalFont);
		
		titleNamePanel.add(titleNameLabel);
		loadButtonPanel.add(loadButton);
		startButtonPanel.add(startButton);
		exitButtonPanel.add(exitButton);
		
		con.add(titleNamePanel);
		con.add(startButtonPanel);
		con.add(loadButtonPanel);
		con.add(exitButtonPanel);	
		
		
	}

}