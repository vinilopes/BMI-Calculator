package main;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import gui.MainFrame;

public class ImcCalculator {
	
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(false);
		try{
		//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); 
	   } catch (Exception e) {
         //  System.err.println(“Look and feel not set.”);
         }
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new MainFrame();
				
			}
		});
				
	}
}
