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
package com.tool.reportmaker.service;

import java.io.IOException;
import java.util.ArrayList;

import com.tool.reportmaker.dao.ReportMakingToolLogic;
import com.tool.reportmaker.exception.ReportMakerException;
import com.tool.reportmaker.exception.TextNotCorrectFormatException;
import com.tool.reportmaker.interfaces.ReportMakerInterface;

// TODO: Auto-generated Javadoc
/**
 * The Class ReportMakerToolService.
 */
public class ReportMakerToolService implements ReportMakerInterface {

	/** The reportmakingtoollogic. */
	ReportMakingToolLogic reportmakingtoollogic = new ReportMakingToolLogic();

	/* (non-Javadoc)
	 * @see com.tool.reportmaker.interfaces.ReportMakerInterface#textParse(java.util.ArrayList, int)
	 */
	public ArrayList<String> textParse(ArrayList<String> arrList, int coloumNo)
			throws IOException, TextNotCorrectFormatException {

		return reportmakingtoollogic.textParse(arrList, coloumNo);

	}

	/* (non-Javadoc)
	 * @see com.tool.reportmaker.interfaces.ReportMakerInterface#noOfColoumsPresentInText(java.util.ArrayList)
	 */
	public int noOfColoumsPresentInText(ArrayList<String> arrList) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.tool.reportmaker.interfaces.ReportMakerInterface#getMatrics()
	 */
	@Override
	public ArrayList<String> getMatrics() {
		// TODO Auto-generated method stub
		return reportmakingtoollogic.getMatrics();
	}

	/* (non-Javadoc)
	 * @see com.tool.reportmaker.interfaces.ReportMakerInterface#fetchValueFromOutput(java.util.ArrayList, int, int)
	 */
	@Override
	public ArrayList<String> fetchValueFromOutput(ArrayList<String> values, int start, int end)
			throws ReportMakerException {

		
		
		
		return reportmakingtoollogic.fetchValueFromOutput(values, start, end);
	}

}
