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

import java.io.File;
import java.io.Serializable;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class DataManagerObject.
 */
public class DataManagerObject implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The work flow manager. */
	private WorkFlowManager workFlowManager = null;
	
	/** The object creation date. */
	private Date objectCreationDate;
	
	/** The object last modified date. */
	private Date objectLastModifiedDate;
	
	/** The is saved. */
	private boolean isSaved;
	
	/** The data manager object name. */
	private String dataManagerObjectName;
	
	/** The file location. */
	private File fileLocation;

	/**
	 * Instantiates a new data manager object.
	 *
	 * @param workFlowManager
	 *            the work flow manager
	 */
	public DataManagerObject(WorkFlowManager workFlowManager) {
		super();
		this.workFlowManager = workFlowManager;
	}

	/**
	 * Instantiates a new data manager object.
	 */
	public DataManagerObject() {
		super();
		workFlowManager = new WorkFlowManager();
	}

	/**
	 * Gets the file location.
	 *
	 * @return the file location
	 */
	public File getFileLocation() {
		return fileLocation;
	}

	/**
	 * Sets the file location.
	 *
	 * @param fileLocation
	 *            the new file location
	 */
	public void setFileLocation(File fileLocation) {
		this.fileLocation = fileLocation;
	}

	/**
	 * Gets the object creation date.
	 *
	 * @return the object creation date
	 */
	public Date getObjectCreationDate() {
		return objectCreationDate;
	}

	/**
	 * Sets the object creation date.
	 *
	 * @param objectCreationDate
	 *            the new object creation date
	 */
	public void setObjectCreationDate(Date objectCreationDate) {
		this.objectCreationDate = objectCreationDate;
	}

	/**
	 * Gets the object last modified date.
	 *
	 * @return the object last modified date
	 */
	public Date getObjectLastModifiedDate() {
		return objectLastModifiedDate;
	}

	/**
	 * Sets the object last modified date.
	 *
	 * @param objectLastModifiedDate
	 *            the new object last modified date
	 */
	public void setObjectLastModifiedDate(Date objectLastModifiedDate) {
		this.objectLastModifiedDate = objectLastModifiedDate;
	}

	/**
	 * Checks if is saved.
	 *
	 * @return true, if is saved
	 */
	public boolean isSaved() {
		return isSaved;
	}

	/**
	 * Sets the saved.
	 *
	 * @param isSaved
	 *            the new saved
	 */
	public void setSaved(boolean isSaved) {
		this.isSaved = isSaved;
	}

	/**
	 * Gets the data manager object name.
	 *
	 * @return the data manager object name
	 */
	public String getDataManagerObjectName() {
		return dataManagerObjectName;
	}

	/**
	 * Sets the data manager object name.
	 *
	 * @param dataManagerObjectName
	 *            the new data manager object name
	 */
	public void setDataManagerObjectName(String dataManagerObjectName) {
		this.dataManagerObjectName = dataManagerObjectName;
	}

	/**
	 * Gets the work flow manager.
	 *
	 * @return the work flow manager
	 */
	public WorkFlowManager getWorkFlowManager() {
		return workFlowManager;
	}

	/**
	 * Sets the work flow manager.
	 *
	 * @param workFlowManager
	 *            the new work flow manager
	 */
	public void setWorkFlowManager(WorkFlowManager workFlowManager) {
		this.workFlowManager = workFlowManager;
	}

	/**
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DataManagerObject [workFlowManager=" + workFlowManager + ", objectCreationDate=" + objectCreationDate
				+ ", objectLastModifiedDate=" + objectLastModifiedDate + ", isSaved=" + isSaved
				+ ", dataManagerObjectName=" + dataManagerObjectName + ", fileLocation=" + fileLocation + "]";
	}

}
