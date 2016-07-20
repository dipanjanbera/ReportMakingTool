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
