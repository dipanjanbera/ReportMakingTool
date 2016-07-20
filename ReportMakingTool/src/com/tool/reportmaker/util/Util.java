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
package com.tool.reportmaker.util;

import java.awt.BorderLayout;
import java.awt.Dialog.ModalityType;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
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
import javax.swing.WindowConstants;
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
	public void writeIntoFile(String fileName, ArrayList<String> matices) throws IOException {

		final File file = new File(fileName);

		if (!file.exists()) {
			file.createNewFile();
		}

		final FileWriter fw = new FileWriter(file.getAbsoluteFile());
		final BufferedWriter bw = new BufferedWriter(fw);
		for (final String value : matices) {
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
		final ProcessBuilder pb = new ProcessBuilder("Notepad.exe", "output.txt");
		pb.start();
	}

	/**
	 * Copy to clipboard.
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void copyToClipboard() throws IOException {
		final File file1 = new File("output.txt");
		final FileInputStream fis = new FileInputStream(file1);
		final byte[] data = new byte[(int) file1.length()];
		fis.read(data);
		fis.close();

		final String str = new String(data, "UTF-8");

		final Toolkit toolkit = Toolkit.getDefaultToolkit();
		final Clipboard clipboard = toolkit.getSystemClipboard();
		final StringSelection strSel = new StringSelection(str);
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
		final String newLine = "\n";
		String text = "";
		for (final String value : arrList) {

			text += value + newLine;

		}

		final Toolkit toolkit = Toolkit.getDefaultToolkit();
		final Clipboard clipboard = toolkit.getSystemClipboard();
		final StringSelection strSel = new StringSelection(text);
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
		final Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
		final Transferable t = c.getContents(null);
		if (t == null) {
			return null;
		}
		try {
			text = (String) t.getTransferData(DataFlavor.stringFlavor);
		} catch (final Exception e) {
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
	public void serializeWorkFlowDiagram(DataManagerObject dataManagerObject, File file) throws IOException {

		final FileOutputStream fout = new FileOutputStream("" + file.getAbsolutePath());
		final ObjectOutputStream oos = new ObjectOutputStream(fout);
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
	public DataManagerObject deserialzeWorkFlowDiagram(File file)
			throws IOException, ClassNotFoundException, StreamCorruptedException {

		DataManagerObject dataManagerObject = null;

		final FileInputStream fin = new FileInputStream("" + file.getAbsolutePath());
		final ObjectInputStream ois = new ObjectInputStream(fin);
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

		for (final ChildNode childNode : arr) {
			final int _size = childNode.getValues().size();

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
	public static Map<String, String> getKeyBoardList() {
		final Map<String, String> keyboardShortcutMap = new HashMap<String, String>();
		keyboardShortcutMap.put("Ctrl+N", "New Workflow");
		keyboardShortcutMap.put("Ctrl+I", "Import Saved Workflow into Stage");
		keyboardShortcutMap.put("Ctrl+S", "Save Workflow");
		keyboardShortcutMap.put("Ctrl+Space", "Add New Node to Workflow");
		keyboardShortcutMap.put("Ctrl+U", "Update Existing Node from Workflow");
		keyboardShortcutMap.put("Ctrl+D", "Delete Existing Node from Workflow");
		keyboardShortcutMap.put("Ctrl+G", "Extract data from HTML Table");
		keyboardShortcutMap.put("Ctrl+C", "Clear All data from Data Extraction Window");
		keyboardShortcutMap.put("Ctrl+K", "Extract data & Open Import Dialog Box  ");
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

		Util.keyBoardShortcutdialog = new JDialog();

		Util.keyBoardShortcutdialog.setTitle(AppConstants.DialogBoxHeader.KEYBOARD_SHORTCUT);
		Util.keyBoardShortcutdialog.setModal(true);
		Util.keyBoardShortcutdialog.setAlwaysOnTop(true);
		Util.keyBoardShortcutdialog.setModalityType(ModalityType.APPLICATION_MODAL);
		Util.keyBoardShortcutdialog.setBounds(100, 100, 550, 300);
		Util.keyBoardShortcutdialog.setLayout(null);

		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 514, 207);
		Util.keyBoardShortcutdialog.add(scrollPane);

		Util.keyBoardShortcuttable = new JTable();
		scrollPane.setViewportView(Util.keyBoardShortcuttable);
		scrollPane.setBounds(10, 11, 514, 241);
		{
			final JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			Util.keyBoardShortcutdialog.add(buttonPane, BorderLayout.SOUTH);
			{
				final JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						Util.keyBoardShortcutdialog.dispose();

					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);

			}

		}
		final DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Keyboard Shortcut");
		model.addColumn("Operation");

		for (final Map.Entry<String, String> map : Util.getKeyBoardList().entrySet()) {
			model.addRow(new Object[] { "" + map.getKey(), "" + map.getValue() });
		}

		Util.keyBoardShortcuttable.setModel(model);

		Util.keyBoardShortcutdialog.setLocationRelativeTo(null);
		Util.keyBoardShortcutdialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		Util.keyBoardShortcutdialog.setVisible(true);
	}

}
