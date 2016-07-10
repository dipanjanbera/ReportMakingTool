/*
 * ********************************************************
 * OmniKey : A Workflow Driven Smart Data Extraction Tool *
 * ********************************************************
 * 
 * @Package 	:	com.tool.reportmaker.ui	
 * @File 	  	: 	DialogBoxUI.java
 * @Created  	: 	07-10-2016(mm-dd-yyyy)
 * @Version		:	2.1.0
 * @Author     	: 	Dipanjan Bera Copyright (2016)
 * @Email		:	dipanjan033@gmail.com
 * 
 */
package com.tool.reportmaker.ui;
import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;

// TODO: Auto-generated Javadoc
/**
 * The Class DialogBoxUI.
 */
public class DialogBoxUI extends JDialog {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new dialog box ui.
	 *
	 * @param parent
	 *            the parent
	 * @param title
	 *            the title
	 * @param message
	 *            the message
	 */
	public DialogBoxUI(JFrame parent, String title, String message) {
		super(parent, title);
		System.out.println("creating the window..");
		
		Point p = new Point(100, 100);
		setLocation(p.x, p.y);
		setLocationRelativeTo(null);
		
		JPanel messagePane = new JPanel();
		messagePane.add(new JLabel(message));
		messagePane.setSize(getHeight(), getWidth());
		getContentPane().add(messagePane);

		
		JPanel buttonPane = new JPanel();
		JButton button = new JButton("Close");
		buttonPane.add(button);
	
		button.addActionListener(new MyActionListener());
		getContentPane().add(buttonPane, BorderLayout.PAGE_END);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
		setSize(300, 150);
	}

	
	/* (non-Javadoc)
	 * @see javax.swing.JDialog#createRootPane()
	 */
	public JRootPane createRootPane() {
		JRootPane rootPane = new JRootPane();
		KeyStroke stroke = KeyStroke.getKeyStroke("ESCAPE");
		Action action = new AbstractAction() {
			
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				System.out.println("escaping..");
				setVisible(false);
				dispose();
			}
		};
		InputMap inputMap = rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		inputMap.put(stroke, "ESCAPE");
		rootPane.getActionMap().put("ESCAPE", action);
		return rootPane;
	}

	
	/**
	 * The listener interface for receiving myAction events. The class that is
	 * interested in processing a myAction event implements this interface, and
	 * the object created with that class is registered with a component using
	 * the component's <code>addMyActionListener<code> method. When the myAction
	 * event occurs, that object's appropriate method is invoked.
	 *
	 * @see MyActionEvent
	 */
	class MyActionListener implements ActionListener {

		
		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		public void actionPerformed(ActionEvent e) {
			System.out.println("disposing the window..");
			setVisible(false);
			dispose();
		}
	}
}