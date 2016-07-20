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

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import com.tool.reportmaker.exception.WorkFlowDuplicateElementException;
import com.tool.reportmaker.exception.WorkFlowTreeDrawingFailedException;
import com.tool.reportmaker.exception.WorkFlowValidationException;
import com.tool.reportmaker.interfaces.AppConstants;
import com.tool.reportmaker.interfaces.WorkFlowConstants;
import com.tool.reportmaker.object.DataManagerObject;
import com.tool.reportmaker.service.ReportMakerToolService;
import com.tool.reportmaker.service.WorkFlowManagerService;
import com.tool.reportmaker.util.Util;

// TODO: Auto-generated Javadoc
/**
 * The Class WorkflowDialogUI.
 */
public class WorkflowDialogUI extends JFrame implements ItemListener, ActionListener, TreeSelectionListener {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The content pane. */
	private JFrame contentPane;

	/** The work flow text field. */
	private JTextField workFlowTextField;

	/** The parent text field. */
	private JTextField parentTextField;

	/** The chile tag text field. */
	private JTextField chileTagTextField;

	/** The workflow combo box. */
	private JComboBox parentComboBox, childTagcomboBox_1, workflowComboBox;

	/** The rdbtn new child tag. */
	private JRadioButton workflowselectExiting, workflowselectNew, parentTagExitingradioButton, parentTagNewradioButton,
			rdbtnExitingChildTag, rdbtnNewChildTag;

	/** The btn close. */
	private JButton btnUpdate, btnAdd, btnDelete, btnSave, btnClose;

	/** The menu bar. */
	private JMenuBar menuBar;

	/** The mn new menu. */
	private JMenu mnNewMenu, mnEditMenu;

	/** The mntm import file. */
	private JMenuItem mntmNewMenuItem, mntmImportFile, mntmAddMenuItem, mntmDeleteMenuItem, mntmUpdateMenuItem,
			mntmExitMenuItem, keyboardShortcutMenuItem, mntmNewWorkflowMenuItem;

	/** The work flow service. */
	private WorkFlowManagerService workFlowService = null;

	/** The report maker tool service. */
	private ReportMakerToolService reportMakerToolService = null;

	/** The data manager object. */
	DataManagerObject dataManagerObject = null;

	/** The tree. */
	private JTree tree;

	/** The key stroke to open. */
	private KeyStroke keyStrokeToOpen;

	/** The selected values from jtree. */
	String[] selectedValuesFromJtree = null;

	/** The selected itemfrom jtree. */
	String selectedItemfromJtree = null;

	/** The scroll pane. */
	JScrollPane scrollPane;

	/**
	 * Instantiates a new workflow dialog ui.
	 *
	 * @param reportMakerToolService
	 *            the report maker tool service
	 * @param workFlowManagerService
	 *            the work flow manager service
	 */
	public WorkflowDialogUI(ReportMakerToolService reportMakerToolService,
			WorkFlowManagerService workFlowManagerService) {
		super();
		initializedGUI();
		workFlowService = workFlowManagerService;
		this.reportMakerToolService = reportMakerToolService;
		dataManagerObject = workFlowManagerService.getDataManagerObject();
		importWorkflowIfExists(dataManagerObject.getFileLocation());
	}

	/**
	 * Initialized gui.
	 */
	public void initializedGUI() {

		contentPane = new JFrame();

		contentPane.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		contentPane.setTitle(AppConstants.DialogBoxHeader.WORKFLOW_MANAGER);

		contentPane.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exitProgram();

			}
		});

		contentPane.setBounds(100, 100, 941, 524);

		// contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		contentPane.setLayout(null);

		final JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "WorkFlow", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 36, 336, 218);
		contentPane.add(panel);
		panel.setLayout(null);

		workflowselectExiting = new JRadioButton("Exiting Workfow");
		workflowselectExiting.setBounds(10, 31, 127, 23);
		panel.add(workflowselectExiting);

		workflowselectNew = new JRadioButton("New Workflow");
		workflowselectNew.setBounds(190, 31, 109, 23);
		panel.add(workflowselectNew);

		final JLabel lblSelectExitingWorkflow = new JLabel("Select Exiting Workflow");
		lblSelectExitingWorkflow.setBounds(10, 103, 152, 14);
		panel.add(lblSelectExitingWorkflow);

		workflowComboBox = new JComboBox();
		workflowComboBox.setBounds(172, 100, 127, 20);
		panel.add(workflowComboBox);

		final JLabel lblAddNewWorkflow = new JLabel("Add New Workflow");
		lblAddNewWorkflow.setBounds(10, 167, 127, 14);
		panel.add(lblAddNewWorkflow);

		workFlowTextField = new JTextField();
		workFlowTextField.setBounds(172, 164, 127, 20);
		panel.add(workFlowTextField);
		workFlowTextField.setColumns(10);

		final JSeparator separator = new JSeparator();
		separator.setBounds(10, 61, 316, 2);
		panel.add(separator);

		final JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Parent Tag", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setLayout(null);
		panel_1.setBounds(356, 36, 336, 218);
		contentPane.add(panel_1);

		parentTagExitingradioButton = new JRadioButton("Exiting Parent Tag");
		parentTagExitingradioButton.setBounds(10, 27, 152, 23);
		panel_1.add(parentTagExitingradioButton);

		parentTagNewradioButton = new JRadioButton("New Parent Tag");
		parentTagNewradioButton.setBounds(177, 27, 127, 23);
		panel_1.add(parentTagNewradioButton);

		final JLabel lblSelectExitingTag = new JLabel("Select Exiting Tag");
		lblSelectExitingTag.setBounds(10, 101, 127, 14);
		panel_1.add(lblSelectExitingTag);

		parentComboBox = new JComboBox();
		parentComboBox.setBounds(177, 98, 127, 20);
		panel_1.add(parentComboBox);

		final JLabel lblAddNewTag = new JLabel("Add New Parent Tag");
		lblAddNewTag.setBounds(10, 165, 127, 14);
		panel_1.add(lblAddNewTag);

		parentTextField = new JTextField();
		parentTextField.setColumns(10);
		parentTextField.setBounds(177, 162, 127, 20);
		panel_1.add(parentTextField);

		final JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 57, 316, 2);
		panel_1.add(separator_1);

		final JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Child Tag", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 259, 682, 190);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		final JLabel childTagName = new JLabel("Add New Child Tag");
		childTagName.setBounds(118, 144, 106, 14);
		panel_2.add(childTagName);

		chileTagTextField = new JTextField();
		chileTagTextField.setBounds(234, 141, 240, 20);
		panel_2.add(chileTagTextField);
		chileTagTextField.setColumns(10);

		rdbtnNewChildTag = new JRadioButton("New Child Tag");
		rdbtnNewChildTag.setBounds(335, 25, 127, 23);
		panel_2.add(rdbtnNewChildTag);

		rdbtnExitingChildTag = new JRadioButton("Exiting Child Tag");
		rdbtnExitingChildTag.setBounds(168, 25, 152, 23);
		panel_2.add(rdbtnExitingChildTag);

		final JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(118, 68, 376, 2);
		panel_2.add(separator_2);

		final JLabel label = new JLabel("Select Exiting Tag");
		label.setBounds(123, 99, 127, 14);
		panel_2.add(label);

		childTagcomboBox_1 = new JComboBox();
		childTagcomboBox_1.setBounds(234, 96, 240, 20);
		panel_2.add(childTagcomboBox_1);

		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(402, 465, 102, 23);
		contentPane.add(btnUpdate);

		final JPanel panel_3 = new JPanel();
		panel_3.setBounds(695, 36, 220, 413);
		panel_3.setBorder(new TitledBorder(null, "Design", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 200, 381);
		panel_3.add(scrollPane);

		tree = new JTree();
		scrollPane.setViewportView(tree);
		tree.setBackground(Color.WHITE);
		tree.setBounds(10, 21, 200, 381);
		tree.setShowsRootHandles(true);
		tree.setRootVisible(true);
		tree.setVisibleRowCount(200);
		tree.setAutoscrolls(true);
		tree.setModel(null);

		btnAdd = new JButton("Add");
		btnAdd.setBounds(290, 465, 102, 23);
		contentPane.add(btnAdd);

		btnDelete = new JButton("Delete");
		btnDelete.setBounds(178, 465, 102, 23);
		contentPane.add(btnDelete);

		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 925, 21);
		contentPane.add(menuBar);

		mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);

		mntmNewWorkflowMenuItem = new JMenuItem("New");
		mnNewMenu.add(mntmNewWorkflowMenuItem);

		mntmNewWorkflowMenuItem.setMnemonic(KeyEvent.VK_N);
		keyStrokeToOpen = KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK);
		mntmNewWorkflowMenuItem.setAccelerator(keyStrokeToOpen);

		mntmNewMenuItem = new JMenuItem("Save");
		mnNewMenu.add(mntmNewMenuItem);

		mntmNewMenuItem.setMnemonic(KeyEvent.VK_S);
		keyStrokeToOpen = KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK);
		mntmNewMenuItem.setAccelerator(keyStrokeToOpen);

		mntmImportFile = new JMenuItem("Import File");
		mnNewMenu.add(mntmImportFile);
		mntmImportFile.setMnemonic(KeyEvent.VK_I);
		keyStrokeToOpen = KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK);
		mntmImportFile.setAccelerator(keyStrokeToOpen);

		mntmExitMenuItem = new JMenuItem("Exit");
		mnNewMenu.add(mntmExitMenuItem);
		mntmExitMenuItem.setMnemonic(KeyEvent.VK_Q);
		keyStrokeToOpen = KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK);
		mntmExitMenuItem.setAccelerator(keyStrokeToOpen);

		mnEditMenu = new JMenu("Edit");
		menuBar.add(mnEditMenu);

		mntmAddMenuItem = new JMenuItem("Add Node");
		mnEditMenu.add(mntmAddMenuItem);
		mntmAddMenuItem.setMnemonic(KeyEvent.VK_SPACE);
		keyStrokeToOpen = KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, InputEvent.CTRL_DOWN_MASK);
		mntmAddMenuItem.setAccelerator(keyStrokeToOpen);

		mntmUpdateMenuItem = new JMenuItem("Update Node");
		mnEditMenu.add(mntmUpdateMenuItem);
		mntmUpdateMenuItem.setMnemonic(KeyEvent.VK_U);
		keyStrokeToOpen = KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_DOWN_MASK);
		mntmUpdateMenuItem.setAccelerator(keyStrokeToOpen);

		mntmDeleteMenuItem = new JMenuItem("Delete Node");
		mnEditMenu.add(mntmDeleteMenuItem);
		mntmDeleteMenuItem.setMnemonic(KeyEvent.VK_D);
		keyStrokeToOpen = KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK);
		mntmDeleteMenuItem.setAccelerator(keyStrokeToOpen);

		final JMenu keyboardShortcut = new JMenu("Keyboard Shortcut");
		menuBar.add(keyboardShortcut);

		keyboardShortcutMenuItem = new JMenuItem("Keyboard Shortcut List");
		keyboardShortcut.add(keyboardShortcutMenuItem);

		contentPane.setLocationRelativeTo(null);
		contentPane.setResizable(false);
		contentPane.setVisible(true);

		btnSave = new JButton("Save");
		btnSave.setBounds(514, 465, 89, 23);
		contentPane.add(btnSave);

		btnClose = new JButton("Close");
		btnClose.setBounds(613, 465, 89, 23);
		contentPane.add(btnClose);

		addRadioButtonGroup();
		addActionListener();
		setDefaultStateValue();
		radioBoxController();

	}

	/**
	 * Adds the radio button group.
	 */
	private void addRadioButtonGroup() {

		final ButtonGroup childRadioButtongrp = new ButtonGroup();
		childRadioButtongrp.add(rdbtnNewChildTag);
		childRadioButtongrp.add(rdbtnExitingChildTag);

		final ButtonGroup parentRadioButtongrp = new ButtonGroup();
		parentRadioButtongrp.add(parentTagExitingradioButton);
		parentRadioButtongrp.add(parentTagNewradioButton);

		final ButtonGroup workflowRadioButtongrp = new ButtonGroup();
		workflowRadioButtongrp.add(workflowselectNew);
		workflowRadioButtongrp.add(workflowselectExiting);

	}

	/**
	 * Sets the default state value.
	 */
	private void setDefaultStateValue() {

		workflowselectExiting.setSelected(true);
		parentTagExitingradioButton.setSelected(true);
		rdbtnExitingChildTag.setSelected(true);

		workFlowTextField.setEnabled(false);
		parentTextField.setEnabled(false);
		chileTagTextField.setEnabled(false);

		/*
		 * parentComboBox.addItem("India"); parentComboBox.addItem("Pakistan");
		 *
		 * workflowComboBox.addItem("Cricket");
		 * workflowComboBox.addItem("FootBall");
		 */

	}

	/**
	 * Radio box controller.
	 */
	private void radioBoxController() {

		if (workflowComboBox.getItemCount() == 0) {
			workflowselectNew.setSelected(true);
		} else {
			workflowselectExiting.setSelected(false);
		}

		if (parentComboBox.getItemCount() == 0) {
			parentTagNewradioButton.setSelected(true);
		} else {
			parentTagExitingradioButton.setSelected(false);
		}

		if (childTagcomboBox_1.getItemCount() == 0) {
			rdbtnNewChildTag.setSelected(true);
		} else {
			rdbtnExitingChildTag.setSelected(false);
		}

		if (workflowselectNew.isSelected()) {
			workFlowTextField.setEnabled(true);
		} else {
			workFlowTextField.setEnabled(false);
		}

		if (parentTagNewradioButton.isSelected()) {
			parentTextField.setEnabled(true);
		} else {
			parentTextField.setEnabled(false);

		}

		if (rdbtnNewChildTag.isSelected()) {
			chileTagTextField.setEnabled(true);
		} else {
			chileTagTextField.setEnabled(false);
		}

		if (workflowselectExiting.isSelected()) {
			workflowComboBox.setEnabled(true);
		} else {
			workflowComboBox.setEnabled(false);
		}

		if (parentTagExitingradioButton.isSelected()) {
			parentComboBox.setEnabled(true);
		} else {
			parentComboBox.setEnabled(false);

		}

		if (rdbtnExitingChildTag.isSelected()) {
			childTagcomboBox_1.setEnabled(true);
		} else {
			childTagcomboBox_1.setEnabled(false);
		}

	}

	/**
	 * Adds the action listener.
	 */
	private void addActionListener() {

		parentTagExitingradioButton.addActionListener(this);
		parentTagNewradioButton.addActionListener(this);
		workflowselectExiting.addActionListener(this);
		workflowselectNew.addActionListener(this);
		rdbtnExitingChildTag.addActionListener(this);
		rdbtnNewChildTag.addActionListener(this);
		parentComboBox.addActionListener(this);
		childTagcomboBox_1.addActionListener(this);
		workflowComboBox.addItemListener(this);
		btnUpdate.addActionListener(this);
		btnAdd.addActionListener(this);
		btnDelete.addActionListener(this);
		btnSave.addActionListener(this);
		btnClose.addActionListener(this);
		tree.addTreeSelectionListener(this);
		mntmImportFile.addActionListener(this);
		mntmNewMenuItem.addActionListener(this);
		mntmUpdateMenuItem.addActionListener(this);
		mntmAddMenuItem.addActionListener(this);
		mntmDeleteMenuItem.addActionListener(this);
		mntmExitMenuItem.addActionListener(this);
		keyboardShortcutMenuItem.addActionListener(this);
		mntmNewWorkflowMenuItem.addActionListener(this);
	}

	/**
	 * Action performed.
	 *
	 * @param actionEvent
	 *            the action event
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		// TODO Auto-generated method stub

		radioBoxActionPerform(actionEvent);
		comboBoxActionPerfored(actionEvent);
		buttonAddActionPerform(actionEvent);
		menuItemActionPerform(actionEvent);
	}

	/**
	 * Menu item action perform.
	 *
	 * @param actionEvent
	 *            the action event
	 */
	private void menuItemActionPerform(ActionEvent actionEvent) {
		if (actionEvent.getSource() == mntmNewMenuItem) {
			saveWorkflowDiagram();
		}

		if (actionEvent.getSource() == mntmImportFile) {
			openDialogBoxForImportFile();
		}
		if (actionEvent.getSource() == mntmAddMenuItem) {
			onAddButtonClick();
		}
		if (actionEvent.getSource() == mntmUpdateMenuItem) {
			onUpdateButtonClick();
		}
		if (actionEvent.getSource() == mntmDeleteMenuItem) {
			onDeleteButtonClick();
		}
		if (actionEvent.getSource() == mntmExitMenuItem) {
			exitProgram();
		}
		if (actionEvent.getSource() == keyboardShortcutMenuItem) {
			Util.showKeyboardShortcut();
		}
		if (actionEvent.getSource() == mntmNewWorkflowMenuItem) {
			createNewWorkFlow();
		}
	}

	/**
	 * Creates the new work flow.
	 */
	private void createNewWorkFlow() {
		restartProgram();

		// new WorkflowDialogUI(reportMakerToolService, workFlowService);
	}

	/**
	 * Button add action perform.
	 *
	 * @param action
	 *            the action
	 */
	private void buttonAddActionPerform(ActionEvent action) {

		if (action.getSource() == btnAdd) {
			onAddButtonClick();
		}
		if (action.getSource() == btnUpdate) {
			onUpdateButtonClick();
		}

		if (action.getSource() == btnDelete) {
			onDeleteButtonClick();
		}
		if (action.getSource() == btnSave) {
			saveWorkflowDiagram();

		}
		if (action.getSource() == btnClose) {
			exitProgram();
		}

	}

	/**
	 * Combo box action perfored.
	 *
	 * @param actionEvent
	 *            the action event
	 */
	private void comboBoxActionPerfored(ActionEvent actionEvent) {
		System.out.println("Action " + actionEvent.getSource());
		if (actionEvent.getSource() == parentComboBox) {
			resetChildPanel();
			// comboBoxController(parentComboBox.getSelectedItem().toString(),
			// workflowComboBox.getSelectedItem().toString(), 0);

		}
		if (actionEvent.getSource() == workflowComboBox) {
			resetParentPanel();
			resetChildPanel();

		}
		if (actionEvent.getSource() == childTagcomboBox_1) {

		}
	}

	/**
	 * Radio box action perform.
	 *
	 * @param actionEvent
	 *            the action event
	 */
	private void radioBoxActionPerform(ActionEvent actionEvent) {

		if (actionEvent.getSource() == parentTagExitingradioButton) {
			parentTagExitingradioButton.setEnabled(true);
			radioBoxController();
			comboBoxController(null, workflowComboBox.getSelectedItem().toString(), 2);

		}

		if (actionEvent.getSource() == parentTagNewradioButton) {

			radioBoxController();
		}
		if (actionEvent.getSource() == workflowselectExiting) {

			radioBoxController();
			comboBoxController(null, null, 1);
			resetParentPanel();
			resetChildPanel();

		}

		if (actionEvent.getSource() == workflowselectNew) {

			radioBoxController();

		}

		if (actionEvent.getSource() == rdbtnExitingChildTag) {
			rdbtnExitingChildTag.setEnabled(true);
			radioBoxController();
			comboBoxController(parentComboBox.getSelectedItem().toString(),
					workflowComboBox.getSelectedItem().toString(), 3);

		}

		if (actionEvent.getSource() == rdbtnNewChildTag) {

			radioBoxController();
		}
	}

	/**
	 * Item state changed.
	 *
	 * @param arg0
	 *            the arg0
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
	 */
	@Override
	public void itemStateChanged(ItemEvent arg0) {

		if (arg0.getSource() == workflowComboBox) {
			if (arg0.getStateChange() == ItemEvent.SELECTED) {
				final Object item = arg0.getItem();
				System.out.println(item);
				parentTagNewradioButton.setSelected(true);
				parentTextField.setEnabled(true);
				parentComboBox.setEnabled(false);
			}

		}
	}

	/**
	 * On add button click.
	 */
	@SuppressWarnings("unused")
	private void onAddButtonClick() {

		String seletedWorkFlowName = "";
		String seletedParentName = "";
		String seletedChildName = "";

		// For WorkFlow Panel

		if (workflowselectExiting.isSelected()) {
			seletedWorkFlowName = workflowComboBox.getSelectedItem().toString();
		} else if (workflowselectNew.isSelected()) {
			seletedWorkFlowName = workFlowTextField.getText();
		}

		// For Parent Panel

		if (parentTagExitingradioButton.isSelected()) {
			seletedParentName = parentComboBox.getSelectedItem().toString();
		} else if (parentTagNewradioButton.isSelected()) {
			seletedParentName = parentTextField.getText();
		}

		// For Child Panel

		if (rdbtnExitingChildTag.isSelected()) {
			seletedChildName = childTagcomboBox_1.getSelectedItem().toString();
		} else if (rdbtnNewChildTag.isSelected()) {
			seletedChildName = chileTagTextField.getText();
		}

		try {
			final DataManagerObject dataManagerObject = workFlowService.createWorkflow(seletedWorkFlowName,
					seletedParentName, seletedChildName);

			if (dataManagerObject != null) {
				try {

					final DefaultMutableTreeNode treeNode = workFlowService.createWorkFlowTree();
					final DefaultTreeModel treeModel = new DefaultTreeModel(treeNode);
					tree.setModel(treeModel);
					for (int i = 0; i < tree.getRowCount(); i++) {
						tree.expandRow(i);
					}

				} catch (final WorkFlowTreeDrawingFailedException e) {

					e.printStackTrace();
				}
			}
		} catch (final WorkFlowValidationException e) {
			JOptionPane.showMessageDialog(this, "" + e.getMessage());
			e.printStackTrace();
		} catch (final WorkFlowDuplicateElementException e) {
			JOptionPane.showMessageDialog(this, "" + e.getMessage());
			e.printStackTrace();
		}

		System.out.println("WORKFLOW : " + !seletedWorkFlowName.equals("") + " ParentName : " + seletedParentName
				+ "  ChildName : " + seletedChildName);

	}

	/**
	 * On delete button click.
	 */
	private void onDeleteButtonClick() {

		if (selectedValuesFromJtree != null) {
			final int dialogResult = JOptionPane.showConfirmDialog(null,
					WorkFlowConstants.DataImportDialogBoxConstants.deleteConfirmConstants.DELETE_CONFORMATION_MSG,
					WorkFlowConstants.DataImportDialogBoxConstants.deleteConfirmConstants.DELETE_CONFORMATION_HEADER,
					JOptionPane.YES_NO_OPTION);
			if (dialogResult == JOptionPane.YES_OPTION) {
				if (workFlowService.deleteNodeController(selectedValuesFromJtree)) {
					try {

						final DefaultMutableTreeNode treeNode = workFlowService.createWorkFlowTree();
						final DefaultTreeModel treeModel = new DefaultTreeModel(treeNode);
						tree.setModel(treeModel);
						for (int i = 0; i < tree.getRowCount(); i++) {
							tree.expandRow(i);
						}
					} catch (final WorkFlowTreeDrawingFailedException e) {
						e.printStackTrace();
					}

					comboBoxController("", "", 1);
				}
			}

		} else {
			JOptionPane.showMessageDialog(null, "Please Select a Node from Tree Diagram");
		}
	}

	/**
	 * On update button click.
	 */
	private void onUpdateButtonClick() {

		if (selectedValuesFromJtree != null) {
			final JFrame frame = new JFrame("");
			final String tagNmaetoBeUpdated = JOptionPane.showInputDialog(frame,
					"Update Tag Name : " + selectedItemfromJtree);
			if (!tagNmaetoBeUpdated.equals("")) {
				if (workFlowService.updateNodeController(selectedValuesFromJtree, tagNmaetoBeUpdated)) {
					try {
						final DefaultMutableTreeNode treeNode = workFlowService.createWorkFlowTree();
						final DefaultTreeModel treeModel = new DefaultTreeModel(treeNode);
						tree.setModel(treeModel);
						for (int i = 0; i < tree.getRowCount(); i++) {
							tree.expandRow(i);
						}
					} catch (final WorkFlowTreeDrawingFailedException e) {
						e.printStackTrace();
					}
					comboBoxController("", "", 1);
				}
			}

		} else {
			JOptionPane.showMessageDialog(null, "Please Select a Node from Tree Diagram");
		}
	}

	/**
	 * Value changed.
	 *
	 * @param e
	 *            the e
	 */
	@Override
	public void valueChanged(TreeSelectionEvent e) {
		try {
			btnDelete.setEnabled(true);
			final TreePath currentSelection = tree.getSelectionPath();
			final Object selectionArr[] = currentSelection.getPath();
			selectedValuesFromJtree = getSelectedValueFomTree(selectionArr);
			selectedItemfromJtree = currentSelection.getLastPathComponent().toString();
			System.out.println(Arrays.toString(selectedValuesFromJtree));

		} catch (final Exception exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * Gets the selected value fom tree.
	 *
	 * @param selectionArr
	 *            the selection arr
	 * @return the selected value fom tree
	 */
	private String[] getSelectedValueFomTree(Object[] selectionArr) {

		final String[] selectedValues = new String[selectionArr.length - 1];

		for (int index = 0; index < (selectionArr.length - 1); index++) {
			selectedValues[index] = selectionArr[index + 1].toString();
		}

		return selectedValues;
	}

	/**
	 * Combo box controller.
	 *
	 * @param parentTagName
	 *            the parent tag name
	 * @param workFlowTagName
	 *            the work flow tag name
	 * @param origin
	 *            the origin
	 */
	public void comboBoxController(String parentTagName, String workFlowTagName, int origin) {
		try {
			switch (origin) {
			case 1:
				System.out.println("come heee " + workFlowTagName);

				try {
					final ArrayList<String> list = workFlowService.loadTagNamesController("", workFlowTagName, 1);
					populateComboBox(list, workflowComboBox);
					System.out.println("come wwwwwwwww " + list.size());
				} catch (final Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				break;

			case 2:
				System.out.println("come heee 22222" + workFlowTagName);
				try {
					final ArrayList<String> list = workFlowService.loadTagNamesController("", workFlowTagName, 2);
					populateComboBox(list, parentComboBox);
					System.out.println("come wwwwwwwww " + list.size());
				} catch (final Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//

				break;

			case 3:
				System.out.println("come heee 333" + workFlowTagName);
				try {
					final ArrayList<String> list = workFlowService.loadTagNamesController(parentTagName,
							workFlowTagName, 3);
					populateComboBox(list, childTagcomboBox_1);
					System.out.println("come wwwwwwwww " + list.size());
				} catch (final Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//

			}
		} catch (final Exception e) {

			// e.printStackTrace();
		}

	}

	/**
	 * Populate combo box.
	 *
	 * @param comboBoxValues
	 *            the combo box values
	 * @param jComboBox
	 *            the j combo box
	 */
	private void populateComboBox(ArrayList<String> comboBoxValues, JComboBox jComboBox) {
		try {

			jComboBox.removeAllItems();

			for (final String value : comboBoxValues) {
				jComboBox.addItem(value);

			}

			jComboBox.setSelectedIndex(0);
			jComboBox.addItemListener(this);
		} catch (final Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Reset parent panel.
	 */
	private void resetParentPanel() {
		parentTagNewradioButton.setSelected(true);
		parentTextField.setEnabled(true);
		parentComboBox.setEnabled(false);
	}

	/**
	 * Reset child panel.
	 */
	private void resetChildPanel() {
		rdbtnNewChildTag.setSelected(true);
		chileTagTextField.setEnabled(true);
		childTagcomboBox_1.setEnabled(false);
	}

	/**
	 * Import saved work flow.
	 *
	 * @param file
	 *            the file
	 */
	private void importSavedWorkFlow(File file) {

		try {

			dataManagerObject = workFlowService.deSerializeWorkFlowDiagram(file);
			if (dataManagerObject != null) {

				final DefaultMutableTreeNode treeNode = workFlowService.createWorkFlowTree();
				final DefaultTreeModel treeModel = new DefaultTreeModel(treeNode);
				tree.setModel(treeModel);
				for (int i = 0; i < tree.getRowCount(); i++) {
					tree.expandRow(i);
				}

				comboBoxController("", "", 1);

			}
		} catch (final StreamCorruptedException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "File Courrupted or not a vaild file format to Import .");

		} catch (final ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (final WorkFlowTreeDrawingFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Open dialog box for import file.
	 */
	private void openDialogBoxForImportFile() {

		final JFileChooser fileDialog = new JFileChooser();
		final FileNameExtensionFilter filter = new FileNameExtensionFilter("odm file", "odm", "odm");
		fileDialog.setFileFilter(filter);
		final int returnVal = fileDialog.showOpenDialog(contentPane);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			final java.io.File file = fileDialog.getSelectedFile();
			importSavedWorkFlow(file);

		}

	}

	/**
	 * Open dialog box for save file.
	 */
	private void openDialogBoxForSaveFile() {
		try {
			final JFileChooser fileDialog = new JFileChooser();
			final int returnVal = fileDialog.showSaveDialog(contentPane);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				final java.io.File file = fileDialog.getSelectedFile();
				final String fileToBeSaved = file.toString() + ".odm";
				workFlowService.serializeWorkFlowDiagram(new File(fileToBeSaved).getName(), new File(fileToBeSaved));

				System.out.println("sdcfsd" + file.getAbsolutePath());
			} else {

			}
		} catch (final IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Import workflow if exists.
	 *
	 * @param file
	 *            the file
	 */
	private void importWorkflowIfExists(File file) {
		if (file != null) {
			importSavedWorkFlow(file);
		}
	}

	/**
	 * Save workflow diagram.
	 */
	private void saveWorkflowDiagram() {
		if (dataManagerObject.getFileLocation() == null) {

			openDialogBoxForSaveFile();
		} else {
			try {

				workFlowService.serializeWorkFlowDiagram(dataManagerObject.getFileLocation().getName(),
						dataManagerObject.getFileLocation());
			} catch (final Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Exit program.
	 */
	private void exitProgram() {
		if (dataManagerObject.isSaved()) {
			contentPane.setVisible(false);
			new Welcome(reportMakerToolService, workFlowService);
		} else {
			final int dialogResult = JOptionPane.showConfirmDialog(null, WorkFlowConstants.EXIT_CONFORMATOIN_TXT,
					WorkFlowConstants.EXIT_CONFORMATOIN_HEADER, JOptionPane.YES_NO_CANCEL_OPTION);
			if (dialogResult == JOptionPane.YES_OPTION) {
				saveWorkflowDiagram();
				contentPane.setVisible(false);
				new Welcome(reportMakerToolService, workFlowService);
			}
			if (dialogResult == JOptionPane.NO_OPTION) {
				contentPane.setVisible(false);
				new Welcome(reportMakerToolService, workFlowService);
			}
		}
	}

	/**
	 * Restart program.
	 */
	private void restartProgram() {
		if (dataManagerObject.isSaved()) {
			contentPane.setVisible(false);
			workFlowService.createNewWorkFlowObject();
			new WorkflowDialogUI(reportMakerToolService, workFlowService);
		} else {
			final int dialogResult = JOptionPane.showConfirmDialog(null, WorkFlowConstants.EXIT_CONFORMATOIN_TXT,
					WorkFlowConstants.EXIT_CONFORMATOIN_HEADER, JOptionPane.YES_NO_CANCEL_OPTION);
			if (dialogResult == JOptionPane.YES_OPTION) {
				saveWorkflowDiagram();
				contentPane.setVisible(false);
				workFlowService.createNewWorkFlowObject();
				new WorkflowDialogUI(reportMakerToolService, workFlowService);
			}
			if (dialogResult == JOptionPane.NO_OPTION) {
				contentPane.setVisible(false);
				workFlowService.createNewWorkFlowObject();
				new WorkflowDialogUI(reportMakerToolService, workFlowService);
			}
		}
	}
}
