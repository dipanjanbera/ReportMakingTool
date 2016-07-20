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
