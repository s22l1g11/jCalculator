package de.zimmerpforte.dev.JCalculator;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JCalculatorGUIElements {

	private JPanel jCalculatorSurface;
	private Box jCalculatorLowerBox;
	
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
	
		/*
		 * create a TextField to show the result
		 */
		private JTextField result;
	
		
	// start() is like the constructor but is used the create a controlled start
	public Container start()
	{
		//createNumericButtons();
		setActionListeners();
		return createElements();
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
	}
	
	public Container createElements()
	{
		/*
		 * getContentPane
		 */
		
		/*
		 * create JTextField and set it uneditable
		 */
		result = new JTextField();
		result.setVisible(true);
		result.setEditable(true);

		/*
		 * create JPanel
		 */
		jCalculatorSurface = new JPanel ();
		
		/*
		 * create a new GridLayout();
		 * create boxlayout
		 */
		//jCalculatorSurface.setLayout(new GridLayout(4,4));
		jCalculatorLowerBox = Box.createHorizontalBox();
		
		/*
		 * add JTextField to JPanel
		 */
		jCalculatorSurface.add(result);
		
		/*
		 * add numericButtons[] to jCalculatorSurface
		 */
		for (int i=9;i>=0;i--)
		{
			numericButtons[i].setPreferredSize(new Dimension(64, 26));
			jCalculatorSurface.add (numericButtons[i]);
		}
		
		/*
		 * set size of sign-buttons
		 */
		sumSign.setPreferredSize(new Dimension(64*2, 26*2));
		plusSign.setPreferredSize(new Dimension(64, 26));
		minusSign.setPreferredSize(new Dimension(64, 26));
		multiplicationSign.setPreferredSize(new Dimension(64, 26));
		devisionSign.setPreferredSize(new Dimension(64, 26));
		
		/*
		 * add sign-buttons to jCalculatorSurface
		 */
		jCalculatorLowerBox.add(plusSign);
		jCalculatorLowerBox.add(minusSign);
		jCalculatorLowerBox.add(multiplicationSign);
		jCalculatorLowerBox.add(devisionSign);
		jCalculatorLowerBox.add(sumSign);
		
		/*jCalculatorSurface.add (plusSign);    
		jCalculatorSurface.add (minusSign);
		jCalculatorSurface.add (multiplicationSign);
		jCalculatorSurface.add (devisionSign);
		jCalculatorSurface.add (sumSign);*/
		
		jCalculatorSurface.add(jCalculatorLowerBox);
		
		/*
		 * return jCalculatorSurface
		 */
		return jCalculatorSurface;  
	}
	
}
