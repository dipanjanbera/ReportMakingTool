/*
 * ********************************************************
 * OmniKey : A Workflow Driven Smart Data Extraction Tool *
 * ********************************************************
 * 
 * @Package 	:	com.tool.reportmaker.exception	
 * @File 	  	: 	WorkFlowDuplicateElementException.java
 * @Created  	: 	07-10-2016(mm-dd-yyyy)
 * @Version		:	2.1.0
 * @Author     	: 	Dipanjan Bera Copyright (2016)
 * @Email		:	dipanjan033@gmail.com
 * 
 */
package com.tool.reportmaker.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class WorkFlowDuplicateElementException.
 */
public class WorkFlowDuplicateElementException extends Exception {

	/** The message. */

	private String message;

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new work flow duplicate element exception.
	 */
	public WorkFlowDuplicateElementException() {
		super();
	}

	/**
	 * Instantiates a new work flow duplicate element exception.
	 *
	 * @param message
	 *            the message
	 */
	public WorkFlowDuplicateElementException(String message) {
		super(message);
	}

}
