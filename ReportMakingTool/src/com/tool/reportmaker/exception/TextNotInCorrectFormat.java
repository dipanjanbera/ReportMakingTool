/*
 * ********************************************************
 * OmniKey : A Workflow Driven Smart Data Extraction Tool *
 * ********************************************************
 * 
 * @Package 	:	com.tool.reportmaker.exception	
 * @File 	  	: 	TextNotInCorrectFormat.java
 * @Created  	: 	07-10-2016(mm-dd-yyyy)
 * @Version		:	2.1.0
 * @Author     	: 	Dipanjan Bera Copyright (2016)
 * @Email		:	dipanjan033@gmail.com
 * 
 */
package com.tool.reportmaker.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class TextNotInCorrectFormat.
 */
public class TextNotInCorrectFormat extends ReportMakerException {
	
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7487755306591354713L;
	
	/** The meg. */
	String meg ;

	/**
	 * Instantiates a new text not in correct format.
	 *
	 * @param meg
	 *            the meg
	 */
	public TextNotInCorrectFormat(String meg) {
		super();
		this.meg = meg;
	}

	
}
