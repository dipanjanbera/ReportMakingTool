
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
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;

import com.tool.reportmaker.service.ReportMakerToolService;
import com.tool.reportmaker.service.WorkFlowManagerService;
import com.tool.reportmaker.ui.Welcome;

// TODO: Auto-generated Javadoc
/**
 * The Class Start.
 */
public class Start extends JWindow {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * The main method.
	 */

	public Start() {
		final JLabel lbl = new JLabel(new ImageIcon(Start.class.getResource("/resourse/FotorCreated.jpg")));
		getContentPane().add(lbl, BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		final Start start = new Start();

		try {
			Thread.sleep(2000);
			start.dispose();
			final ReportMakerToolService reportMakerToolService = new ReportMakerToolService();
			final WorkFlowManagerService workFlowService = new WorkFlowManagerService();

			new Welcome(reportMakerToolService, workFlowService);
		} catch (final Exception exception) {
			exception.printStackTrace();
		}

	}

}
