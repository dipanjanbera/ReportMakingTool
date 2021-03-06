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
import java.awt.Color;
import java.awt.Dialog.ModalityType;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import com.tool.reportmaker.exception.ReportMakerException;
import com.tool.reportmaker.exception.TextNotCorrectFormatException;
import com.tool.reportmaker.exception.WorkFlowTreeDrawingFailedException;
import com.tool.reportmaker.interfaces.AppConstants;
import com.tool.reportmaker.interfaces.WorkFlowConstants;
import com.tool.reportmaker.object.DataManagerObject;
import com.tool.reportmaker.service.ReportMakerToolService;
import com.tool.reportmaker.service.WorkFlowManagerService;
import com.tool.reportmaker.util.Util;

// TODO: Auto-generated Javadoc
/**
 * The Class ReportMakerUI.
 */
public class ReportMakerUI extends JFrame implements ActionListener, ItemListener, TreeSelectionListener {

	/** The br. */
	static BufferedReader br;

	/** The frame. */
	private JFrame frame;

	/** The coloum no. */
	private JComboBox coloumNo;

	/** The status text. */
	private JTextArea statusText;

	// private DataManagerObject dataManagerObject ;

	/** The break point reset. */
	private JButton clear, generate, recalculate, breakpointNext, breakpointPrevious, breakPointReset;

	/** The splitted output. */
	private TextArea outputText, inputText, splittedOutput;

	/** The output valuesfor dialog. */
	private JTextArea showWorkflowValue, outputValuesforDialog;
	/** The key stroke to open. */
	private KeyStroke keyStrokeToOpen;

	/** The scroll pane. */
	JScrollPane scr, scrollPane;

	/** The lbl new label_3. */
	JLabel total, lblNewLabel_4, lblSplittedOutput, lblNewLabel_3;

	/** The breakpoint chekbox. */
	JCheckBox breakpointChekbox;

	/** The data importmntm. */
	JMenuItem mntmClearText, mntmHelp, mntmChangeLog, mntmAbout, mntmGenerate, mntmOpenWorkFlowDiagram, dataImportmntm,
			keyboardShortcutMenuItem, dataGenerateImportmntm;

	/** The breakpoint no. */
	JTextField breakpointNo;

	/** The pointer position. */
	int POINTER_POSITION = 0;

	/** The break point next pressed. */
	boolean breakPointNextPressed = false;

	/** The break point previous pressed. */
	boolean breakPointPreviousPressed = false;

	/** The util. */
	Util util = new Util();

	/** The matrics. */
	private ArrayList<String> matrics = null;

	/** The report maker tool service. */
	ReportMakerToolService reportMakerToolService = null;

	/** The work flow service. */
	WorkFlowManagerService workFlowService = null;

	/** The data manager object. */
	DataManagerObject dataManagerObject = null;

	/** The btn. */
	JButton btn;

	/**
	 * Gets the text from text area.
	 *
	 * @return the text from text area
	 */
	boolean flagToCheckIfTextParseCorrectly;

	/** The tree. */
	private JTree tree;

	/** The delete button. */
	private JButton importButton, deleteButton;

	/** The rdbtn append radio button. */
	private JRadioButton rdbtnNewRadioButton, rdbtnAppendRadioButton;

	/** The notificaton. */
	JLabel notificaton;

	/** The dialog. */
	JDialog dialog;

	/** The imported file. */
	private File importedFile;

	/** The selected values from jtree. */
	String[] selectedValuesFromJtree = null;

	/** The selected itemfrom jtree. */
	String selectedItemfromJtree = null;

	/**
	 * Instantiates a new report maker ui.
	 */
	public ReportMakerUI() {

	}

	/**
	 * Instantiates a new report maker ui.
	 *
	 * @param name
	 *            the name
	 * @param reportMakerToolService
	 *            the report maker tool service
	 * @param workFlowManagerService
	 *            the work flow manager service
	 */
	public ReportMakerUI(String name, ReportMakerToolService reportMakerToolService,
			WorkFlowManagerService workFlowManagerService) {
		super();
		this.reportMakerToolService = reportMakerToolService;
		workFlowService = workFlowManagerService;
		dataManagerObject = workFlowManagerService.getDataManagerObject();

		initializeGUI("");
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btn) {
			dispose();
			new Welcome(reportMakerToolService, workFlowService);

		}

		if (e.getSource() == generate) {
			try {

				onPasteFromClipboard();
				getTextFromTextArea();
				resetBreakPoint();

			} catch (final IOException e1) {

				e1.printStackTrace();
			}
		}
		if (e.getSource() == clear) {
			clearTextField();
			resetBreakPoint();

			// JOptionPane.showMessageDialog(null,
			// AppConstants.DialogBoxVerbage.errorStatusForInvalidInput);
		}
		if (e.getSource() == mntmClearText) {
			clearTextField();
			resetBreakPoint();

		}
		if (e.getSource() == mntmGenerate) {
			try {
				onPasteFromClipboard();
				getTextFromTextArea();
				resetBreakPoint();

			} catch (final IOException e1) {

				e1.printStackTrace();
			}
		}

		if (e.getSource() == mntmOpenWorkFlowDiagram) {
			openDialogBoxForImportFile();
		}

		if (e.getSource() == dataImportmntm) {
			if (!outputText.getText().isEmpty()) {
				openDataImportDialogController();
			} else {
				JOptionPane.showMessageDialog(null,
						WorkFlowConstants.DataImportDialogBoxConstants.DATA_IMPORT_DIALOG_BOX_OPEN_ERROR_MSG);
			}
		}

		if (e.getSource() == recalculate) {
			try {
				getTextFromTextArea();
				resetBreakPoint();

				getContentForWorkflowImportDialogBox();
			} catch (final IOException e1) {

				e1.printStackTrace();
			}
		}

		if (e.getSource() == breakpointNext) {
			breakPointNextButtonClickAction();
		}

		if (e.getSource() == breakpointPrevious) {
			breakPointPreviousButtonClickAction();
		}

		if (e.getSource() == breakPointReset) {
			resetBreakPoint();
		}

		if (e.getSource() == mntmAbout) {
			new DialogBoxUI(new JFrame(), "About", "Developed By Dipanjan Bera ");
		}

		if (e.getSource() == keyboardShortcutMenuItem) {
			Util.showKeyboardShortcut();
		}

		if (e.getSource() == dataGenerateImportmntm) {
			try {
				onPasteFromClipboard();
				getTextFromTextArea();
				resetBreakPoint();
				System.out.println(flagToCheckIfTextParseCorrectly);
				if (flagToCheckIfTextParseCorrectly) {
					if (!outputText.getText().isEmpty()) {
						openDataImportDialogController();
					} else {
						JOptionPane.showMessageDialog(null,
								WorkFlowConstants.DataImportDialogBoxConstants.DATA_IMPORT_DIALOG_BOX_OPEN_ERROR_MSG);
					}
				}

			} catch (final IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

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
		lblSplittedOutput.setForeground(Color.GRAY);
		lblNewLabel_4.setForeground(Color.GRAY);
		resetBreakPoint();
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
		lblSplittedOutput.setForeground(Color.BLACK);
		lblNewLabel_4.setForeground(Color.BLACK);
		resetBreakPoint();
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

			final int end = (start + Integer.parseInt(breakpointNo.getText())) - 1;

			try {
				final ArrayList<String> splittedValue = reportMakerToolService
						.fetchValueFromOutput(reportMakerToolService.getMatrics(), start, end);
				POINTER_POSITION = end + 1;
				breakPointNextPressed = true;
				util.copyToClipboard(splittedValue);
				showSplittedValue(splittedValue);

			} catch (final ReportMakerException e1) {

				JOptionPane.showMessageDialog(this, e1.getMessage());

			} catch (final IOException e1) {

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
				end = POINTER_POSITION - 1 - Integer.parseInt(breakpointNo.getText());
				breakPointNextPressed = false;

			} else {
				end = POINTER_POSITION - 1;
			}

			final int start = (end - Integer.parseInt(breakpointNo.getText())) + 1;

			try {
				final ArrayList<String> splittedValue = reportMakerToolService
						.fetchValueFromOutput(reportMakerToolService.getMatrics(), start, end);
				POINTER_POSITION = start;
				breakPointPreviousPressed = true;
				util.copyToClipboard(splittedValue);
				showSplittedValue(splittedValue);

			} catch (final ReportMakerException e1) {

				JOptionPane.showMessageDialog(this, e1.getMessage());
			} catch (final IOException e1) {

				e1.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(this, "Please Enter Break Point Value");
		}
	}

	/**
	 * Check if number.
	 *
	 * @param arrList
	 *            the arr list
	 * @return true, if successful
	 */
	private boolean checkIfNumber(ArrayList<String> arrList) {
		boolean flag = true;
		int count = 0;
		try {
			final String value = arrList.get(1);
			count = count + Integer.parseInt(value.replace(",", ""));
		} catch (final Exception exception) {
			flag = false;
		}
		return flag;
	}

	/**
	 * Clear text field.
	 */
	private void clearTextField() {
		final int con = JOptionPane.showConfirmDialog(this, AppConstants.DialogBoxVerbage.clearTextConfirm);
		if (con == JOptionPane.YES_OPTION) {
			inputText.setText("");
			outputText.setText("");
			statusText.setText("Cleared Input !! ");
			total.setText(AppConstants.INITIAL_TEXT_ON_FOOTER);
		}
	}

	/**
	 * Draw jtree diagram.
	 */
	private void drawJtreeDiagram() {
		if (dataManagerObject.getDataManagerObjectName() != null) {
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

	}

	/**
	 * Gets the content for workflow import dialog box.
	 *
	 * @return the content for workflow import dialog box
	 */
	private ArrayList<String> getContentForWorkflowImportDialogBox() {

		ArrayList<String> arrList = null;
		final String s[] = util.onPasteFromClipboard().split("\\n");

		arrList = new ArrayList<String>(Arrays.asList(s));

		if (arrList.size() > 2) {
			return arrList;
		}
		return arrList;

	}

	/**
	 * Gets the matrics.
	 *
	 * @return the matrics
	 */
	public ArrayList<String> getMatrics() {
		return matrics;
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
	 * Gets the text from text area.
	 *
	 * @return the text from text area
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void getTextFromTextArea() throws IOException {

		if (validateInput()) {
			statusText.setText(AppConstants.DialogBoxVerbage.errorStatus);
			final String s[] = inputText.getText().split("\\n");

			final int coloum = Integer.parseInt("" + coloumNo.getSelectedItem());
			final ArrayList<String> arrList = new ArrayList<String>(Arrays.asList(s));

			textParse(arrList, coloum);

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
			if (dataManagerObject.getDataManagerObjectName() != null) {
				JOptionPane.showMessageDialog(this, "Workflow Imported Successfully");
			}

		} catch (final ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Initialize gui.
	 *
	 * @param q
	 *            the q
	 */
	private void initializeGUI(String q) {
		frame = new JFrame();
		frame.setTitle("");
		frame.setBounds(100, 100, 1137, 676);
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {

				frame.setVisible(false);
				new Welcome(reportMakerToolService, workFlowService);

			}
		});

		frame.getContentPane().setLayout(null);

		inputText = new TextArea();
		inputText.setBounds(10, 27, 555, 547);
		frame.getContentPane().add(inputText);

		final JLabel lblNewLabel = new JLabel("Enter Text");
		lblNewLabel.setBounds(10, 11, 76, 14);
		frame.getContentPane().add(lblNewLabel);

		generate = new JButton("Generate");
		generate.addActionListener(this);
		generate.setBounds(571, 95, 180, 23);
		frame.getContentPane().add(generate);
		// generate.addActionListener(this);

		coloumNo = new JComboBox();
		coloumNo.setBounds(571, 52, 180, 20);
		frame.getContentPane().add(coloumNo);
		coloumNo.addItem("2");
		coloumNo.addItem("3");
		coloumNo.addItem("4");
		coloumNo.addItem("5");
		// coloumNo.setSelectedIndex(1);
		coloumNo.addItemListener(this);

		final JLabel lblNewLabel_1 = new JLabel("Column No");
		lblNewLabel_1.setBounds(571, 27, 68, 14);
		frame.getContentPane().add(lblNewLabel_1);

		statusText = new JTextArea();
		statusText.setEditable(false);
		statusText.setBounds(571, 516, 180, 58);
		frame.getContentPane().add(statusText);
		statusText.setColumns(10);

		final JLabel lblNewLabel_2 = new JLabel("Status");
		lblNewLabel_2.setBounds(571, 491, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);

		outputText = new TextArea();
		outputText.setBounds(757, 27, 169, 547);
		frame.getContentPane().add(outputText);

		final JLabel lblOutput = new JLabel("Output");
		lblOutput.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOutput.setVerticalAlignment(SwingConstants.BOTTOM);
		lblOutput.setBounds(880, 11, 46, 14);
		frame.getContentPane().add(lblOutput);

		clear = new JButton("Clear");
		clear.setBounds(571, 189, 180, 23);
		frame.getContentPane().add(clear);
		clear.addActionListener(this);

		total = new JLabel("After coping Omniture data click on Generate button");
		total.setFont(new Font("Tahoma", Font.BOLD, 12));
		total.setBounds(10, 592, 449, 14);
		frame.getContentPane().add(total);

		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(777, 593, 334, 14);
		frame.getContentPane().add(lblNewLabel_3);

		recalculate = new JButton("Recalculate");
		recalculate.setBounds(571, 143, 180, 23);
		frame.getContentPane().add(recalculate);
		recalculate.addActionListener(this);

		final JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Break Point", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(571, 223, 180, 257);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		final JPanel panel = new JPanel();
		panel.setBounds(10, 26, 160, 219);
		panel_1.add(panel);
		panel.setLayout(null);

		breakpointChekbox = new JCheckBox("Break Point Selection");
		breakpointChekbox.setBounds(0, 0, 154, 23);
		panel.add(breakpointChekbox);
		breakpointChekbox.addItemListener(this);

		breakpointNo = new JTextField();
		breakpointNo.setBounds(8, 55, 146, 20);
		panel.add(breakpointNo);
		breakpointNo.setColumns(10);

		lblNewLabel_4 = new JLabel("Break Point No");
		lblNewLabel_4.setBounds(5, 30, 86, 14);
		panel.add(lblNewLabel_4);

		breakpointNext = new JButton("Next >");
		breakpointNext.addActionListener(this);
		breakpointNext.setBounds(4, 101, 150, 23);
		panel.add(breakpointNext);

		breakpointPrevious = new JButton("< Previous");
		breakpointPrevious.addActionListener(this);
		breakpointPrevious.setBounds(4, 135, 150, 23);
		panel.add(breakpointPrevious);

		breakPointReset = new JButton("Reset");
		breakPointReset.setBounds(4, 183, 150, 23);
		panel.add(breakPointReset);
		breakPointReset.addActionListener(this);

		splittedOutput = new TextArea();
		splittedOutput.setBounds(942, 27, 169, 547);
		frame.getContentPane().add(splittedOutput);

		lblSplittedOutput = new JLabel("Splitted Output");
		lblSplittedOutput.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSplittedOutput.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSplittedOutput.setBounds(996, 11, 115, 14);
		frame.getContentPane().add(lblSplittedOutput);

		final JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		frame.setJMenuBar(menuBar);

		final JMenu generateMenuItem = new JMenu("File");
		menuBar.add(generateMenuItem);

		mntmOpenWorkFlowDiagram = new JMenuItem("Import WorkFlow");
		generateMenuItem.add(mntmOpenWorkFlowDiagram);
		mntmOpenWorkFlowDiagram.addActionListener(this);
		mntmOpenWorkFlowDiagram.setMnemonic(KeyEvent.VK_O);
		keyStrokeToOpen = KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK);
		mntmOpenWorkFlowDiagram.setAccelerator(keyStrokeToOpen);

		mntmGenerate = new JMenuItem("Generate");
		generateMenuItem.add(mntmGenerate);
		mntmGenerate.addActionListener(this);
		mntmGenerate.setMnemonic(KeyEvent.VK_G);
		keyStrokeToOpen = KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_DOWN_MASK);
		mntmGenerate.setAccelerator(keyStrokeToOpen);

		mntmClearText = new JMenuItem("Clear Text");
		generateMenuItem.add(mntmClearText);
		mntmClearText.addActionListener(this);
		mntmClearText.setMnemonic(KeyEvent.VK_C);
		keyStrokeToOpen = KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK);
		mntmClearText.setAccelerator(keyStrokeToOpen);

		final JMenu dataImport = new JMenu("Import");
		menuBar.add(dataImport);

		dataImportmntm = new JMenuItem("Import Data");
		dataImport.add(dataImportmntm);
		dataImportmntm.addActionListener(this);
		dataImportmntm.setMnemonic(KeyEvent.VK_I);
		keyStrokeToOpen = KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK);
		dataImportmntm.setAccelerator(keyStrokeToOpen);

		dataGenerateImportmntm = new JMenuItem("Generate & Import");
		dataImport.add(dataGenerateImportmntm);
		dataGenerateImportmntm.addActionListener(this);
		dataGenerateImportmntm.setMnemonic(KeyEvent.VK_F);
		keyStrokeToOpen = KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_DOWN_MASK);
		dataGenerateImportmntm.setAccelerator(keyStrokeToOpen);

		final JMenu about = new JMenu("About");
		menuBar.add(about);

		mntmHelp = new JMenuItem("Help");
		about.add(mntmHelp);

		mntmChangeLog = new JMenuItem("Change Log");
		about.add(mntmChangeLog);

		mntmAbout = new JMenuItem("About");
		about.add(mntmAbout);
		mntmAbout.addActionListener(this);

		final JMenu keyboardShortcut = new JMenu("Keyboard Shortcut");
		menuBar.add(keyboardShortcut);

		keyboardShortcutMenuItem = new JMenuItem("Keyboard Shortcut List");
		keyboardShortcut.add(keyboardShortcutMenuItem);
		keyboardShortcutMenuItem.addActionListener(this);

		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);

		setDefaultValue();

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == coloumNo) {
			try {
				recalculateValue();
			} catch (final IOException e1) {

				e1.printStackTrace();
			}
		}

		if (e.getSource() == breakpointChekbox) {
			if (breakpointChekbox.isSelected()) {
				breakPointEnabled();
			}
		}
		if (!breakpointChekbox.isSelected()) {
			breakPointDisabled();
		}
	}

	/**
	 * On paste from clipboard.
	 */
	private void onPasteFromClipboard() {
		final Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
		final Transferable t = c.getContents(null);
		if (t == null) {
			return;
		}
		try {
			inputText.setText((String) t.getTransferData(DataFlavor.stringFlavor));
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open data import dialog controller.
	 */
	private void openDataImportDialogController() {
		if (dataManagerObject.getDataManagerObjectName() != null) {
			openDialogBoxForDataImportToWorkflow();
		} else {
			JOptionPane.showMessageDialog(null,
					WorkFlowConstants.DataImportDialogBoxConstants.NO_WORKFLOW_IMPORTED_ERROR);
		}

	}

	/**
	 * Open dialog box for data import to workflow.
	 */
	private void openDialogBoxForDataImportToWorkflow() {

		dialog = new JDialog();
		dialog.setTitle(AppConstants.DialogBoxHeader.IMPORT_DATA);
		dialog.setModal(true);
		dialog.setAlwaysOnTop(true);
		dialog.setModalityType(ModalityType.APPLICATION_MODAL);
		dialog.setBounds(100, 100, 659, 502);
		getContentPane().setLayout(new BorderLayout());

		dialog.setLayout(null);

		final JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "WorkFlow Design", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(16, 11, 336, 406);
		dialog.add(panel);
		panel.setLayout(null);

		final JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 22, 189, 373);
		panel.add(scrollPane_2);

		tree = new JTree();
		scrollPane_2.setViewportView(tree);
		tree.addTreeSelectionListener(this);
		tree.setShowsRootHandles(true);
		tree.setRootVisible(true);
		tree.setVisibleRowCount(200);
		tree.setAutoscrolls(true);
		tree.setModel(null);

		final JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(209, 22, 117, 373);
		panel.add(scrollPane_1);

		showWorkflowValue = new JTextArea();
		scrollPane_1.setViewportView(showWorkflowValue);

		deleteButton = new JButton("Delete");
		deleteButton.setBounds(362, 191, 116, 53);
		dialog.add(deleteButton);
		deleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (!tree.isSelectionEmpty()) {
						final int dialogResult = JOptionPane.showConfirmDialog(dialog,
								WorkFlowConstants.DataImportDialogBoxConstants.deleteConfirmConstants.CONFIRM_TEXT,
								WorkFlowConstants.DataImportDialogBoxConstants.deleteConfirmConstants.CONFIRM_BOX_TITLE,
								JOptionPane.YES_NO_OPTION);
						if (dialogResult == JOptionPane.YES_OPTION) {
							if (workFlowService.deleteValuesFromChildNode(selectedValuesFromJtree,
									ReportMakerUI.this.getContentForWorkflowImportDialogBox(), importedFile)) {
								ReportMakerUI.this.showOutputForImportDialogBox(
										workFlowService.fetchValuesFromChildNode(selectedValuesFromJtree),
										showWorkflowValue);
								notificaton.setText(
										WorkFlowConstants.DataImportDialogBoxConstants.DATA_DELETE_SUCCESSFULL);
								notificaton.setForeground(Color.black);
							}
						}

					} else {
						notificaton
								.setText(WorkFlowConstants.DataImportDialogBoxConstants.CHILD_NODE_NOT_SELECTED_ERROR);
						notificaton.setForeground(Color.RED);
					}
				} catch (final IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		importButton = new JButton("<-Import");
		importButton.setBounds(362, 115, 116, 53);
		dialog.add(importButton);
		importButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (!tree.isSelectionEmpty()) {

						if (selectedValuesFromJtree.length == 3) {
							if (rdbtnNewRadioButton.isSelected()) {
								workFlowService.insertDataIntoChildNode(selectedValuesFromJtree,
										ReportMakerUI.this.getContentForWorkflowImportDialogBox(), importedFile);
							} else {
								workFlowService.appendDataIntoChildNode(selectedValuesFromJtree,
										ReportMakerUI.this.getContentForWorkflowImportDialogBox(), importedFile);
							}
							ReportMakerUI.this.showOutputForImportDialogBox(
									workFlowService.fetchValuesFromChildNode(selectedValuesFromJtree),
									showWorkflowValue);

							notificaton.setText(WorkFlowConstants.DataImportDialogBoxConstants.DATA_IMPORT_SUCCESSFUL);
							notificaton.setForeground(Color.black);
						} else {

							notificaton.setText(
									WorkFlowConstants.DataImportDialogBoxConstants.CHILD_NODE_NOT_SELECTED_ERROR);
							notificaton.setForeground(Color.RED);
						}
					} else {
						notificaton
								.setText(WorkFlowConstants.DataImportDialogBoxConstants.CHILD_NODE_NOT_SELECTED_ERROR);
						notificaton.setForeground(Color.RED);
					}
				} catch (final HeadlessException e) {

					e.printStackTrace();
				} catch (final IOException e) {

					e.printStackTrace();
				}

			}
		});

		final JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Output", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(488, 11, 145, 406);
		dialog.add(panel_1);
		panel_1.setLayout(null);

		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 25, 125, 370);
		panel_1.add(scrollPane);

		outputValuesforDialog = new JTextArea();
		scrollPane.setViewportView(outputValuesforDialog);

		showOutputForImportDialogBox(getContentForWorkflowImportDialogBox(), outputValuesforDialog);

		rdbtnNewRadioButton = new JRadioButton("New");
		rdbtnNewRadioButton.setBounds(358, 299, 120, 23);
		dialog.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.addActionListener(this);
		rdbtnNewRadioButton.setSelected(true);

		rdbtnAppendRadioButton = new JRadioButton("Append");
		rdbtnAppendRadioButton.setBounds(358, 325, 109, 23);
		rdbtnAppendRadioButton.addActionListener(this);
		dialog.add(rdbtnAppendRadioButton);

		final JLabel lblImportAs = new JLabel("Import Type");
		lblImportAs.setBounds(362, 281, 69, 14);
		dialog.add(lblImportAs);

		final ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnNewRadioButton);
		buttonGroup.add(rdbtnAppendRadioButton);

		{
			final JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				final JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}

		notificaton = new JLabel("");
		notificaton.setBounds(26, 428, 458, 14);
		dialog.add(notificaton);

		importButton.setEnabled(false);
		deleteButton.setEnabled(false);
		outputValuesforDialog.setEditable(false);
		showWorkflowValue.setEditable(false);

		dialog.setLocationRelativeTo(null);
		dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		drawJtreeDiagram();

		dialog.setVisible(true);

	}

	/**
	 * Open dialog box for import file.
	 */
	private void openDialogBoxForImportFile() {

		final JFileChooser fileDialog = new JFileChooser();
		final FileNameExtensionFilter filter = new FileNameExtensionFilter("odm file", "odm", "odm");
		fileDialog.setFileFilter(filter);
		final int returnVal = fileDialog.showOpenDialog(frame);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			importedFile = fileDialog.getSelectedFile();
			importSavedWorkFlow(importedFile);

			System.out.println(importedFile.getName());
		}

	}

	/**
	 * Put integer into list.
	 *
	 * @param value
	 *            the value
	 */
	void putIntegerIntoList(String value) {

		matrics.add(value);

	}

	/**
	 * Recalculate value.
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private void recalculateValue() throws IOException {
		if (!inputText.getText().equals("")) {
			getTextFromTextArea();
		}
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
			JOptionPane.showMessageDialog(this, "Please Enter Break Point Value");
		}
	}

	/**
	 * Sets the default value.
	 */
	private void setDefaultValue() {
		frame.setTitle(AppConstants.DialogBoxHeader.EXTRACT_DATA);
		lblNewLabel_3.setText(AppConstants.DialogBoxHeader.ABOUT_FOOTER);
		breakpointNo.setText(AppConstants.BREAK_POINT_DEFAULT_VALUE);
		coloumNo.setSelectedIndex(AppConstants.DEFAULT_COLOUM_INDEX);
		total.setText(AppConstants.INITIAL_TEXT_ON_FOOTER);
		breakPointDisabled();

	}

	/**
	 * Sets the matrics.
	 *
	 * @param matrics
	 *            the new matrics
	 */
	public void setMatrics(ArrayList<String> matrics) {
		this.matrics = matrics;
	}

	/**
	 * Show output.
	 *
	 * @param arrList
	 *            the arr list
	 * @param time
	 *            the time
	 */
	private void showOutput(ArrayList<String> arrList, Long time) {
		final String newLine = "\n";
		String text = "";
		int count = 0;
		final boolean flag = checkIfNumber(arrList);
		for (String value : arrList) {
			if (flag) {
				if (value.indexOf(",") > -1) {
					value = value.replace(",", "");
				}
				count = count + Integer.parseInt(value);
				text += value + newLine;
			} else {
				text += value + newLine;
			}
		}
		final Long endTime = System.currentTimeMillis();

		if (flag) {
			final String totalInfo = "Total : " + count + "\n" + "----------------------\n";
			outputText.setText(totalInfo + text);
			statusText.setText("Successfull !! \nCopied to Clipboard \nPress Ctrl+v to paste");
			total.setText("Total : " + count + "  |   No of Records : " + arrList.size() + " |   Processd in "
					+ (endTime - time) + " ms");
		} else {
			outputText.setText(text);
			statusText.setText("Successfull !! \nCopied to Clipboard");
			total.setText("No of Records : " + arrList.size() + "  |  Processd in " + (endTime - time) + " ms");
		}
	}

	/**
	 * Show output for import dialog box.
	 *
	 * @param valuesToBeDisplayed
	 *            the values to be displayed
	 * @param textArea
	 *            the text area
	 */
	private void showOutputForImportDialogBox(ArrayList<String> valuesToBeDisplayed, JTextArea textArea) {
		final String newLine = "\n";
		String text = "";
		if (valuesToBeDisplayed.size() == 0) {
			deleteButton.setEnabled(false);
		} else {
			deleteButton.setEnabled(true);
		}
		for (final String value : valuesToBeDisplayed) {
			text += value + newLine;
		}

		textArea.setText(text);
	}

	/**
	 * Show splitted value.
	 *
	 * @param arrList
	 *            the arr list
	 */
	public void showSplittedValue(ArrayList<String> arrList) {

		final String newLine = "\n";
		String text = "";
		for (final String value : arrList) {
			text += value + newLine;
		}

		splittedOutput.setText(text);

	}

	/**
	 * Text parse.
	 *
	 * @param arrList
	 *            the arr list
	 * @param coloumNo
	 *            the coloum no
	 */

	public void textParse(ArrayList<String> arrList, int coloumNo) {

		try {
			flagToCheckIfTextParseCorrectly = true;
			final Long startTime = System.currentTimeMillis();
			final ArrayList<String> outputMatrics = reportMakerToolService.textParse(arrList, coloumNo);
			util.copyToClipboard(outputMatrics);
			showOutput(outputMatrics, startTime);
			recalculate.setEnabled(true);

		} catch (final TextNotCorrectFormatException e) {

			e.printStackTrace();
			flagToCheckIfTextParseCorrectly = false;
			inputText.setText("");
			outputText.setText("");
			statusText.setText("");
			total.setForeground(Color.RED);
			total.setText("ERROR !! Input Text is not in Correct Format");
			JOptionPane.showMessageDialog(null, AppConstants.DialogBoxVerbage.errorStatusForInvalidInput);
			total.setForeground(Color.BLACK);
			total.setText(AppConstants.INITIAL_TEXT_ON_FOOTER);
		} catch (final IOException e) {

			e.printStackTrace();
		}

	}

	/**
	 * Validate input.
	 *
	 * @return true, if successful
	 */
	private boolean validateInput() {
		boolean flag = true;
		if (coloumNo.getSelectedItem().toString().equals("")) {
			statusText.setText(AppConstants.DialogBoxVerbage.errorStatusNoColoumNo);
			JOptionPane.showMessageDialog(this, "Please Enter Coloum No");

			flag = false;
		} else if (inputText.getText().equals("")) {
			statusText.setText(AppConstants.DialogBoxVerbage.errorStatusForEmptyInput);
			JOptionPane.showMessageDialog(this, "Please Enter Input Text");

			flag = false;
		} else {
			try {
				Integer.parseInt(coloumNo.getSelectedItem().toString());

				if (Integer.parseInt(coloumNo.getSelectedItem().toString()) == 1) {
					statusText.setText("Error !! \nPlease Enter Valid Coloum No (2-5)");
					JOptionPane.showMessageDialog(this, "Please Enter Valid Coloum No (2-5)");

				}
			} catch (final Exception ex) {
				statusText.setText("Error !! \nPlease Enter Valid Coloum No");
				JOptionPane.showMessageDialog(this, "Please Enter Valid Coloum No");

				flag = false;
			}
		}

		return flag;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * javax.swing.event.TreeSelectionListener#valueChanged(javax.swing.event.
	 * TreeSelectionEvent)
	 */
	@Override
	public void valueChanged(TreeSelectionEvent e) {
		try {

			final TreePath currentSelection = tree.getSelectionPath();
			final Object selectionArr[] = currentSelection.getPath();
			selectedValuesFromJtree = getSelectedValueFomTree(selectionArr);
			selectedItemfromJtree = currentSelection.getLastPathComponent().toString();
			if (selectedValuesFromJtree.length == 3) {
				importButton.setEnabled(true);
				deleteButton.setEnabled(true);
				showOutputForImportDialogBox(workFlowService.fetchValuesFromChildNode(selectedValuesFromJtree),
						showWorkflowValue);

			} else {
				importButton.setEnabled(false);
				deleteButton.setEnabled(false);
			}
			System.out.println(Arrays.toString(selectedValuesFromJtree));

		} catch (final Exception exception) {
			exception.printStackTrace();
		}
	}

}