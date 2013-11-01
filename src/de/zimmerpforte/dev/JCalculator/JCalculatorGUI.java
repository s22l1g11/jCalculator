package de.zimmerpforte.dev.JCalculator;


import java.awt.Container;
import java.awt.HeadlessException;
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
		JCalculatorGUIElements jCalcGUIButtons = new JCalculatorGUIElements();
		
		jCalculatorFrame = new JFrame();
		jCalculatorFrame.setTitle("JCalculator - Alpha");
		jCalculatorFrame.setSize (450,350);
		jCalculatorFrame.setResizable(false);
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

	
	/*
	 * the following function is copy&pasted from:
	 * http://stackoverflow.com/questions/2939218/getting-the-external-ip-address-in-java
	 */
	
	private void getIpAddress() throws IOException
	{
		URL whatismyip = new URL("http://checkip.amazonaws.com");
		BufferedReader in = new BufferedReader(new InputStreamReader(
		                whatismyip.openStream()));

		String ip = in.readLine(); //you get the IP as a String
		System.out.println(ip);
	}
	
}
