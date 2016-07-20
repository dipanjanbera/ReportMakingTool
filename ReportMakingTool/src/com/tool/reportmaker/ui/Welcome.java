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
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import com.tool.reportmaker.interfaces.AppConstants;
import com.tool.reportmaker.service.ReportMakerToolService;
import com.tool.reportmaker.service.WorkFlowManagerService;
import com.tool.reportmaker.util.Util;

// TODO: Auto-generated Javadoc
/**
 * The Class Welcome.
 */
public class Welcome extends JFrame {

	/** The welcome panel. */
	private final JFrame welcomePanel;

	/** The quick tip header. */
	private final JLabel quickTipHeader;

	/** The quick tip. */
	private final JTextArea quickTip;

	/** The panel_3. */
	private final JPanel panel_1, panel_3;

	/** The report maker tool service. */
	ReportMakerToolService reportMakerToolService = null;

	/** The work flow service. */
	WorkFlowManagerService workFlowService = null;

	/**
	 * Instantiates a new welcome.
	 *
	 * @param reportMakerToolService
	 *            the report maker tool service
	 * @param workFlowManagerService
	 *            the work flow manager service
	 */
	public Welcome(final ReportMakerToolService reportMakerToolService,
			final WorkFlowManagerService workFlowManagerService) {

		this.reportMakerToolService = reportMakerToolService;
		workFlowService = workFlowManagerService;
		welcomePanel = new JFrame();
		welcomePanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		welcomePanel.setBounds(100, 100, 791, 420);

		final JMenuBar menuBar = new JMenuBar();
		welcomePanel.setJMenuBar(menuBar);

		final JMenu keyboardShortcut = new JMenu("Keyboard Shortcut");
		menuBar.add(keyboardShortcut);

		final JMenuItem keyboardShortcutMenuItem = new JMenuItem("Keyboard Shortcut List");
		keyboardShortcut.add(keyboardShortcutMenuItem);
		keyboardShortcutMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Util.showKeyboardShortcut();

			}
		});

		final JMenu help = new JMenu("Help");
		menuBar.add(help);
		final JMenuItem helpMenuItem = new JMenuItem("Help");
		help.add(helpMenuItem);

		final JMenuItem aboutMenuItem = new JMenuItem("About");
		help.add(aboutMenuItem);

		welcomePanel.getContentPane().setLayout(null);

		final JPanel panel = new JPanel();
		panel.setBounds(32, 63, 259, 194);
		welcomePanel.add(panel);
		panel.setLayout(null);

		final JButton dataExtractor = new JButton("Extract Data");
		dataExtractor.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		dataExtractor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				showQuickTip(1);
			}
		});

		dataExtractor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				welcomePanel.setVisible(false);
				new ReportMakerUI("", reportMakerToolService, workFlowManagerService);

			}
		});
		dataExtractor.setBounds(0, 0, 259, 47);
		panel.add(dataExtractor);

		final JButton dataManager = new JButton("Manage Extacted Data");
		dataManager.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		dataManager.setBounds(0, 72, 259, 47);
		panel.add(dataManager);
		dataManager.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				showQuickTip(2);
			}
		});
		dataManager.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				welcomePanel.setVisible(false);
				new DataManagerUI(reportMakerToolService, workFlowManagerService);

			}
		});

		final JButton workflowBtn = new JButton("Workflow Manager");
		workflowBtn.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		workflowBtn.setBounds(0, 147, 259, 47);
		panel.add(workflowBtn);
		workflowBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				showQuickTip(3);
			}
		});
		workflowBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				welcomePanel.setVisible(false);
				new WorkflowDialogUI(reportMakerToolService, workFlowManagerService);

			}
		});

		panel_1 = new JPanel();
		panel_1.setBounds(424, 155, 306, 162);
		welcomePanel.add(panel_1);
		panel_1.setLayout(null);

		quickTipHeader = new JLabel("Create WorkFlow");
		quickTipHeader.setFont(new Font("Tahoma", Font.BOLD, 14));
		quickTipHeader.setBounds(0, 0, 306, 14);
		panel_1.add(quickTipHeader);

		quickTip = new JTextArea();
		quickTip.setLineWrap(true);
		quickTip.setWrapStyleWord(true);
		quickTip.setText("ui[;ir6 ek erthtyheruiherjtjrouijwtijwtuihrt4uheryjnst jeyaioseryk mt;,rsletkoj iwj");
		quickTip.setBackground(UIManager.getColor("Button.background"));
		quickTip.setForeground(Color.BLACK);
		quickTip.setEditable(false);
		quickTip.setBounds(0, 43, 306, 119);
		panel_1.add(quickTip);

		welcomePanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				panel_1.setVisible(false);
				panel_3.setVisible(true);
				quickTipHeader.setText("");
				quickTip.setText("");
			}
		});

		panel_3 = new JPanel();
		panel_3.setBounds(357, 89, 408, 228);
		welcomePanel.add(panel_3);
		panel_3.setLayout(null);

		final JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 11, 363, 165);
		panel_3.add(panel_4);
		panel_4.setLayout(null);

		final JLabel lblNewLabel = new JLabel("How it Works :");
		lblNewLabel.setBounds(2, 0, 138, 24);
		panel_4.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 14));

		final JTextArea txtrStepCreate = new JTextArea();
		txtrStepCreate.setBackground(UIManager.getColor("Button.background"));
		txtrStepCreate.setBounds(2, 48, 361, 29);
		panel_4.add(txtrStepCreate);
		txtrStepCreate.setLineWrap(true);
		txtrStepCreate.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		txtrStepCreate.setText("Step 1: Create Workflow based on Report Structure");

		final JTextArea txtrStep = new JTextArea();
		txtrStep.setBackground(UIManager.getColor("Button.background"));
		txtrStep.setBounds(2, 78, 361, 29);
		panel_4.add(txtrStep);
		txtrStep.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		txtrStep.setLineWrap(true);
		txtrStep.setText("Step 2 : Extract Data from HTML Table");

		final JTextArea txtrStep_1 = new JTextArea();
		txtrStep_1.setBackground(UIManager.getColor("Button.background"));
		txtrStep_1.setBounds(2, 107, 361, 29);
		panel_4.add(txtrStep_1);
		txtrStep_1.setText("Step 3 : Import Extracted data into Workflow");
		txtrStep_1.setLineWrap(true);
		txtrStep_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));

		final JTextArea txtrStep_2 = new JTextArea();
		txtrStep_2.setBackground(UIManager.getColor("Button.background"));
		txtrStep_2.setBounds(2, 136, 361, 29);
		panel_4.add(txtrStep_2);
		txtrStep_2.setText("Step 4 : Get ready to paste processed data with a click");
		txtrStep_2.setLineWrap(true);
		txtrStep_2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));

		final JLabel lblNewLabel_1 = new JLabel(AppConstants.APPNAME);
		lblNewLabel_1.setBounds(619, 11, 146, 50);
		welcomePanel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD, 24));
		lblNewLabel_1.setToolTipText(AppConstants.DialogBoxHeader.ABOUT_FOOTER);

		final JLabel lblOmnikeyV = new JLabel(AppConstants.DialogBoxHeader.ABOUT_FOOTER);
		lblOmnikeyV.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblOmnikeyV.setBounds(32, 324, 374, 14);
		welcomePanel.add(lblOmnikeyV);

		panel_3.setVisible(true);
		panel_1.setVisible(false);

		welcomePanel.setTitle(AppConstants.APPNAME);
		welcomePanel.setLocationRelativeTo(null);
		welcomePanel.setResizable(false);
		welcomePanel.setVisible(true);

	}

	/**
	 * Show quick tip.
	 *
	 * @param origin
	 *            the origin
	 */
	private void showQuickTip(int origin) {
		panel_3.setVisible(false);
		panel_1.setVisible(true);
		switch (origin) {
		case 1:
			quickTipHeader.setText(AppConstants.QuickGuideVerbage.QuickGuideHeaderVerbage.DATA_EXTRACTOR);
			quickTip.setText(AppConstants.QuickGuideVerbage.QuickGuideContentVerbage.DATA_EXTRACTOR);
			break;

		case 2:
			quickTipHeader.setText(AppConstants.QuickGuideVerbage.QuickGuideHeaderVerbage.DATA_MANAGER);
			quickTip.setText(AppConstants.QuickGuideVerbage.QuickGuideContentVerbage.DATA_MANAGER);
			break;

		case 3:
			quickTipHeader.setText(AppConstants.QuickGuideVerbage.QuickGuideHeaderVerbage.CREATE_WORKFLOW);
			quickTip.setText(AppConstants.QuickGuideVerbage.QuickGuideContentVerbage.CREATE_WORKFLOW);
			break;

		default:
			break;
		}

	}

}
