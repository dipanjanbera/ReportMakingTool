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
package com.tool.reportmaker.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class ReportMakerException.
 */
public class ReportMakerException extends Exception{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8589453661715596856L;

	/**
	 * Instantiates a new report maker exception.
	 */
	public ReportMakerException() {
		super();
		
	}
	
	/**
	 * Instantiates a new report maker exception.
	 *
	 * @param msg
	 *            the msg
	 */
	public ReportMakerException(String msg){
		super(msg);
		System.out.println("Exception At : "+msg);
	}

	
	
	

}
