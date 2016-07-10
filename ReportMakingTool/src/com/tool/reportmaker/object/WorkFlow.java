/*
 * ********************************************************
 * OmniKey : A Workflow Driven Smart Data Extraction Tool *
 * ********************************************************
 * 
 * @Package 	:	com.tool.reportmaker.object	
 * @File 	  	: 	WorkFlow.java
 * @Created  	: 	07-10-2016(mm-dd-yyyy)
 * @Version		:	2.1.0
 * @Author     	: 	Dipanjan Bera Copyright (2016)
 * @Email		:	dipanjan033@gmail.com
 * 
 */
package com.tool.reportmaker.object;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

// TODO: Auto-generated Javadoc
/**
 * The Class WorkFlow.
 */
public class WorkFlow implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The work flow name. */
	private String workFlowName;
	
	/** The workflow creation date. */
	private String workflowCreationDate;
	
	/** The parent node list. */
	private ArrayList<ParentNode> parentNodeList = new  ArrayList<ParentNode>();

	/**
	 * Instantiates a new work flow.
	 */
	public WorkFlow() {
		super();
		// TODO Auto-generated constructork stub
	}

	/**
	 * Instantiates a new work flow.
	 *
	 * @param workFlowName
	 *            the work flow name
	 * @param workflowCreationDate
	 *            the workflow creation date
	 * @param parentNodeList
	 *            the parent node list
	 */
	public WorkFlow(String workFlowName, String workflowCreationDate, ArrayList<ParentNode> parentNodeList) {
		super();
		this.workFlowName = workFlowName;
		this.workflowCreationDate = workflowCreationDate;
		this.parentNodeList = parentNodeList;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WorkFlow [workFlowName=" + workFlowName + ", workflowCreationDate=" + workflowCreationDate
				+ ", parentNodeList=" + parentNodeList + "]";
	}

	/**
	 * Gets the work flow name.
	 *
	 * @return the work flow name
	 */
	public String getWorkFlowName() {
		return workFlowName;
	}

	/**
	 * Sets the work flow name.
	 *
	 * @param workFlowName
	 *            the new work flow name
	 */
	public void setWorkFlowName(String workFlowName) {
		this.workFlowName = workFlowName;
	}

	/**
	 * Gets the workflow creation date.
	 *
	 * @return the workflow creation date
	 */
	public String getWorkflowCreationDate() {
		return workflowCreationDate;
	}

	/**
	 * Sets the workflow creation date.
	 *
	 * @param workflowCreationDate
	 *            the new workflow creation date
	 */
	public void setWorkflowCreationDate(String workflowCreationDate) {
		this.workflowCreationDate = workflowCreationDate;
	}

	/**
	 * Gets the parent node list.
	 *
	 * @return the parent node list
	 */
	public ArrayList<ParentNode> getParentNodeList() {
		return parentNodeList;
	}

	/**
	 * Sets the parent node list.
	 *
	 * @param parentNodeList
	 *            the new parent node list
	 */
	public void setParentNodeList(ArrayList<ParentNode> parentNodeList) {
		this.parentNodeList = parentNodeList;
	}

	

}
