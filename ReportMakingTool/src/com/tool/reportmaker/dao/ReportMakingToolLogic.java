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
	@Override
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
	@Override
	public int noOfColoumsPresentInText(ArrayList<String> arrList) {
		int count = 0;
		final String text = arrList.get(0);
		final Scanner src = new Scanner(text);
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
	@Override
	public ArrayList<String> textParse(ArrayList<String> arrList, int coloumNo)
			throws IOException, TextNotCorrectFormatException {

		try {
			int count;
			matrics = new ArrayList<String>();
			noOfColoumsPresentInText(arrList);
			for (final String txtValue : arrList) {

				final Scanner src = new Scanner(txtValue);
				src.useDelimiter("\t *");
				count = 2;

				while (src.hasNext()) {

					if (src.hasNext()) {

						if (!src.next().equals(null)) {
							final String value = src.next();

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

		} catch (final Exception exception) {

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
	@Override
	public ArrayList<String> fetchValueFromOutput(ArrayList<String> values, int start, int end)
			throws ReportMakerException {

		final ArrayList<String> valueArr = new ArrayList<String>();
		if (start > values.size()) {
			throw new ReportMakerException("Start index is more than Total Count");
		}

		if (end > (values.size() - 1)) {
			end = values.size() - 1;
		}

		if (end < 0) {
			throw new ReportMakerException("Start index is less than Zero (0)");
		}

		for (int i = start; i <= end; i++) {

			final String value = values.get(i);
			valueArr.add(value);

		}

		return valueArr;

	}

}
