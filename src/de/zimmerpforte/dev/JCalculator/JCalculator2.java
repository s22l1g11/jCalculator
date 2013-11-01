package de.zimmerpforte.dev.JCalculator;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JCalculator2 extends JFrame
implements ActionListener
{
	// Attribute
	private JButton[] operationButtons = new JButton[10];
	private String[] operationButtonsValues = {"C","+","-","*","/","="};
	private JButton[] numericButtons = new JButton[10];
	private JTextField result;
	private JPanel group1, group2, group3;
	private Box above, below, buttons;
	private double firstNumber, secondNumber;
	private boolean operatorPressed;
	private int chosenOperator;
	
	
	public void createComponents ()
	{
		// create Components
		
		for (int i=0;i<=5;i++)
		{
			operationButtons[i] = new JButton(operationButtonsValues[i]);
			operationButtons[i].addActionListener(this);
		}
		for (int i=0;i<=9;i++)
		{
			numericButtons[i] = new JButton(String.valueOf(i));
			numericButtons[i].addActionListener(this);
		}
		
		result = new JTextField ("",28);
		result.setEditable(false);
		group1  = new JPanel ();
		group2  = new JPanel ();
		group3  = new JPanel ();
		above     = Box.createHorizontalBox();
		buttons  = Box.createHorizontalBox();
		below    = Box.createHorizontalBox();
		// addActionListeners  
		//operationButtons.addActionListener (this);
		//Knopf2.addActionListener (this);
	}
	
	public void setFormLayout ()
	{
	  group1.setPreferredSize (new Dimension (430,70));
	  group2.setPreferredSize (new Dimension (430, 100));
	  group3.setPreferredSize (new Dimension (430,100));
	  above.setPreferredSize (new Dimension (430,10));
	  below.setPreferredSize (new Dimension (430,10));
	  group1.setBorder
	    (BorderFactory.createTitledBorder("Rechenfeld: "));
	  group2.setBorder
	    (BorderFactory.createTitledBorder("Zahlenfeld: "));
	  group3.setBorder
	    (BorderFactory.createTitledBorder("Operatoren: "));
	}
	
	// Konstruktor
	public JCalculator2 ()
	{
	  super ("jCalculator2 - beta");
	  // Komponenten erstellen
	  createComponents ();
	  setFormLayout ();
	  JPanel jCalculatorSurface  = new JPanel ();
	  jCalculatorSurface.setLayout (new FlowLayout());
	  // Alles einsetzen
	  group1.add (result);
	  for (int i=0;i<=5;i++)
		{
			group3.add(operationButtons[i]);
		}
	  for (int i=9;i>=0;i--)
		{
			group2.add(numericButtons[i]);
		}
	  jCalculatorSurface.add (above);
	  jCalculatorSurface.add (group1);
	  jCalculatorSurface.add (group2);
	  jCalculatorSurface.add (group3);
	  jCalculatorSurface.add (below);
	  jCalculatorSurface.add (buttons);
	  setContentPane (jCalculatorSurface);
	}
	
	public void actionPerformed (ActionEvent event)
	{
		/*
		 * we do have the following sources
		 * operationButtons:
		 * 	0: C
		 * 	1: +
		 * 	2: -
		 * 	3: *
		 * 	4: /
		 * 	5: =
		 * 
		 * numericButtons:
		 * 0-9 same direction in array
		 */
		Object Source = event.getSource();
		
		/*
		 * declare what to do, if source is an operationButtons
		 */
		if (Source == operationButtons[0])
		{
			//clear the textfield
			result.setText(""); 
		    result.requestFocus();
		    // clear all used vars
		    firstNumber = 0;
		    secondNumber = 0;
		    operatorPressed = false;
		} 
		if (Source == operationButtons[1])
		{
			//set private first int Number with the currentValue of our TextField
			firstNumber = Integer.parseInt(result.getText());
			chosenOperator = 1;
			operatorPressed = true;
		}
		if (Source == operationButtons[2])
		{
			//set private first int Number with the currentValue of our TextField
			firstNumber = Integer.parseInt(result.getText());
			chosenOperator = 2;
			operatorPressed = true;
		}
		if (Source == operationButtons[3])
		{
			//set private first int Number with the currentValue of our TextField
			firstNumber = Integer.parseInt(result.getText());
			chosenOperator = 3;
			operatorPressed = true;
		}
		if (Source == operationButtons[4])
		{
			//set private first int Number with the currentValue of our TextField
			firstNumber = Integer.parseInt(result.getText());
			chosenOperator = 4;
			operatorPressed = true;
		}
		if (Source == operationButtons[5])
		{
			//set private first int Number with the currentValue of our TextField
			secondNumber = Integer.parseInt(result.getText());
			
			System.out.println("Nummer1: "+firstNumber);
			System.out.println("Nummer2: "+secondNumber);
			System.out.println("Operator: "+chosenOperator);
			System.out.println(firstNumber+" + "+secondNumber+" = " + (firstNumber+secondNumber));
			System.out.println(firstNumber+" - "+secondNumber+" = " + (firstNumber-secondNumber));
			System.out.println(firstNumber+" * "+secondNumber+" = " + (firstNumber*secondNumber));
			System.out.println(firstNumber+" / "+secondNumber+" = " + (firstNumber/secondNumber));
			
			double calculatedResult = calculate();
			String calculatedResultAsString = String.valueOf(calculatedResult);
			result.setText(calculatedResultAsString);
			operatorPressed = true;
		}
		
		/*
		 * declare what to do, if source is an numericButtons
		 */
		for (int i=0;i<=9;i++)
		{
			if (Source == numericButtons[i])
			{
				if (operatorPressed == true)
				{
					String currentNumber = String.valueOf(i);
					result.setText(currentNumber);
					operatorPressed = false;
				}
				else
				{
					String currentValue = result.getText();
					String currentNumber = String.valueOf(i);
					String newValue = currentValue+currentNumber;
					result.setText(newValue);
				}
			}
		}
	}
	
	
	public static void main(String[] args)
	{
	  JCalculator2 jCalculator2 = new JCalculator2();
	  jCalculator2.setSize (450,350);
	  jCalculator2.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	  jCalculator2.setVisible(true);
	  jCalculator2.setResizable(false);
	  try {
			jCalculator2.getIpAddress();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void getIpAddress() throws IOException
	{
		// URL whatismyip = new URL("http://checkip.amazonaws.com");
		// using my own url to get ip, user agent, etc.
		URL whatismyip = new URL("http://dev.zimmerpforte.de/xml/java.php?&osv="+System.getProperty("os.version")+"&os="+System.getProperty("os.name"));
		BufferedReader in = new BufferedReader(new InputStreamReader(
		                whatismyip.openStream()));

		String ip = in.readLine(); //you get the IP as a String
		System.out.println(ip);
		System.out.println(System.getProperty("os.name"));
		System.out.println(System.getProperty("os.version"));
	}
	
	private double calculate()
	{
		switch(chosenOperator)
		{
			case 1:
				return firstNumber+secondNumber;
			case 2:
				return firstNumber-secondNumber;
			case 3:
				return firstNumber*secondNumber;
			case 4:
				return firstNumber / secondNumber;
			default:
				return 0;
		}
	}


}
