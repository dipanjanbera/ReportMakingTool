/*
 * ********************************************************
 * OmniKey : A Workflow Driven Smart Data Extraction Tool *
 * ********************************************************
 * 
 * @Package 	:	com.tool.reportmaker.object	
 * @File 	  	: 	WorkFlowManager.java
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
 * The Class WorkFlowManager.
 */
public class WorkFlowManager implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The work flow list. */
	private ArrayList<WorkFlow> workFlowList = new ArrayList<WorkFlow>();

	/**
	 * Instantiates a new work flow manager.
	 */
	public WorkFlowManager() {
		super();
		
	}

	/**
	 * Instantiates a new work flow manager.
	 *
	 * @param workFlowList
	 *            the work flow list
	 */
	public WorkFlowManager(ArrayList<WorkFlow> workFlowList) {
		super();
		this.workFlowList = workFlowList;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WorkFlowManager [workFlowList=" + workFlowList + "]";
	}

	/**
	 * Gets the work flow list.
	 *
	 * @return the work flow list
	 */
	public ArrayList<WorkFlow> getWorkFlowList() {
		return workFlowList;
	}

	/**
	 * Sets the work flow list.
	 *
	 * @param workFlowList
	 *            the new work flow list
	 */
	public void setWorkFlowList(ArrayList<WorkFlow> workFlowList) {
		this.workFlowList = workFlowList;
	}

	

	

}
