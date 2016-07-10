/*
 * ********************************************************
 * OmniKey : A Workflow Driven Smart Data Extraction Tool *
 * ********************************************************
 * 
 * @Package 	:	com.tool.reportmaker.service	
 * @File 	  	: 	ReportMakerToolService.java
 * @Created  	: 	07-10-2016(mm-dd-yyyy)
 * @Version		:	2.1.0
 * @Author     	: 	Dipanjan Bera Copyright (2016)
 * @Email		:	dipanjan033@gmail.com
 * 
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
