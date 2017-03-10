package h4g2017;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BackgorundPanel extends JPanel{
	
	public BackgorundPanel(){
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		try {
			g.drawImage(ImageIO.read(new File("Source/back.png")), 0, 0, getWidth(), getHeight(), null);
		} catch (IOException e) {
			System.err.println("Back not found");
		}

	}
}
