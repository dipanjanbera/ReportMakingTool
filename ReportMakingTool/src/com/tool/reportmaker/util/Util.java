/*
 * ********************************************************
 * OmniKey : A Workflow Driven Smart Data Extraction Tool *
 * ********************************************************
 * 
 * @Package 	:	com.tool.reportmaker.util	
 * @File 	  	: 	Util.java
 * @Created  	: 	07-10-2016(mm-dd-yyyy)
 * @Version		:	2.1.0
 * @Author     	: 	Dipanjan Bera Copyright (2016)
 * @Email		:	dipanjan033@gmail.com
 * 
 */
package com.tool.reportmaker.util;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.Dialog.ModalityType;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.tool.reportmaker.interfaces.AppConstants;
import com.tool.reportmaker.object.ChildNode;
import com.tool.reportmaker.object.DataManagerObject;

// TODO: Auto-generated Javadoc
/**
 * The Class Util.
 */
public class Util {


	/**
	 * Write into file.
	 *
	 * @param fileName
	 *            the file name
	 * @param matices
	 *            the matices
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public  void writeIntoFile(String fileName,ArrayList<String> matices) throws IOException {

		File file = new File(fileName);

	
		if (!file.exists()) {
			file.createNewFile();
		}

		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		for (String value : matices) {
			bw.write(value);
			bw.write("\n");
		}

		bw.close();

		System.out.println("Done");

		
		copyToClipboard();
	}

	/**
	 * Opentxt file to notepad.
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void opentxtFileToNotepad() throws IOException {
		ProcessBuilder pb = new ProcessBuilder("Notepad.exe", "output.txt");
		pb.start();
	}

	/**
	 * Copy to clipboard.
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void copyToClipboard() throws IOException {
		File file1 = new File("output.txt");
		FileInputStream fis = new FileInputStream(file1);
		byte[] data = new byte[(int) file1.length()];
		fis.read(data);
		fis.close();

		String str = new String(data, "UTF-8");

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();
		StringSelection strSel = new StringSelection(str);
		clipboard.setContents(strSel, null);

	}
	
	/**
	 * Copy to clipboard.
	 *
	 * @param arrList
	 *            the arr list
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void copyToClipboard(ArrayList<String> arrList) throws IOException {
		String newLine="\n" , text="";
		for (String value : arrList) {
			
				text+=value+newLine;
			
				
		}
		

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();
		StringSelection strSel = new StringSelection(text);
		clipboard.setContents(strSel, null);

	}
	
	
	/**
	 * On paste from clipboard.
	 *
	 * @return the string
	 */
	@SuppressWarnings("unchecked")
	public String onPasteFromClipboard() {
		String text = null;
		Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
		Transferable t = c.getContents(null);
		if (t == null)
			return null;
		try {
			text= (String) t.getTransferData(DataFlavor.stringFlavor);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return text;
	}


	/**
	 * Serialize work flow diagram.
	 *
	 * @param dataManagerObject
	 *            the data manager object
	 * @param file
	 *            the file
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void serializeWorkFlowDiagram(DataManagerObject dataManagerObject,File file) throws IOException {

		FileOutputStream fout = new FileOutputStream(""+file.getAbsolutePath());
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(dataManagerObject);
		oos.close();
		System.out.println("Done");

	}

	/**
	 * Deserialze work flow diagram.
	 *
	 * @param file
	 *            the file
	 * @return the data manager object
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 * @throws StreamCorruptedException
	 *             the stream corrupted exception
	 */
	public DataManagerObject deserialzeWorkFlowDiagram(File file) throws IOException, ClassNotFoundException , StreamCorruptedException{

		DataManagerObject dataManagerObject = null;

		FileInputStream fin = new FileInputStream("" + file.getAbsolutePath());
		ObjectInputStream ois = new ObjectInputStream(fin);
		dataManagerObject = (DataManagerObject) ois.readObject();
		ois.close();

		return dataManagerObject;

	}
	
	/**
	 * Find maximum array size.
	 *
	 * @param arr
	 *            the arr
	 * @return the int
	 */
	public int findMaximumArraySize(ArrayList<ChildNode> arr) {
		int _biggest_no = 0;

		for (ChildNode childNode : arr) {
			int _size = childNode.getValues().size();
			
			if (_size > _biggest_no) {
				_biggest_no = _size;
			}
		}
		
		return _biggest_no;
	}
	
	/**
	 * Gets the key board list.
	 *
	 * @return the key board list
	 */
	public static Map<String, String> getKeyBoardList(){
		Map<String, String> keyboardShortcutMap = new HashMap<String, String>();
		keyboardShortcutMap.put("Ctrl+I", "Import Saved Workflow into Stage");
		keyboardShortcutMap.put("Ctrl+S", "Save Workflow");
		keyboardShortcutMap.put("Ctrl+Space", "Add New Node to Workflow");
		keyboardShortcutMap.put("Ctrl+U", "Update Existing Node from Workflow");
		keyboardShortcutMap.put("Ctrl+D", "Delete Existing Node from Workflow");
		keyboardShortcutMap.put("Ctrl+G", "Extract data from HTML Table");
		keyboardShortcutMap.put("Ctrl+C", "Clear All data from Data Extraction Window");
		keyboardShortcutMap.put("Ctrl+Q", "Exit Program");
		
		return keyboardShortcutMap;
	}
	
	/** The key board shortcutdialog. */
	private static JDialog keyBoardShortcutdialog = null;
	
	/** The key board shortcuttable. */
	private static JTable keyBoardShortcuttable = null;

	/**
	 * Show keyboard shortcut.
	 */
	public static void showKeyboardShortcut() {

		keyBoardShortcutdialog = new JDialog();

		keyBoardShortcutdialog.setTitle(AppConstants.DialogBoxHeader.KEYBOARD_SHORTCUT);
		keyBoardShortcutdialog.setModal(true);
		keyBoardShortcutdialog.setAlwaysOnTop(true);
		keyBoardShortcutdialog.setModalityType(ModalityType.APPLICATION_MODAL);
		keyBoardShortcutdialog.setBounds(100, 100, 550, 300);
		keyBoardShortcutdialog.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 514, 207);
		keyBoardShortcutdialog.add(scrollPane);

		keyBoardShortcuttable = new JTable();
		scrollPane.setViewportView(keyBoardShortcuttable);
		scrollPane.setBounds(10, 11, 514, 241);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			keyBoardShortcutdialog.add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						keyBoardShortcutdialog.dispose();

					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				
			}

		}
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Keyboard Shortcut");
		model.addColumn("Operation");


		for (Map.Entry<String, String> map : Util.getKeyBoardList().entrySet()) {
			model.addRow(new Object[] { "" + map.getKey(), "" + map.getValue() });
		}

		keyBoardShortcuttable.setModel(model);

		keyBoardShortcutdialog.setLocationRelativeTo(null);
		keyBoardShortcutdialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		keyBoardShortcutdialog.setVisible(true);
	}

}
