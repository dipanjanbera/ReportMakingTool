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
package com.tool.reportmaker.interfaces;

import java.io.File;
import java.io.IOException;
import java.io.StreamCorruptedException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

import com.tool.reportmaker.eventListener.WorkflowNodeEventListener;
import com.tool.reportmaker.eventListener.WorkflowTreeEventListener;
import com.tool.reportmaker.exception.WorkFlowDuplicateElementException;
import com.tool.reportmaker.exception.WorkFlowTreeDrawingFailedException;
import com.tool.reportmaker.exception.WorkFlowValidationException;
import com.tool.reportmaker.object.DataManagerObject;

// TODO: Auto-generated Javadoc
/**
 * The Interface WorkFlowManagerInterface.
 */
public interface WorkFlowManagerInterface {

	/**
	 * Creates the workflow.
	 *
	 * @return the data manager object
	 * @throws WorkFlowValidationException
	 *             the work flow validation exception
	 * @throws WorkFlowDuplicateElementException
	 *             the work flow duplicate element exception
	 */
	DataManagerObject createWorkflow() throws WorkFlowValidationException, WorkFlowDuplicateElementException;

	/**
	 * Creates the workflow.
	 *
	 * @param workFlowName
	 *            the work flow name
	 * @param parentName
	 *            the parent name
	 * @param childName
	 *            the child name
	 * @param dataManagerObject
	 *            the data manager object
	 * @param workflowNodeEventListener
	 *            the workflow node event listener
	 * @throws WorkFlowValidationException
	 *             the work flow validation exception
	 * @throws WorkFlowDuplicateElementException
	 *             the work flow duplicate element exception
	 */
	void createWorkflow(String workFlowName, String parentName, String childName, DataManagerObject dataManagerObject,
			WorkflowNodeEventListener workflowNodeEventListener)
			throws WorkFlowValidationException, WorkFlowDuplicateElementException;

	/**
	 * Creates the work flow tree.
	 *
	 * @param defaultMutableTreeNode
	 *            the default mutable tree node
	 * @param workflowTreeEventListener
	 *            the workflow tree event listener
	 * @throws WorkFlowTreeDrawingFailedException
	 *             the work flow tree drawing failed exception
	 */
	public void createWorkFlowTree(DefaultMutableTreeNode defaultMutableTreeNode,
			WorkflowTreeEventListener workflowTreeEventListener) throws WorkFlowTreeDrawingFailedException;

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
	DataManagerObject createWorkflow(String workFlowName, String parentName, String childName)
			throws WorkFlowValidationException, WorkFlowDuplicateElementException;

	/**
	 * Creates the work flow tree.
	 *
	 * @return the default mutable tree node
	 * @throws WorkFlowTreeDrawingFailedException
	 *             the work flow tree drawing failed exception
	 */
	DefaultMutableTreeNode createWorkFlowTree() throws WorkFlowTreeDrawingFailedException;

	/**
	 * Delete node controller.
	 *
	 * @param seletedValueToBeDeleted
	 *            the seleted value to be deleted
	 * @return true, if successful
	 */
	boolean deleteNodeController(String[] seletedValueToBeDeleted);

	/**
	 * Delete node controller.
	 *
	 * @param seletedValueToBeDeleted
	 *            the seleted value to be deleted
	 * @param workflowNodeEventListener
	 *            the workflow node event listener
	 * @return true, if successful
	 */
	boolean deleteNodeController(String[] seletedValueToBeDeleted, WorkflowNodeEventListener workflowNodeEventListener);

	/**
	 * Update node controller.
	 *
	 * @param seletedValueToBeUpdated
	 *            the seleted value to be updated
	 * @param tagNmaetoBeUpdated
	 *            the tag nmaeto be updated
	 * @return true, if successful
	 */
	boolean updateNodeController(String[] seletedValueToBeUpdated, String tagNmaetoBeUpdated);

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
	ArrayList<String> loadTagNamesController(String parentName, String workFlowName, int origin);

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
	void serializeWorkFlowDiagram(String dataManagerObjectName, File file) throws IOException;

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
	DataManagerObject deSerializeWorkFlowDiagram(File file)
			throws ClassNotFoundException, IOException, StreamCorruptedException;

	/**
	 * Fetch values from child node.
	 *
	 * @param selectedValueFromJtree
	 *            the selected value from jtree
	 * @return the array list
	 */
	ArrayList<String> fetchValuesFromChildNode(String selectedValueFromJtree[]);

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
	boolean insertDataIntoChildNode(String selectedValueFromJtree[], ArrayList<String> valuesTobeInserted,
			File fileToBeSaved) throws IOException;

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
	boolean appendDataIntoChildNode(String selectedValueFromJtree[], ArrayList<String> valuesTobeInserted,
			File fileToBeSaved) throws IOException;

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
	boolean deleteValuesFromChildNode(String selectedValueFromJtree[], ArrayList<String> valuesTobeInserted,
			File fileToBeSaved) throws IOException;

	/**
	 * Builds the j table controller.
	 *
	 * @param selectedValueFromJtree
	 *            the selected value from jtree
	 * @param totvalues
	 *            the totvalues
	 * @return the default table model
	 */
	DefaultTableModel buildJTableController(String selectedValueFromJtree[], ArrayList<String> totvalues);

	/**
	 * Gets the data manager object.
	 *
	 * @return the data manager object
	 */
	public DataManagerObject getDataManagerObject();

	/**
	 * Clear all data from workflow.
	 */
	void clearAllDataFromWorkflow();

	/**
	 * Creates the new work flow object.
	 */
	public void createNewWorkFlowObject();
}
