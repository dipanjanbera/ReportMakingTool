/*
 * ********************************************************
 * OmniKey : A Workflow Driven Smart Data Extraction Tool *
 * ********************************************************
 * 
 * @Package 	:	com.tool.reportmaker.ui	
 * @File 	  	: 	DataManagerUI.java
 * @Created  	: 	07-10-2016(mm-dd-yyyy)
 * @Version		:	2.1.0
 * @Author     	: 	Dipanjan Bera Copyright (2016)
 * @Email		:	dipanjan033@gmail.com
 * 
 */
package com.tool.reportmaker.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import com.tool.reportmaker.exception.ReportMakerException;
import com.tool.reportmaker.exception.WorkFlowTreeDrawingFailedException;
import com.tool.reportmaker.interfaces.AppConstants;
import com.tool.reportmaker.object.DataManagerObject;
import com.tool.reportmaker.service.ReportMakerToolService;
import com.tool.reportmaker.service.WorkFlowManagerService;
import com.tool.reportmaker.util.Util;

// TODO: Auto-generated Javadoc
/**
 * The Class DataManagerUI.
 */
public class DataManagerUI extends JFrame implements ActionListener,TreeSelectionListener,ItemListener{

	/** The content pane. */
	private JFrame contentPane;
	
	/** The table. */
	private JTable table;
	
	/** The table_1. */
	private JTable table_1;
	
	/** The table_2. */
	private JTable table_2;
	
	/** The breakpoint no. */
	private JTextField breakpointNo;
	
	/** The splitted output. */
	private JTextArea outputText,splittedOutput;
	
	/** The break point reset. */
	private JButton breakpointNext,breakpointPrevious,breakPointReset;
	
	/** The data import. */
	private JMenu dataImport;
	
	/** The data importmntm. */
	private JMenuItem dataImportmntm;
	
	/** The tree. */
	private JTree tree;
	
	/** The breakpoint chekbox. */
	private JCheckBox breakpointChekbox;
	
	/** The break point next pressed. */
	boolean breakPointNextPressed = false;
	
	/** The break point previous pressed. */
	boolean breakPointPreviousPressed = false;
	
	
	/** The pointer position. */
	int POINTER_POSITION = 0;
	
	/** The data manager object. */
	private DataManagerObject dataManagerObject =null;
	
	/** The work flow service. */
	WorkFlowManagerService workFlowService = null;
	
	/** The report maker tool service. */
	ReportMakerToolService reportMakerToolService =null;
	
	/** The tot values. */
	ArrayList<String> totValues = null;
	
	/** The util. */
	Util util = new Util();
	
	/**
	 * Instantiates a new data manager ui.
	 *
	 * @param reportMakerToolService
	 *            the report maker tool service
	 * @param workFlowService
	 *            the work flow service
	 */
	public DataManagerUI(ReportMakerToolService reportMakerToolService,WorkFlowManagerService workFlowService) {
		this.reportMakerToolService = reportMakerToolService;
		this.workFlowService=workFlowService;
		dataManagerObject= this.workFlowService.getDataManagerObject();
		initializeGUI();
		importWorkflowIfExists(dataManagerObject.getFileLocation());
	}
	
	/**
	 * Initialize gui.
	 */
	private void initializeGUI() {
		
		
		contentPane = new JFrame();
		contentPane.setTitle(AppConstants.DialogBoxHeader.DATA_MANAGER);
		contentPane.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane.setBounds(100, 100, 1111, 596);
		contentPane.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		
		contentPane.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
            	
            	contentPane.setVisible(false);
            	new Welcome(reportMakerToolService,workFlowService);
  
            }
        });
		
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1117, 21);
		contentPane.add(menuBar);
		
		dataImport = new JMenu("Import");
		menuBar.add(dataImport);

		dataImportmntm = new JMenuItem("Import Workflow");
		dataImport.add(dataImportmntm);
		dataImportmntm.addActionListener(this);
		dataImportmntm.setMnemonic(KeyEvent.VK_I);
		KeyStroke keyStrokeToOpen1
	    = KeyStroke.getKeyStroke(KeyEvent.VK_I, KeyEvent.CTRL_DOWN_MASK);
		dataImportmntm.setAccelerator(keyStrokeToOpen1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "WorkFlow Design", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 32, 212, 497);
		contentPane.add(panel);
		panel.setLayout(null);
		
		tree = new JTree();
		tree.setBounds(6, 16, 194, 474);
		panel.add(tree);
		tree.addTreeSelectionListener(this);
		tree.setModel(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "WorkFlow Values", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(232, 32, 349, 497);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 333, 465);
		panel_1.add(scrollPane);
		
		table_2 = new JTable();
		scrollPane.setViewportView(table_2);
		table_2.setModel(new DefaultTableModel());
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Output", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(591, 32, 150, 497);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		 
		 JScrollPane scrollPane_1 = new JScrollPane();
		 scrollPane_1.setBounds(6, 16, 138, 470);
		 panel_2.add(scrollPane_1);
		
		 outputText = new JTextArea();
		 scrollPane_1.setViewportView(outputText);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(null, "Break Point", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(751, 154, 180, 247);
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(10, 26, 160, 210);
		panel_3.add(panel_4);
		
		 breakpointChekbox = new JCheckBox("Break Point Selection");
		 breakpointChekbox.setBounds(0, 0, 154, 23);
		panel_4.add(breakpointChekbox);
		breakpointChekbox.addItemListener(this);
		
		breakpointNo = new JTextField();
		breakpointNo.setColumns(10);
		breakpointNo.setText("24");
		breakpointNo.setBounds(8, 55, 146, 20);
		panel_4.add(breakpointNo);
		
		JLabel label = new JLabel("Break Point No");
		label.setBounds(5, 30, 86, 14);
		panel_4.add(label);
		
		breakpointNext = new JButton("Next >");
		breakpointNext.setBounds(4, 101, 150, 23);
		panel_4.add(breakpointNext);
		breakpointNext.addActionListener(this);
		
		breakPointReset = new JButton("Reset");
		breakPointReset.setBounds(4, 183, 150, 23);
		panel_4.add(breakPointReset);
		breakPointReset.addActionListener(this);
		
		breakpointPrevious = new JButton("< Previous");
		breakpointPrevious.setBounds(4, 135, 150, 23);
		panel_4.add(breakpointPrevious);
		breakpointPrevious.addActionListener(this);
		
		 
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new TitledBorder(null, "Splitted Output", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(941, 32, 150, 508);
		contentPane.add(panel_5);
		 
		 JScrollPane scrollPane_2 = new JScrollPane();
		 scrollPane_2.setBounds(6, 16, 138, 481);
		 panel_5.add(scrollPane_2);
		
		 splittedOutput = new JTextArea();
		 scrollPane_2.setViewportView(splittedOutput);		
		 breakPointDisabled();
		 contentPane.setLocationRelativeTo(null);
		 contentPane.setVisible(true);
		 
	}
	

	
	/** The imported file. */
	private File importedFile;

	/**
	 * Open dialog box for import file.
	 */
	private void openDialogBoxForImportFile() {

		final JFileChooser fileDialog = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("odm file", "odm", "odm");
		fileDialog.setFileFilter(filter);
		int returnVal = fileDialog.showOpenDialog(contentPane);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			importedFile = fileDialog.getSelectedFile();
			importSavedWorkFlow(importedFile);

			System.out.println(importedFile.getAbsolutePath());
		}

	}
	
	/**
	 * Import workflow if exists.
	 *
	 * @param file
	 *            the file
	 */
	private void importWorkflowIfExists(File file){
		if(file!=null){
			importSavedWorkFlow(file);
		}
	}

	/** The selected values from jtree. */
	String[] selectedValuesFromJtree = null;
	
	/** The selected itemfrom jtree. */
	String selectedItemfromJtree = null;
	
	/* (non-Javadoc)
	 * @see javax.swing.event.TreeSelectionListener#valueChanged(javax.swing.event.TreeSelectionEvent)
	 */
	@Override
	public void valueChanged(TreeSelectionEvent e) {
		try {
			totValues = new ArrayList<String>();
			String newLine = "\n", text = "";

			TreePath currentSelection = tree.getSelectionPath();
			Object selectionArr[] = currentSelection.getPath();
			selectedValuesFromJtree = getSelectedValueFomTree(selectionArr);
			selectedItemfromJtree = currentSelection.getLastPathComponent().toString();

			DefaultTableModel defaultTableModel = workFlowService.buildJTableController(selectedValuesFromJtree,
					totValues);
			table_2.setModel(defaultTableModel);
			util.copyToClipboard(totValues);
			int count = 0;
			for (String value : totValues) {
				count++;
				text += value + newLine;
			}
			outputText.setText("\n" + text);
			if(count!=0){
			resetBreakPoint();
			}else{
				splittedOutput.setText("");
			}
			System.out.println(defaultTableModel.toString());

		} catch (Exception exception) {
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

		String[] selectedValues = new String[selectionArr.length - 1];

		for (int index = 0; index < (selectionArr.length - 1); index++) {
			selectedValues[index] = selectionArr[index + 1].toString();
		}

		return selectedValues;
	}
	

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == dataImportmntm){
			openDialogBoxForImportFile();
		}
		if (e.getSource() == breakpointNext) {
			if(outputText.equals("")){
				JOptionPane.showMessageDialog(this, "Nothing Found To Display");
			}else{
				breakPointNextButtonClickAction();
			}
			
		}

		if (e.getSource() == breakpointPrevious) {

			if(outputText.equals("")){
				JOptionPane.showMessageDialog(this, "Nothing Found To Display");
			}else{
				breakPointPreviousButtonClickAction();
			}
			
		}

		if (e.getSource() == breakPointReset) {

			resetBreakPoint();
		}
		
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
				
				try {
					DefaultMutableTreeNode treeNode = workFlowService
							.createWorkFlowTree();
					DefaultTreeModel treeModel = new DefaultTreeModel(
							treeNode);
					tree.setModel(treeModel);
					for (int i = 0; i < tree.getRowCount(); i++) {
						tree.expandRow(i);
					}
				} catch (WorkFlowTreeDrawingFailedException e) {
					e.printStackTrace();
				}
				
			}

		}catch (StreamCorruptedException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "File Courrupted or not a vaild file format to Import.");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * Break point next button click action.
	 */
	private void breakPointNextButtonClickAction() {

		System.out.println("------" + breakpointNo.getText().equals(""));
		if (!breakpointNo.getText().equals("")) {
			int start;
			if (breakPointPreviousPressed == true) {
				start = POINTER_POSITION + Integer.parseInt(breakpointNo.getText());
				breakPointPreviousPressed = false;
			} else {
				start = POINTER_POSITION;
			}

			int end = (start + Integer.parseInt(breakpointNo.getText())) - 1;

			try {
				ArrayList<String> splittedValue = reportMakerToolService
						.fetchValueFromOutput(totValues, start, end);
				POINTER_POSITION = end + 1;
				breakPointNextPressed = true;
				util.copyToClipboard(splittedValue);
				showSplittedValue(splittedValue);

			} catch (ReportMakerException e1) {

				JOptionPane.showMessageDialog(this, e1.getMessage());

			} catch (IOException e1) {

				e1.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(this, "Please Enter Break Point Value");
		}

	}

	/**
	 * Break point previous button click action.
	 */
	private void breakPointPreviousButtonClickAction() {
		int end;
		if (!breakpointNo.getText().equals("")) {
			if (breakPointNextPressed == true) {
				end = ((POINTER_POSITION - 1) - Integer.parseInt(breakpointNo.getText()));
				breakPointNextPressed = false;

			} else {
				end = POINTER_POSITION - 1;
			}

			
			
			int start = (end - Integer.parseInt(breakpointNo.getText())) + 1;

			try {
				ArrayList<String> splittedValue = reportMakerToolService
						.fetchValueFromOutput(totValues, start, end);
				POINTER_POSITION = start;
				breakPointPreviousPressed = true;
				util.copyToClipboard(splittedValue);
				showSplittedValue(splittedValue);

			} catch (ReportMakerException e1) {

				JOptionPane.showMessageDialog(this, e1.getMessage());
			} catch (IOException e1) {

				e1.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(this, "Please Enter Break Point Value");
		}
	}
	
	/**
	 * Show splitted value.
	 *
	 * @param arrList
	 *            the arr list
	 */
	public void showSplittedValue(ArrayList<String> arrList) {

		String newLine = "\n", text = "";
		for (String value : arrList) {

			text += value + newLine;
		}

		splittedOutput.setText(text);

	}
	
	/**
	 * Break point enabled.
	 */
	private void breakPointEnabled() {
		splittedOutput.setEnabled(true);
		breakpointNext.setEnabled(true);
		breakpointPrevious.setEnabled(true);
		breakpointNo.setEnabled(true);
		breakPointReset.setEnabled(true);
		resetBreakPoint();
	}

	/**
	 * Break point disabled.
	 */
	private void breakPointDisabled() {
		splittedOutput.setEnabled(false);
		breakpointNext.setEnabled(false);
		breakpointPrevious.setEnabled(false);
		breakpointNo.setEnabled(false);
		breakPointReset.setEnabled(false);
		resetBreakPoint();
		
	}
	
	/**
	 * Reset break point.
	 */
	private void resetBreakPoint() {
		if (!breakpointNo.getText().equals("")) {
			if (!outputText.getText().equals("")) {
				if (breakpointChekbox.isSelected()) {
					POINTER_POSITION = 0;
					breakPointNextPressed = false;
					breakPointPreviousPressed = false;
					breakPointNextButtonClickAction();
				}
			}
		} else {
			JOptionPane.showMessageDialog(this,
					"Please Enter Break Point Value");
		}
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		

		if (e.getSource() == breakpointChekbox) {
			if (breakpointChekbox.isSelected()) {
				breakPointEnabled();

			}
		}
		if (!breakpointChekbox.isSelected()) {
			breakPointDisabled();

		}
	}
}
