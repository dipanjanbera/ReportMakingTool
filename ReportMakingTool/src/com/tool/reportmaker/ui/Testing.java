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
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTree;
import javax.swing.UIManager;
import java.awt.Color;

// TODO: Auto-generated Javadoc
/**
 * The Class Testing.
 */
public class Testing extends JFrame {

	/** The content pane. */
	private JPanel contentPane;
	
	/** The work flow text field. */
	private JTextField workFlowTextField;
	
	/** The text field. */
	private JTextField textField;
	
	/** The chile tag text field. */
	private JTextField chileTagTextField;

	/**
	 * Launch the application.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Testing frame = new Testing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Testing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 941, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "WorkFlow", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 336, 218);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JRadioButton workflowselectExiting = new JRadioButton("Exiting Workfow");
		workflowselectExiting.setBounds(10, 31, 127, 23);
		panel.add(workflowselectExiting);
		
		JRadioButton workflowselectNew = new JRadioButton("New Workflow");
		workflowselectNew.setBounds(190, 31, 109, 23);
		panel.add(workflowselectNew);
		
		JLabel lblSelectExitingWorkflow = new JLabel("Select Exiting Workflow");
		lblSelectExitingWorkflow.setBounds(10, 103, 152, 14);
		panel.add(lblSelectExitingWorkflow);
		
		JComboBox workflowComboBox = new JComboBox();
		workflowComboBox.setBounds(172, 100, 127, 20);
		panel.add(workflowComboBox);
		
		JLabel lblAddNewWorkflow = new JLabel("Add New Workflow");
		lblAddNewWorkflow.setBounds(10, 167, 127, 14);
		panel.add(lblAddNewWorkflow);
		
		workFlowTextField = new JTextField();
		workFlowTextField.setBounds(172, 164, 127, 20);
		panel.add(workFlowTextField);
		workFlowTextField.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 61, 316, 2);
		panel.add(separator);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Parent Tag", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setLayout(null);
		panel_1.setBounds(356, 11, 336, 218);
		contentPane.add(panel_1);
		
		JRadioButton parentTagExitingradioButton = new JRadioButton("Exiting Parent Tag");
		parentTagExitingradioButton.setBounds(10, 27, 152, 23);
		panel_1.add(parentTagExitingradioButton);
		
		JRadioButton parentTagNewradioButton = new JRadioButton("New Parent Tag");
		parentTagNewradioButton.setBounds(177, 27, 127, 23);
		panel_1.add(parentTagNewradioButton);
		
		JLabel lblSelectExitingTag = new JLabel("Select Exiting Tag");
		lblSelectExitingTag.setBounds(10, 101, 127, 14);
		panel_1.add(lblSelectExitingTag);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(177, 98, 127, 20);
		panel_1.add(comboBox);
		
		JLabel lblAddNewTag = new JLabel("Add New Tag");
		lblAddNewTag.setBounds(10, 165, 127, 14);
		panel_1.add(lblAddNewTag);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(177, 162, 127, 20);
		panel_1.add(textField);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 57, 316, 2);
		panel_1.add(separator_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Child Tag", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 234, 682, 190);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel childTagName = new JLabel("Child Tag Name");
		childTagName.setBounds(123, 144, 101, 14);
		panel_2.add(childTagName);
		
		chileTagTextField = new JTextField();
		chileTagTextField.setBounds(234, 141, 240, 20);
		panel_2.add(chileTagTextField);
		chileTagTextField.setColumns(10);
		
		JRadioButton rdbtnNewChildTag = new JRadioButton("New Child Tag");
		rdbtnNewChildTag.setBounds(335, 25, 127, 23);
		panel_2.add(rdbtnNewChildTag);
		
		JRadioButton rdbtnExitingChildTag = new JRadioButton("Exiting Child Tag");
		rdbtnExitingChildTag.setBounds(168, 25, 152, 23);
		panel_2.add(rdbtnExitingChildTag);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(118, 68, 376, 2);
		panel_2.add(separator_2);
		
		JLabel label = new JLabel("Select Exiting Tag");
		label.setBounds(123, 99, 127, 14);
		panel_2.add(label);
		
		JComboBox childTagcomboBox_1 = new JComboBox();
		childTagcomboBox_1.setBounds(234, 96, 240, 20);
		panel_2.add(childTagcomboBox_1);
		
		JButton btnCancle = new JButton("Close");
		btnCancle.setBounds(521, 444, 102, 23);
		contentPane.add(btnCancle);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(695, 11, 220, 413);
		panel_3.setBorder(new TitledBorder(null, "Design", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JTree tree = new JTree();
		tree.setBackground(Color.WHITE);
		tree.setBounds(10, 21, 200, 381);
		panel_3.add(tree);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(409, 444, 102, 23);
		contentPane.add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(297, 444, 102, 23);
		contentPane.add(btnDelete);
	}
}
