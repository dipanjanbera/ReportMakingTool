/*
 * ********************************************************
 * OmniKey : A Workflow Driven Smart Data Extraction Tool *
 * ********************************************************
 * 
 * @Package 	:	com.tool.reportmaker.exception	
 * @File 	  	: 	WorkFlowValidationException.java
 * @Created  	: 	07-10-2016(mm-dd-yyyy)
 * @Version		:	2.1.0
 * @Author     	: 	Dipanjan Bera Copyright (2016)
 * @Email		:	dipanjan033@gmail.com
 * 
 */
package com.tool.reportmaker.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class WorkFlowValidationException.
 */
public class WorkFlowValidationException extends Exception {

	/** The message. */
	String message="";
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new work flow validation exception.
	 */
	public WorkFlowValidationException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new work flow validation exception.
	 *
	 * @param message
	 *            the message
	 */
	public WorkFlowValidationException(String message) {
		super(message);
		//this.message = message;
	}

}
