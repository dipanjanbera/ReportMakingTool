
/*
 * ********************************************************
 * OmniKey : A Workflow Driven Smart Data Extraction Tool *
 * ********************************************************
 * 
 * @Package 	:		
 * @File 	  	: 	Start.java
 * @Created  	: 	07-10-2016(mm-dd-yyyy)
 * @Version		:	2.1.0
 * @Author     	: 	Dipanjan Bera Copyright (2016)
 * @Email		:	dipanjan033@gmail.com
 * 
 */
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;

import com.tool.reportmaker.service.ReportMakerToolService;
import com.tool.reportmaker.service.WorkFlowManagerService;
import com.tool.reportmaker.ui.Welcome;

/**
 * The Class Start.
 */
public class Start extends JWindow {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	

	public Start() {
		JLabel lbl = new JLabel(new ImageIcon(Start.class.getResource("/resourse/FotorCreated.jpg")));
	    getContentPane().add(lbl, BorderLayout.CENTER);
	    pack();
	    setLocationRelativeTo(null);
	    setVisible(true);
	}

	
	public static void main(String[] args) {
			Start start = new Start();

		try {
			Thread.sleep(2000);
			start.dispose();
			ReportMakerToolService reportMakerToolService = new ReportMakerToolService();
			WorkFlowManagerService workFlowService = new WorkFlowManagerService();

			new Welcome(reportMakerToolService, workFlowService);
		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}

}
