package de.zimmerpforte.dev.JCalculator;

import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JCalculatorGUIButtons {

	private JPanel jCalculatorSurface;
	
	/*
	 * define buttons
	 */
		// sign buttons
		private JButton plusSign = new JButton ("+");
		private JButton minusSign = new JButton ("-");
		private JButton multiplicationSign = new JButton ("*");
		private JButton devisionSign = new JButton ("/");
		private JButton sumSign = new JButton ("=");
		// numeric buttons
		private JButton[] numericButtons = new JButton[10];
		// create a label, even if this isn't a class for labels! I know, I know!
		Label yourIpAddress;
	
		
	// start() is like the constructor but is used the create a controlled start
	public Container start()
	{
		//createNumericButtons();
		setActionListeners();
		return createButtons();
	}
	
	/*
	 * createNumericButtons() creates - as the name assumes - buttons with numeric values
	 * those buttons are used for the numeric field on our calculator
	 * why am I doing this?
	 * because I want a working calculator that is able to sniff next to his mainfunction
	 * wasn't that easy?!
	 */
	
	public void createNumericButtons()
	{
		for (int i = 0;i<=9;i++)
		{
			String currentNumber = String.valueOf(i);
			numericButtons[i] = new JButton(currentNumber);
		}
	}
	
	// set Action Listener for every Button
	private void setActionListeners()
	{
		plusSign.addActionListener (new ActionListener()     
		{       
			public void actionPerformed (ActionEvent x)       
			{         
				JOptionPane.showMessageDialog(null, "Du hast + gedrueckt!");         
			}     
			}
		);
		
		minusSign.addActionListener (new ActionListener()     
		{       
			public void actionPerformed (ActionEvent x)       
			{         
				JOptionPane.showMessageDialog(null, "Du hast - gedrueckt!");         
			}     
			}
		);
		
		multiplicationSign.addActionListener (new ActionListener()     
		{       
			public void actionPerformed (ActionEvent x)       
			{         
				JOptionPane.showMessageDialog(null, "Du hast * gedrueckt!");         
			}     
			}
		);
		
		devisionSign.addActionListener (new ActionListener()     
		{       
			public void actionPerformed (ActionEvent x)       
			{         
				JOptionPane.showMessageDialog(null, "Du hast / gedrueckt!");         
			}     
			}
		);
		
		sumSign.addActionListener (new ActionListener()     
		{       
			public void actionPerformed (ActionEvent x)       
			{         
				JOptionPane.showMessageDialog(null, "Du hast = gedrueckt!");         
			}     
			}
		);
		
		for (int i = 0;i<=9;i++)
		{
			String currentNumber = String.valueOf(i);
			numericButtons[i] = new JButton(currentNumber);
		}
	}
	
	public Container createButtons()
	{
		for (int i = 0;i<=9;i++)
		{
			final int currentNumber = i;
			numericButtons[i].addActionListener (new ActionListener()     
			{       
				public void actionPerformed (ActionEvent x)       
				{         
					JOptionPane.showMessageDialog(null, "Du hast die Zahl "+ currentNumber +" gewaehlt!");         
				}     
				}
			);
		}
		
		
		jCalculatorSurface = new JPanel ();
		
		jCalculatorSurface.add (plusSign);    
		jCalculatorSurface.add (minusSign);
		jCalculatorSurface.add (multiplicationSign);
		jCalculatorSurface.add (devisionSign);
		jCalculatorSurface.add (sumSign);
		
		for (int i=0;i<=9;i++)
		{
			jCalculatorSurface.add (numericButtons[i]);
		}
		
	return jCalculatorSurface;  
	}
	
}
