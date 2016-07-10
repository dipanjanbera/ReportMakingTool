/*
 * ********************************************************
 * OmniKey : A Workflow Driven Smart Data Extraction Tool *
 * ********************************************************
 * 
 * @Package 	:	com.tool.reportmaker.object	
 * @File 	  	: 	ChildNode.java
 * @Created  	: 	07-10-2016(mm-dd-yyyy)
 * @Version		:	2.1.0
 * @Author     	: 	Dipanjan Bera Copyright (2016)
 * @Email		:	dipanjan033@gmail.com
 * 
 */
package com.tool.reportmaker.object;

import java.io.Serializable;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class ChildNode.
 */
public class ChildNode implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The values. */
	private ArrayList<String> values = new ArrayList<String>();
	
	/** The tag name. */
	private String tagName;
	
	/** The is childnode. */
	private boolean isChildnode;

	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ChildNode [values=" + values + ", tagName=" + tagName + ", isChildnode=" + isChildnode + "]";
	}

	/**
	 * Instantiates a new child node.
	 */
	public ChildNode() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Gets the values.
	 *
	 * @return the values
	 */
	public ArrayList<String> getValues() {
		return values;
	}

	/**
	 * Sets the values.
	 *
	 * @param values
	 *            the new values
	 */
	public void setValues(ArrayList<String> values) {
		this.values = values;
	}

	/**
	 * Gets the tag name.
	 *
	 * @return the tag name
	 */
	public String getTagName() {
		return tagName;
	}

	/**
	 * Sets the tag name.
	 *
	 * @param tagName
	 *            the new tag name
	 */
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	/**
	 * Checks if is childnode.
	 *
	 * @return true, if is childnode
	 */
	public boolean isChildnode() {
		return isChildnode;
	}

	/**
	 * Sets the childnode.
	 *
	 * @param isChildnode
	 *            the new childnode
	 */
	public void setChildnode(boolean isChildnode) {
		this.isChildnode = isChildnode;
	}

	/**
	 * Instantiates a new child node.
	 *
	 * @param values
	 *            the values
	 * @param tagName
	 *            the tag name
	 * @param isChildnode
	 *            the is childnode
	 */
	public ChildNode(ArrayList<String> values, String tagName, boolean isChildnode) {
		super();
		this.values = values;
		this.tagName = tagName;
		this.isChildnode = isChildnode;
	}

}
