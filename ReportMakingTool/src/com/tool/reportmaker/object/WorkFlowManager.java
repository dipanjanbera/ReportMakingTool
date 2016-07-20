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
