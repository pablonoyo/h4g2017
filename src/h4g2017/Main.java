package h4g2017;

import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.JFrame;

public class Main{

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				
				MainWindow m = new MainWindow();
				
			}
		});

	}

}
