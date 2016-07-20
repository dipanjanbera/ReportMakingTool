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
package com.tool.reportmaker.service;

import java.io.File;
import java.io.IOException;
import java.io.StreamCorruptedException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

import com.tool.reportmaker.dao.WorkFlowManagerDao;
import com.tool.reportmaker.exception.WorkFlowDuplicateElementException;
import com.tool.reportmaker.exception.WorkFlowTreeDrawingFailedException;
import com.tool.reportmaker.exception.WorkFlowValidationException;
import com.tool.reportmaker.interfaces.WorkFlowManagerInterface;
import com.tool.reportmaker.object.DataManagerObject;

// TODO: Auto-generated Javadoc
/**
 * The Class WorkFlowManagerService.
 */
public class WorkFlowManagerService implements WorkFlowManagerInterface {

	/** The work flow manager dao. */
	WorkFlowManagerDao workFlowManagerDao = new WorkFlowManagerDao();

	/**
	 * Creates the workflow.
	 *
	 * @return the data manager object
	 * @throws WorkFlowValidationException
	 *             the work flow validation exception
	 * @throws WorkFlowDuplicateElementException
	 *             the work flow duplicate element exception
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.tool.reportmaker.interfaces.WorkFlowManagerInterface#createWorkflow()
	 */
	@Override
	public DataManagerObject createWorkflow() throws WorkFlowValidationException, WorkFlowDuplicateElementException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Creates the workflow.
	 *
	 * @param workFlowName
	 *            the work flow name
	 * @param parentName
	 *            the parent name
	 * @param childName
	 *            the child name
	 * @return the data manager object
	 * @throws WorkFlowValidationException
	 *             the work flow validation exception
	 * @throws WorkFlowDuplicateElementException
	 *             the work flow duplicate element exception
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.tool.reportmaker.interfaces.WorkFlowManagerInterface#createWorkflow(
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public DataManagerObject createWorkflow(String workFlowName, String parentName, String childName)
			throws WorkFlowValidationException, WorkFlowDuplicateElementException {
		final DataManagerObject dataManagerObject = workFlowManagerDao.createWorkflow(workFlowName, parentName,
				childName);

		return dataManagerObject;
	}

	/**
	 * Creates the work flow tree.
	 *
	 * @return the default mutable tree node
	 * @throws WorkFlowTreeDrawingFailedException
	 *             the work flow tree drawing failed exception
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see com.tool.reportmaker.interfaces.WorkFlowManagerInterface#
	 * createWorkFlowTree()
	 */
	@Override
	public DefaultMutableTreeNode createWorkFlowTree() throws WorkFlowTreeDrawingFailedException {
		final DefaultMutableTreeNode treeNode = workFlowManagerDao.createWorkFlowTree();
		return treeNode;
	}

	/**
	 * Delete node controller.
	 *
	 * @param seletedValueToBeDeleted
	 *            the seleted value to be deleted
	 * @return true, if successful
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see com.tool.reportmaker.interfaces.WorkFlowManagerInterface#
	 * deleteNodeController(java.lang.String[])
	 */
	@Override
	public boolean deleteNodeController(String[] seletedValueToBeDeleted) {

		return workFlowManagerDao.deleteNodeController(seletedValueToBeDeleted);
	}

	/**
	 * Update node controller.
	 *
	 * @param seletedValueToBeUpdated
	 *            the seleted value to be updated
	 * @param tagNmaetoBeUpdated
	 *            the tag nmaeto be updated
	 * @return true, if successful
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see com.tool.reportmaker.interfaces.WorkFlowManagerInterface#
	 * updateNodeController(java.lang.String[], java.lang.String)
	 */
	@Override
	public boolean updateNodeController(String[] seletedValueToBeUpdated, String tagNmaetoBeUpdated) {

		return workFlowManagerDao.updateNodeController(seletedValueToBeUpdated, tagNmaetoBeUpdated);
	}

	/**
	 * Load tag names controller.
	 *
	 * @param parentName
	 *            the parent name
	 * @param workFlowName
	 *            the work flow name
	 * @param origin
	 *            the origin
	 * @return the array list
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see com.tool.reportmaker.interfaces.WorkFlowManagerInterface#
	 * loadTagNamesController(java.lang.String, java.lang.String, int)
	 */
	@Override
	public ArrayList<String> loadTagNamesController(String parentName, String workFlowName, int origin) {
		System.out.println("sdfasdf");
		return workFlowManagerDao.loadTagNamesController(parentName, workFlowName, origin);
	}

	/**
	 * Serialize work flow diagram.
	 *
	 * @param dataManagerObjectName
	 *            the data manager object name
	 * @param file
	 *            the file
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see com.tool.reportmaker.interfaces.WorkFlowManagerInterface#
	 * serializeWorkFlowDiagram(java.lang.String, java.io.File)
	 */
	@Override
	public void serializeWorkFlowDiagram(String dataManagerObjectName, File file) throws IOException {
		workFlowManagerDao.serializeWorkFlowDiagram(dataManagerObjectName, file);

	}

	/**
	 * De serialize work flow diagram.
	 *
	 * @param file
	 *            the file
	 * @return the data manager object
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws StreamCorruptedException
	 *             the stream corrupted exception
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see com.tool.reportmaker.interfaces.WorkFlowManagerInterface#
	 * deSerializeWorkFlowDiagram(java.io.File)
	 */
	@Override
	public DataManagerObject deSerializeWorkFlowDiagram(File file)
			throws ClassNotFoundException, IOException, StreamCorruptedException {
		return workFlowManagerDao.deSerializeWorkFlowDiagram(file);

	}

	/**
	 * Fetch values from child node.
	 *
	 * @param selectedValueFromJtree
	 *            the selected value from jtree
	 * @return the array list
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see com.tool.reportmaker.interfaces.WorkFlowManagerInterface#
	 * fetchValuesFromChildNode(java.lang.String[])
	 */
	@Override
	public ArrayList<String> fetchValuesFromChildNode(String[] selectedValueFromJtree) {

		return workFlowManagerDao.fetchValuesFromChildNode(selectedValueFromJtree);
	}

	/**
	 * Insert data into child node.
	 *
	 * @param selectedValueFromJtree
	 *            the selected value from jtree
	 * @param valuesTobeInserted
	 *            the values tobe inserted
	 * @param fileToBeSaved
	 *            the file to be saved
	 * @return true, if successful
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see com.tool.reportmaker.interfaces.WorkFlowManagerInterface#
	 * insertDataIntoChildNode(java.lang.String[], java.util.ArrayList,
	 * java.io.File)
	 */
	@Override
	public boolean insertDataIntoChildNode(String[] selectedValueFromJtree, ArrayList<String> valuesTobeInserted,
			File fileToBeSaved) throws IOException {

		return workFlowManagerDao.insertDataIntoChildNode(selectedValueFromJtree, valuesTobeInserted, fileToBeSaved);
	}

	/**
	 * Append data into child node.
	 *
	 * @param selectedValueFromJtree
	 *            the selected value from jtree
	 * @param valuesTobeInserted
	 *            the values tobe inserted
	 * @param fileToBeSaved
	 *            the file to be saved
	 * @return true, if successful
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see com.tool.reportmaker.interfaces.WorkFlowManagerInterface#
	 * appendDataIntoChildNode(java.lang.String[], java.util.ArrayList,
	 * java.io.File)
	 */
	@Override
	public boolean appendDataIntoChildNode(String[] selectedValueFromJtree, ArrayList<String> valuesTobeInserted,
			File fileToBeSaved) throws IOException {

		return workFlowManagerDao.appendDataIntoChildNode(selectedValueFromJtree, valuesTobeInserted, fileToBeSaved);
	}

	/**
	 * Delete values from child node.
	 *
	 * @param selectedValueFromJtree
	 *            the selected value from jtree
	 * @param valuesTobeInserted
	 *            the values tobe inserted
	 * @param fileToBeSaved
	 *            the file to be saved
	 * @return true, if successful
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see com.tool.reportmaker.interfaces.WorkFlowManagerInterface#
	 * deleteValuesFromChildNode(java.lang.String[], java.util.ArrayList,
	 * java.io.File)
	 */
	@Override
	public boolean deleteValuesFromChildNode(String[] selectedValueFromJtree, ArrayList<String> valuesTobeInserted,
			File fileToBeSaved) throws IOException {

		return workFlowManagerDao.deleteValuesFromChildNode(selectedValueFromJtree, valuesTobeInserted, fileToBeSaved);
	}

	/**
	 * Builds the j table controller.
	 *
	 * @param selectedValueFromJtree
	 *            the selected value from jtree
	 * @param totvalues
	 *            the totvalues
	 * @return the default table model
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see com.tool.reportmaker.interfaces.WorkFlowManagerInterface#
	 * buildJTableController(java.lang.String[], java.util.ArrayList)
	 */
	@Override
	public DefaultTableModel buildJTableController(String selectedValueFromJtree[], ArrayList<String> totvalues) {
		// TODO Auto-generated method stub
		return workFlowManagerDao.buildJTableController(selectedValueFromJtree, totvalues);
	}

	/**
	 * Gets the data manager object.
	 *
	 * @return the data manager object
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see com.tool.reportmaker.interfaces.WorkFlowManagerInterface#
	 * getDataManagerObject()
	 */
	@Override
	public DataManagerObject getDataManagerObject() {
		// TODO Auto-generated method stub
		return workFlowManagerDao.getDataManagerObject();
	}

	/**
	 * Clear all data from workflow.
	 */
	@Override
	public void clearAllDataFromWorkflow() {
		workFlowManagerDao.clearAllDataFromWorkflow();

	}

	/**
	 * Creates the new work flow object.
	 */
	@Override
	public void createNewWorkFlowObject() {
		workFlowManagerDao.createNewWorkFlowObject();

	}

}
