import java.awt.*;
import javax.swing.*;

public class Main extends JFrame{

	
	public Main () {
		super("RPG Game");
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);

		Game play = new Game();
		((Component) play).setFocusable(true);
		
		Color RoyalBlue = new Color(7,0,51);
		
		
		setBackground(RoyalBlue);
		
		
		getContentPane().add(play);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	

	public static void main(String[] args) {
		Main run = new Main();
		

	}


}