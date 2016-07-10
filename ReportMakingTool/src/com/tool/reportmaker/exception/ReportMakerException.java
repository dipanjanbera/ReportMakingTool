/*
 * ********************************************************
 * OmniKey : A Workflow Driven Smart Data Extraction Tool *
 * ********************************************************
 * 
 * @Package 	:	com.tool.reportmaker.exception	
 * @File 	  	: 	ReportMakerException.java
 * @Created  	: 	07-10-2016(mm-dd-yyyy)
 * @Version		:	2.1.0
 * @Author     	: 	Dipanjan Bera Copyright (2016)
 * @Email		:	dipanjan033@gmail.com
 * 
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
