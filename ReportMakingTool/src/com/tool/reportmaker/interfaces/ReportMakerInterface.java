/*
 * ********************************************************
 * OmniKey : A Workflow Driven Smart Data Extraction Tool *
 * ********************************************************
 * 
 * @Package 	:	com.tool.reportmaker.interfaces	
 * @File 	  	: 	ReportMakerInterface.java
 * @Created  	: 	07-10-2016(mm-dd-yyyy)
 * @Version		:	2.1.0
 * @Author     	: 	Dipanjan Bera Copyright (2016)
 * @Email		:	dipanjan033@gmail.com
 * 
 */
package com.tool.reportmaker.interfaces;

import java.io.IOException;
import java.util.ArrayList;

import com.tool.reportmaker.exception.ReportMakerException;
import com.tool.reportmaker.exception.TextNotCorrectFormatException;

// TODO: Auto-generated Javadoc
/**
 * The Interface ReportMakerInterface.
 */
public interface ReportMakerInterface {

	/**
	 * Text parse.
	 *
	 * @param arrList
	 *            the arr list
	 * @param coloumNo
	 *            the coloum no
	 * @return the array list
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws TextNotCorrectFormatException
	 *             the text not correct format exception
	 */
	ArrayList<String> textParse(ArrayList<String> arrList, int coloumNo)
			throws IOException, TextNotCorrectFormatException;

	/**
	 * No of coloums present in text.
	 *
	 * @param arrList
	 *            the arr list
	 * @return the int
	 */
	int noOfColoumsPresentInText(ArrayList<String> arrList);

	/**
	 * Gets the matrics.
	 *
	 * @return the matrics
	 */
	ArrayList<String> getMatrics();

	/**
	 * Fetch value from output.
	 *
	 * @param values
	 *            the values
	 * @param start
	 *            the start
	 * @param end
	 *            the end
	 * @return the array list
	 * @throws ReportMakerException
	 *             the report maker exception
	 */
	ArrayList<String> fetchValueFromOutput(ArrayList<String> values, int start, int end) throws ReportMakerException;

}
