/*
 * ********************************************************
 * OmniKey : A Workflow Driven Smart Data Extraction Tool *
 * ********************************************************
 * 
 * @Package 	:	com.tool.reportmaker.dao	
 * @File 	  	: 	ReportMakingToolLogic.java
 * @Created  	: 	07-10-2016(mm-dd-yyyy)
 * @Version		:	2.1.0
 * @Author     	: 	Dipanjan Bera Copyright (2016)
 * @Email		:	dipanjan033@gmail.com
 * 
 */
package com.tool.reportmaker.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.tool.reportmaker.exception.ReportMakerException;
import com.tool.reportmaker.exception.TextNotCorrectFormatException;
import com.tool.reportmaker.interfaces.ReportMakerInterface;

// TODO: Auto-generated Javadoc
/**
 * The Class ReportMakingToolLogic.
 */
public class ReportMakingToolLogic implements ReportMakerInterface {

	/** The matrics. */
	private ArrayList<String> matrics = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tool.reportmaker.interfaces.ReportMakerInterface#getMatrics()
	 */
	public ArrayList<String> getMatrics() {
		return matrics;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tool.reportmaker.interfaces.ReportMakerInterface#
	 * noOfColoumsPresentInText(java.util.ArrayList)
	 */
	public int noOfColoumsPresentInText(ArrayList<String> arrList) {
		int count = 0;
		String text = arrList.get(0);
		Scanner src = new Scanner(text);
		src.useDelimiter("\t *");
		while (src.hasNext()) {
			if (src.hasNext()) {
				if (!src.next().equals(null)) {
					count++;
				} else {
					break;
				}
			}
		}

		return count;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tool.reportmaker.interfaces.ReportMakerInterface#textParse(java.util.
	 * ArrayList, int)
	 */
	public ArrayList<String> textParse(ArrayList<String> arrList, int coloumNo)
			throws IOException, TextNotCorrectFormatException {

		try {
			int count, temCount;
			matrics = new ArrayList<String>();
			noOfColoumsPresentInText(arrList);
			boolean flag = true;
			for (String txtValue : arrList) {

				Scanner src = new Scanner(txtValue);
				src.useDelimiter("\t *");
				count = 2;

				while (src.hasNext()) {

					if (src.hasNext()) {

						if (!src.next().equals(null)) {
							String value = src.next();

							if (count == coloumNo) {
								putIntegerIntoList(value);
							}
							count++;
						}

					} else {
						break;
					}

				}

				if (coloumNo > count) {

				}

			}

		} catch (Exception exception) {

			throw new TextNotCorrectFormatException("");
		}
		return matrics;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tool.reportmaker.interfaces.ReportMakerInterface#fetchValueFromOutput
	 * (java.util.ArrayList, int, int)
	 */
	public ArrayList<String> fetchValueFromOutput(ArrayList<String> values, int start, int end)
			throws ReportMakerException {

		ArrayList<String> valueArr = new ArrayList<String>();
		if (start > values.size()) {
			throw new ReportMakerException("Start index is more than Total Count");
		}

		if (end > values.size() - 1) {
			end = values.size() - 1;
		}

		if (end < 0) {
			throw new ReportMakerException("Start index is less than Zero (0)");
		}

		for (int i = start; i <= end; i++) {

			String value = values.get(i);
			valueArr.add(value);

		}

		return valueArr;

	}

}
