package de.zimmerpforte.dev.JCalculator;


import java.awt.Container;
import java.io.*;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JCalculatorGUI extends JFrame {

	JFrame jCalculatorFrame;
	JPanel jCalculatorSurface;
	
	public JCalculatorGUI()
	{
		JCalculatorGUIButtons jCalcGUIButtons = new JCalculatorGUIButtons();
		
		jCalculatorFrame = new JFrame();
		jCalculatorFrame.setTitle("JCalculator - Alpha");
		jCalculatorFrame.setSize (500,480);
		jCalculatorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//create buttons
		jCalculatorFrame.setContentPane (jCalcGUIButtons.start());
		jCalculatorFrame.setVisible (true);
		try {
			getIpAddress();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	private void getIpAddress() throws IOException
	{
		URL whatismyip = new URL("http://checkip.amazonaws.com");
		BufferedReader in = new BufferedReader(new InputStreamReader(
		                whatismyip.openStream()));

		String ip = in.readLine(); //you get the IP as a String
		System.out.println(ip);
	}
	
}
