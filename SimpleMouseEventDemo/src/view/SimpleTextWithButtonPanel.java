package view;

import java.awt.BorderLayout;

import javax.swing.*;

import listener.GoodbyeListener;

import listener.HelloMouseListener;

public class SimpleTextWithButtonPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static String hello = "Say Hello";
	private static String goodbye = "Say GoodBye";
	private JButton helloButton;
	private JButton goodbyeButton;
	private JTextArea text;
	
	public SimpleTextWithButtonPanel(){
		setLayout(new BorderLayout());
		text = new JTextArea();
		helloButton = new JButton(hello);
		helloButton.addMouseListener(new HelloMouseListener(text));
		goodbyeButton = new JButton(goodbye);
		goodbyeButton.addActionListener(new GoodbyeListener(text));
		add(helloButton,BorderLayout.PAGE_START);
		add(text,BorderLayout.CENTER);
		add(goodbyeButton,BorderLayout.PAGE_END);
	}	

}
