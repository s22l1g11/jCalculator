package de.zimmerpforte.dev.JCalculator;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private String[] operationButtonsValues = {"C","+","-","/","*","="};
	private JTextField result;
	private JPanel group1, group2, group3;
	private Box above, below, buttons;
	
	
	public void createComponents ()
	{
		// create Components
		
		for (int i=0;i<=5;i++)
		{
			operationButtons[i] = new JButton(operationButtonsValues[i]);
			operationButtons[i].addActionListener(this);
		}
		
		result = new JTextField ("",28);
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
	  group2.setPreferredSize (new Dimension (430,70));
	  group3.setPreferredSize (new Dimension (430,70));
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
	  super ("jCalculator2 - alpha");
	  // Komponenten erstellen
	  createComponents ();
	  setFormLayout ();
	  JPanel jCalculatorSurface  = new JPanel ();
	  jCalculatorSurface.setLayout (new FlowLayout());
	  // Alles einsetzen
	  group1.add (result);
	  for (int i=0;i<=7;i++)
		{
			group2.add(operationButtons[i]);
		}
	  jCalculatorSurface.add (above);
	  jCalculatorSurface.add (group1);
	  jCalculatorSurface.add (group2);
	  jCalculatorSurface.add (group3);
	  jCalculatorSurface.add (below);
	  jCalculatorSurface.add (buttons);
	  setContentPane (jCalculatorSurface);
	}
	
	public void actionPerformed (ActionEvent Ereignis)
	{
	  Object Quelle = Ereignis.getSource();
	  if (Quelle == operationButtons[0])  // Neu
	  {
	    result.setText(""); 
	    result.requestFocus();
	  } 
	  if (Quelle == operationButtons[1])  // Fertig
	  {
	  } 
	}
	
	
	public static void main(String[] args)
	{
	  JCalculator2 Rahmen = new JCalculator2 ();
	  Rahmen.setSize (450,350);
	  Rahmen.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	  Rahmen.setVisible(true);
	}


}
