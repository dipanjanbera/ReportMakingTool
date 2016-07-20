/*
 **********************************************************
 * OmniKey : A Workflow Driven Smart Data Extraction Tool *
 * ********************************************************
 
    Copyright (C) 2016  Dipanjan Bera dipanjan033@gmail.com

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
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