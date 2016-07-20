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

package com.tool.reportmaker.dao;

import java.io.File;
import java.io.IOException;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

import com.tool.reportmaker.exception.WorkFlowDuplicateElementException;
import com.tool.reportmaker.exception.WorkFlowTreeDrawingFailedException;
import com.tool.reportmaker.exception.WorkFlowValidationException;
import com.tool.reportmaker.interfaces.WorkFlowManagerInterface;
import com.tool.reportmaker.object.ChildNode;
import com.tool.reportmaker.object.DataManagerObject;
import com.tool.reportmaker.object.ParentNode;
import com.tool.reportmaker.object.WorkFlow;
import com.tool.reportmaker.object.WorkFlowManager;
import com.tool.reportmaker.util.Util;

// TODO: Auto-generated Javadoc
/**
 * The Class WorkFlowManagerDao.
 */
public class WorkFlowManagerDao implements WorkFlowManagerInterface {

	/** The data manager object. */
	DataManagerObject dataManagerObject = null;

	/** The util. */
	Util util = new Util();

	/**
	 * Instantiates a new work flow manager dao.
	 *
	 * @param dataManagerObject
	 *            the data manager object
	 */
	WorkFlowManagerDao(DataManagerObject dataManagerObject) {
		this.dataManagerObject = dataManagerObject;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.tool.reportmaker.interfaces.WorkFlowManagerInterface#
	 * getDataManagerObject()
	 */
	@Override
	public DataManagerObject getDataManagerObject() {
		return dataManagerObject;
	}

	/**
	 * Sets the data manager object.
	 *
	 * @param dataManagerObject
	 *            the new data manager object
	 */
	public void setDataManagerObject(DataManagerObject dataManagerObject) {
		this.dataManagerObject = dataManagerObject;
	}

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
		if (validateUserInput(workFlowName, parentName, childName)) {
			dataManagerObject = createWorkFlowNode(workFlowName, parentName, childName);
			dataManagerObject.setSaved(false);
		}
		return dataManagerObject;
	}

	/**
	 * Validate user input.
	 *
	 * @param WorkFlowNmae
	 *            the work flow nmae
	 * @param ParentName
	 *            the parent name
	 * @param childNaame
	 *            the child naame
	 * @return true, if successful
	 * @throws WorkFlowValidationException
	 *             the work flow validation exception
	 */
	private boolean validateUserInput(String WorkFlowNmae, String ParentName, String childNaame)
			throws WorkFlowValidationException {

		if (WorkFlowNmae.equals("") || ParentName.equals("") || childNaame.equals("")) {
			throw new WorkFlowValidationException("One or More Fields left Blank");
		}
		return true;

	}

	/**
	 * Creates the work flow node.
	 *
	 * @param workFlowName
	 *            the work flow name
	 * @param parentName
	 *            the parent name
	 * @param childName
	 *            the child name
	 * @return the data manager object
	 * @throws WorkFlowDuplicateElementException
	 *             the work flow duplicate element exception
	 */
	@SuppressWarnings("unused")
	private DataManagerObject createWorkFlowNode(String workFlowName, String parentName, String childName)
			throws WorkFlowDuplicateElementException {

		WorkFlowManager workFlowManager = new WorkFlowManager();

		workFlowManager = dataManagerObject.getWorkFlowManager();

		WorkFlow workFlow = checkIfWorkFlowAlreadyExists(workFlowManager, workFlowName);

		if (workFlow == null) {
			workFlow = creatNewWorkFlowModel(workFlowManager, workFlowName);
		}

		ParentNode parentNode = checkIfParentNodeAlreadyExists(workFlow, parentName);

		if (parentNode == null) {
			parentNode = createParentNode(workFlow, parentName);
		}

		if (!ckeckIfChildNodeAlreadyExists(parentNode, childName)) {
			createNewChildNode(parentNode, childName);
		}

		return dataManagerObject;

	}

	/**
	 * Check if work flow already exists.
	 *
	 * @param workFlowManager
	 *            the work flow manager
	 * @param workFlowName
	 *            the work flow name
	 * @return the work flow
	 */
	private WorkFlow checkIfWorkFlowAlreadyExists(WorkFlowManager workFlowManager, String workFlowName) {

		if (workFlowManager != null) {
			for (final WorkFlow workFlow : workFlowManager.getWorkFlowList()) {
				if (workFlow.getWorkFlowName().equals(workFlowName.trim())) {
					return workFlow;
				}
			}
		}

		return null;
	}

	/**
	 * Create new work flow model.
	 *
	 * @param workFlowManager
	 *            the work flow manager
	 * @param workFlowName
	 *            the work flow name
	 * @return the work flow
	 */
	private WorkFlow creatNewWorkFlowModel(WorkFlowManager workFlowManager, String workFlowName) {

		final Calendar cal = Calendar.getInstance();
		final WorkFlow workFlow = new WorkFlow(workFlowName, cal.getTime().toString(), new ArrayList<ParentNode>());
		workFlowManager.getWorkFlowList().add(workFlow);
		return workFlow;

	}

	/**
	 * Check if parent node already exists.
	 *
	 * @param workFlow
	 *            the work flow
	 * @param parentNodeName
	 *            the parent node name
	 * @return the parent node
	 */
	private ParentNode checkIfParentNodeAlreadyExists(WorkFlow workFlow, String parentNodeName) {
		if (workFlow != null) {
			for (final ParentNode parentNode : workFlow.getParentNodeList()) {
				if (parentNode.getParentNodeName().equals(parentNodeName)) {
					return parentNode;
				}
			}
		}
		return null;
	}

	/**
	 * Creates the parent node.
	 *
	 * @param workFlow
	 *            the work flow
	 * @param parentNodeName
	 *            the parent node name
	 * @return the parent node
	 */
	private ParentNode createParentNode(WorkFlow workFlow, String parentNodeName) {
		final Calendar cal = Calendar.getInstance();
		final ParentNode parentNode = new ParentNode(new ArrayList<ChildNode>(), true, cal.getTime().toString(),
				parentNodeName);
		workFlow.getParentNodeList().add(parentNode);
		return parentNode;
	}

	/**
	 * Ckeck if child node already exists.
	 *
	 * @param parentNode
	 *            the parent node
	 * @param chileNodeName
	 *            the chile node name
	 * @return true, if successful
	 * @throws WorkFlowDuplicateElementException
	 *             the work flow duplicate element exception
	 */
	private boolean ckeckIfChildNodeAlreadyExists(ParentNode parentNode, String chileNodeName)
			throws WorkFlowDuplicateElementException {
		if (parentNode != null) {
			for (final ChildNode childNode : parentNode.getChildNodeList()) {
				if (childNode.getTagName().equals(chileNodeName)) {
					throw new WorkFlowDuplicateElementException("Duplicate Chile Node Name Exists");
				}
			}
		}
		return false;
	}

	/**
	 * Creates the new child node.
	 *
	 * @param parentNode
	 *            the parent node
	 * @param childNodeName
	 *            the child node name
	 * @return the child node
	 */
	private ChildNode createNewChildNode(ParentNode parentNode, String childNodeName) {
		final ChildNode childNode = new ChildNode(new ArrayList<String>(), childNodeName, true);
		parentNode.getChildNodeList().add(childNode);
		return childNode;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.tool.reportmaker.interfaces.WorkFlowManagerInterface#
	 * createWorkFlowTree()
	 */
	@Override
	public DefaultMutableTreeNode createWorkFlowTree() throws WorkFlowTreeDrawingFailedException {

		final DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
		DefaultMutableTreeNode defaultMutableTreeNode = null;

		final ArrayList<WorkFlow> workFlowList = dataManagerObject.getWorkFlowManager().getWorkFlowList();

		for (final WorkFlow workFlow : workFlowList) {
			if (workFlow != null) {
				defaultMutableTreeNode = new DefaultMutableTreeNode(workFlow.getWorkFlowName());
				addParentNode(defaultMutableTreeNode, workFlow);
				root.add(defaultMutableTreeNode);
			}
		}

		return root;
	}

	/**
	 * Adds the parent node.
	 *
	 * @param defaultMutableWorkFlowNode
	 *            the default mutable work flow node
	 * @param workFlow
	 *            the work flow
	 * @return the default mutable tree node
	 */
	private DefaultMutableTreeNode addParentNode(DefaultMutableTreeNode defaultMutableWorkFlowNode, WorkFlow workFlow) {
		DefaultMutableTreeNode defaultMutableParentTreeNode = null;
		if (workFlow != null) {
			for (final ParentNode parentNode : workFlow.getParentNodeList()) {
				if (parentNode != null) {
					defaultMutableParentTreeNode = new DefaultMutableTreeNode(parentNode.getParentNodeName());
					addChildNode(defaultMutableParentTreeNode, parentNode);
					defaultMutableWorkFlowNode.add(defaultMutableParentTreeNode);
				}
			}
		}
		return defaultMutableWorkFlowNode;
	}

	/**
	 * Adds the child node.
	 *
	 * @param defaultMutableParentNode
	 *            the default mutable parent node
	 * @param parentNode
	 *            the parent node
	 * @return the default mutable tree node
	 */
	private DefaultMutableTreeNode addChildNode(DefaultMutableTreeNode defaultMutableParentNode,
			ParentNode parentNode) {
		DefaultMutableTreeNode defaultMutableChildTreeNode = null;
		if (parentNode != null) {
			for (final ChildNode childNode : parentNode.getChildNodeList()) {
				if (childNode != null) {
					defaultMutableChildTreeNode = new DefaultMutableTreeNode(childNode.getTagName());
					defaultMutableParentNode.add(defaultMutableChildTreeNode);
				}
			}
		}
		return defaultMutableParentNode;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.tool.reportmaker.interfaces.WorkFlowManagerInterface#
	 * deleteNodeController(java.lang.String[])
	 */
	@Override
	public boolean deleteNodeController(String[] seletedValueToBeDeleted) {
		boolean result = false;
		switch (seletedValueToBeDeleted.length) {
		case 1:
			result = deleteWorkFlowNode(seletedValueToBeDeleted[0]);
			break;

		case 2:
			result = deleteParentNode(seletedValueToBeDeleted[0], seletedValueToBeDeleted[1]);
			break;
		case 3:

			result = deleteChildNode(seletedValueToBeDeleted[0], seletedValueToBeDeleted[1],
					seletedValueToBeDeleted[2]);
			break;

		}
		dataManagerObject.setSaved(false);
		return result;
	}

	/**
	 * Delete work flow node.
	 *
	 * @param workFlowName
	 *            the work flow name
	 * @return true, if successful
	 */
	private boolean deleteWorkFlowNode(String workFlowName) {

		for (final WorkFlow workFlow : dataManagerObject.getWorkFlowManager().getWorkFlowList()) {
			if (workFlow.getWorkFlowName().equals(workFlowName)) {
				dataManagerObject.getWorkFlowManager().getWorkFlowList().remove(workFlow);
				return true;
			}
		}
		return false;
	}

	/**
	 * Delete parent node.
	 *
	 * @param workFlowName
	 *            the work flow name
	 * @param parentName
	 *            the parent name
	 * @return true, if successful
	 */
	private boolean deleteParentNode(String workFlowName, String parentName) {
		WorkFlow workFlowNode = null;
		for (final WorkFlow workFlow : dataManagerObject.getWorkFlowManager().getWorkFlowList()) {
			if (workFlow.getWorkFlowName().equals(workFlowName)) {
				workFlowNode = workFlow;
				for (final ParentNode parentNode : workFlow.getParentNodeList()) {
					if (parentNode.getParentNodeName().equals(parentName)) {

						workFlowNode.getParentNodeList().remove(parentNode);

						return true;
					}
				}
			}
		}
		return false;

	}

	/**
	 * Delete child node.
	 *
	 * @param workFlowName
	 *            the work flow name
	 * @param parentName
	 *            the parent name
	 * @param childName
	 *            the child name
	 * @return true, if successful
	 */
	private boolean deleteChildNode(String workFlowName, String parentName, String childName) {
		ParentNode parentNodeMain = null;
		for (final WorkFlow workFlow : dataManagerObject.getWorkFlowManager().getWorkFlowList()) {
			if (workFlow.getWorkFlowName().equals(workFlowName)) {
				for (final ParentNode parentNode : workFlow.getParentNodeList()) {
					if (parentNode.getParentNodeName().equals(parentName)) {
						parentNodeMain = parentNode;
						for (final ChildNode childNode : parentNode.getChildNodeList()) {
							if (childNode.getTagName().equals(childName)) {
								parentNodeMain.getChildNodeList().remove(childNode);
								return true;
							}
						}
					}
				}
			}
		}
		return false;

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.tool.reportmaker.interfaces.WorkFlowManagerInterface#
	 * updateNodeController(java.lang.String[], java.lang.String)
	 */
	@Override
	public boolean updateNodeController(String[] seletedValueToBeUpdated, String tagNmaetoBeUpdated) {
		boolean result = false;
		switch (seletedValueToBeUpdated.length) {
		case 1:
			result = updateWorkFlowNode(seletedValueToBeUpdated[0], tagNmaetoBeUpdated);
			break;

		case 2:
			result = updateParentNode(seletedValueToBeUpdated[0], seletedValueToBeUpdated[1], tagNmaetoBeUpdated);
			break;
		case 3:

			result = updateChildNode(seletedValueToBeUpdated[0], seletedValueToBeUpdated[1], seletedValueToBeUpdated[2],
					tagNmaetoBeUpdated);
			break;

		}
		dataManagerObject.setSaved(false);
		return result;
	}

	/**
	 * Update work flow node.
	 *
	 * @param workFlowName
	 *            the work flow name
	 * @param tagNmaetoBeUpdated
	 *            the tag nmaeto be updated
	 * @return true, if successful
	 */
	private boolean updateWorkFlowNode(String workFlowName, String tagNmaetoBeUpdated) {

		for (final WorkFlow workFlow : dataManagerObject.getWorkFlowManager().getWorkFlowList()) {
			if (workFlow.getWorkFlowName().equals(workFlowName)) {
				workFlow.setWorkFlowName(tagNmaetoBeUpdated);
				return true;
			}
		}
		return false;
	}

	/**
	 * Update parent node.
	 *
	 * @param workFlowName
	 *            the work flow name
	 * @param parentName
	 *            the parent name
	 * @param tagNmaetoBeUpdated
	 *            the tag nmaeto be updated
	 * @return true, if successful
	 */
	private boolean updateParentNode(String workFlowName, String parentName, String tagNmaetoBeUpdated) {

		for (final WorkFlow workFlow : dataManagerObject.getWorkFlowManager().getWorkFlowList()) {
			if (workFlow.getWorkFlowName().equals(workFlowName)) {
				for (final ParentNode parentNode : workFlow.getParentNodeList()) {
					if (parentNode.getParentNodeName().equals(parentName)) {

						parentNode.setParentNodeName(tagNmaetoBeUpdated);

						return true;
					}
				}
			}
		}
		return false;

	}

	/**
	 * Update child node.
	 *
	 * @param workFlowName
	 *            the work flow name
	 * @param parentName
	 *            the parent name
	 * @param childName
	 *            the child name
	 * @param tagNmaetoBeUpdated
	 *            the tag nmaeto be updated
	 * @return true, if successful
	 */
	private boolean updateChildNode(String workFlowName, String parentName, String childName,
			String tagNmaetoBeUpdated) {

		for (final WorkFlow workFlow : dataManagerObject.getWorkFlowManager().getWorkFlowList()) {
			if (workFlow.getWorkFlowName().equals(workFlowName)) {
				for (final ParentNode parentNode : workFlow.getParentNodeList()) {
					if (parentNode.getParentNodeName().equals(parentName)) {
						for (final ChildNode childNode : parentNode.getChildNodeList()) {
							if (childNode.getTagName().equals(childName)) {
								childNode.setTagName(tagNmaetoBeUpdated);
								return true;
							}
						}
					}
				}
			}
		}
		return false;

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.tool.reportmaker.interfaces.WorkFlowManagerInterface#
	 * loadTagNamesController(java.lang.String, java.lang.String, int)
	 */
	@Override
	public ArrayList<String> loadTagNamesController(String parentName, String workFlowName, int origin) {

		ArrayList<String> values = new ArrayList<String>();
		System.out.println("dsfasdfsad");
		switch (origin) {
		case 1:
			values = loadWorkFlowTagName();
			break;

		case 2:
			values = loadParentTagName(workFlowName);
			break;

		case 3:
			values = loadChildTagName(parentName, workFlowName);
			break;

		default:
			break;
		}

		return values;

	}

	/**
	 * Load work flow tag name.
	 *
	 * @return the array list
	 */
	private ArrayList<String> loadWorkFlowTagName() {
		final ArrayList<String> workFlows = new ArrayList<String>();

		for (final WorkFlow workFlow : dataManagerObject.getWorkFlowManager().getWorkFlowList()) {
			workFlows.add(workFlow.getWorkFlowName());
		}

		return workFlows;

	}

	/**
	 * Load parent tag name.
	 *
	 * @param WorkFlowTagName
	 *            the work flow tag name
	 * @return the array list
	 */
	private ArrayList<String> loadParentTagName(String WorkFlowTagName) {
		final ArrayList<String> parentNames = new ArrayList<String>();

		if (WorkFlowTagName != null) {
			for (final WorkFlow workFlow : dataManagerObject.getWorkFlowManager().getWorkFlowList()) {
				if (workFlow.getWorkFlowName().equals(WorkFlowTagName)) {
					for (final ParentNode parentNode : workFlow.getParentNodeList()) {
						parentNames.add(parentNode.getParentNodeName());
					}
				}
			}
		}
		System.out.println("Paprent names " + parentNames.size());
		return parentNames;

	}

	/**
	 * Load child tag name.
	 *
	 * @param parentTagName
	 *            the parent tag name
	 * @param WorkFlowTagName
	 *            the work flow tag name
	 * @return the array list
	 */
	private ArrayList<String> loadChildTagName(String parentTagName, String WorkFlowTagName) {
		final ArrayList<String> childNames = new ArrayList<String>();
		if ((parentTagName != null) && (WorkFlowTagName != null)) {
			for (final WorkFlow workFlow : dataManagerObject.getWorkFlowManager().getWorkFlowList()) {
				if (workFlow.getWorkFlowName().equals(WorkFlowTagName)) {
					for (final ParentNode parentNode : workFlow.getParentNodeList()) {
						if (parentNode.getParentNodeName().equals(parentTagName)) {
							for (final ChildNode childNode : parentNode.getChildNodeList()) {
								childNames.add(childNode.getTagName());
							}
						}
					}
				}
			}
		}
		return childNames;

	}

	/**
	 * Instantiates a new work flow manager dao.
	 */
	public WorkFlowManagerDao() {
		super();
		if (dataManagerObject == null) {
			dataManagerObject = new DataManagerObject();
			dataManagerObject.setSaved(true);
			System.out.println("dataManagerObject created : " + dataManagerObject.toString());
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.tool.reportmaker.interfaces.WorkFlowManagerInterface#
	 * createNewWorkFlowObject()
	 */
	@Override
	public void createNewWorkFlowObject() {
		dataManagerObject = null;
		dataManagerObject = new DataManagerObject();
		dataManagerObject.setSaved(true);
		System.out.println("dataManagerObject created111 : " + dataManagerObject.toString());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.tool.reportmaker.interfaces.WorkFlowManagerInterface#createWorkflow()
	 */
	@Override
	public DataManagerObject createWorkflow() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.tool.reportmaker.interfaces.WorkFlowManagerInterface#
	 * serializeWorkFlowDiagram(java.lang.String, java.io.File)
	 */
	@Override
	public void serializeWorkFlowDiagram(String dataMagagerObjectName, File file) throws IOException {

		dataManagerObject.setDataManagerObjectName(dataMagagerObjectName);
		dataManagerObject.setFileLocation(file);
		dataManagerObject.setSaved(true);
		util.serializeWorkFlowDiagram(dataManagerObject, file);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.tool.reportmaker.interfaces.WorkFlowManagerInterface#
	 * deSerializeWorkFlowDiagram(java.io.File)
	 */
	@Override
	public DataManagerObject deSerializeWorkFlowDiagram(File file)
			throws ClassNotFoundException, IOException, StreamCorruptedException {
		if ((dataManagerObject != null)) {
			dataManagerObject = null;
			dataManagerObject = util.deserialzeWorkFlowDiagram(file);
			System.out.println("dataManagerObject fetchewd : " + dataManagerObject.toString());
		}
		return dataManagerObject;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.tool.reportmaker.interfaces.WorkFlowManagerInterface#
	 * insertDataIntoChildNode(java.lang.String[], java.util.ArrayList,
	 * java.io.File)
	 */
	@Override
	public boolean insertDataIntoChildNode(String selectedValueFromJtree[], ArrayList<String> valuesTobeInserted,
			File fileToBeSaved) throws IOException {

		final boolean result = false;
		for (final WorkFlow workFlow : dataManagerObject.getWorkFlowManager().getWorkFlowList()) {
			if (workFlow.getWorkFlowName().equals(selectedValueFromJtree[0])) {
				for (final ParentNode parentNode : workFlow.getParentNodeList()) {
					if (parentNode.getParentNodeName().equals(selectedValueFromJtree[1])) {
						for (final ChildNode childNode : parentNode.getChildNodeList()) {
							if (childNode.getTagName().equals(selectedValueFromJtree[2])) {
								childNode.setValues(valuesTobeInserted);
								serializeWorkFlowDiagram(dataManagerObject.getDataManagerObjectName(), fileToBeSaved);
								return true;
							}
						}
					}
				}
			}
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.tool.reportmaker.interfaces.WorkFlowManagerInterface#
	 * appendDataIntoChildNode(java.lang.String[], java.util.ArrayList,
	 * java.io.File)
	 */
	@Override
	public boolean appendDataIntoChildNode(String selectedValueFromJtree[], ArrayList<String> valuesTobeInserted,
			File fileToBeSaved) throws IOException {
		final boolean result = false;
		for (final WorkFlow workFlow : dataManagerObject.getWorkFlowManager().getWorkFlowList()) {
			if (workFlow.getWorkFlowName().equals(selectedValueFromJtree[0])) {
				for (final ParentNode parentNode : workFlow.getParentNodeList()) {
					if (parentNode.getParentNodeName().equals(selectedValueFromJtree[1])) {
						for (final ChildNode childNode : parentNode.getChildNodeList()) {
							if (childNode.getTagName().equals(selectedValueFromJtree[2])) {
								final ArrayList<String> childValues = childNode.getValues();
								childValues.addAll(valuesTobeInserted);
								serializeWorkFlowDiagram(dataManagerObject.getDataManagerObjectName(), fileToBeSaved);
								return true;
							}
						}
					}
				}
			}
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.tool.reportmaker.interfaces.WorkFlowManagerInterface#
	 * fetchValuesFromChildNode(java.lang.String[])
	 */
	@Override
	public ArrayList<String> fetchValuesFromChildNode(String selectedValueFromJtree[]) {

		for (final WorkFlow workFlow : dataManagerObject.getWorkFlowManager().getWorkFlowList()) {
			if (workFlow.getWorkFlowName().equals(selectedValueFromJtree[0])) {
				for (final ParentNode parentNode : workFlow.getParentNodeList()) {
					if (parentNode.getParentNodeName().equals(selectedValueFromJtree[1])) {
						for (final ChildNode childNode : parentNode.getChildNodeList()) {
							if (childNode.getTagName().equals(selectedValueFromJtree[2])) {
								return childNode.getValues();
							}
						}
					}
				}
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.tool.reportmaker.interfaces.WorkFlowManagerInterface#
	 * deleteValuesFromChildNode(java.lang.String[], java.util.ArrayList,
	 * java.io.File)
	 */
	@Override
	public boolean deleteValuesFromChildNode(String selectedValueFromJtree[], ArrayList<String> valuesTobeInserted,
			File fileToBeSaved) throws IOException {
		final boolean result = false;
		for (final WorkFlow workFlow : dataManagerObject.getWorkFlowManager().getWorkFlowList()) {
			if (workFlow.getWorkFlowName().equals(selectedValueFromJtree[0])) {
				for (final ParentNode parentNode : workFlow.getParentNodeList()) {
					if (parentNode.getParentNodeName().equals(selectedValueFromJtree[1])) {
						for (final ChildNode childNode : parentNode.getChildNodeList()) {
							if (childNode.getTagName().equals(selectedValueFromJtree[2])) {
								childNode.getValues().clear();
								serializeWorkFlowDiagram(dataManagerObject.getDataManagerObjectName(), fileToBeSaved);
								return true;
							}
						}
					}
				}
			}
		}

		return result;

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.tool.reportmaker.interfaces.WorkFlowManagerInterface#
	 * buildJTableController(java.lang.String[], java.util.ArrayList)
	 */
	@Override
	public DefaultTableModel buildJTableController(String selectedValueFromJtree[], ArrayList<String> totvalues) {
		final DefaultTableModel model = new DefaultTableModel();

		switch (selectedValueFromJtree.length) {
		case 2:
			buildJTable(getChildNodesFromParentNodes(selectedValueFromJtree), model, totvalues);
			break;
		case 3:

			buildJTable(getChildNodesFromChildNodeName(selectedValueFromJtree), model, totvalues);
			break;
		default:
			break;
		}
		return model;
	}

	/**
	 * Builds the j table.
	 *
	 * @param arrChildNode
	 *            the arr child node
	 * @param model
	 *            the model
	 * @param totvalues
	 *            the totvalues
	 */
	private void buildJTable(ArrayList<ChildNode> arrChildNode, DefaultTableModel model, ArrayList<String> totvalues) {
		buildJTableColoums(model, arrChildNode);
		ArrayList<String> arrString = null;
		for (int index = 0; index < util.findMaximumArraySize(arrChildNode); index++) {
			arrString = new ArrayList<String>();
			for (final ChildNode childNode : arrChildNode) {
				if (childNode.getValues().size() > index) {
					arrString.add(childNode.getValues().get(index));
				} else {
					arrString.add("");
				}
			}

			buildJTableRows(arrString, model);
			calculateTotalValuesForParentNode(arrString, totvalues);
		}

	}

	/**
	 * Builds the j table rows.
	 *
	 * @param arrString
	 *            the arr string
	 * @param model
	 *            the model
	 */
	private void buildJTableRows(ArrayList<String> arrString, DefaultTableModel model) {
		model.addRow(arrString.toArray());
	}

	/**
	 * Builds the j table coloums.
	 *
	 * @param model
	 *            the model
	 * @param arrChildNode
	 *            the arr child node
	 */
	private void buildJTableColoums(DefaultTableModel model, ArrayList<ChildNode> arrChildNode) {
		for (final ChildNode childNode : arrChildNode) {
			model.addColumn(childNode.getTagName());
		}
	}

	/**
	 * Gets the child nodes from parent nodes.
	 *
	 * @param selectedValueFromJtree
	 *            the selected value from jtree
	 * @return the child nodes from parent nodes
	 */
	private ArrayList<ChildNode> getChildNodesFromParentNodes(String selectedValueFromJtree[]) {
		for (final WorkFlow workFlow : dataManagerObject.getWorkFlowManager().getWorkFlowList()) {
			if (workFlow.getWorkFlowName().equals(selectedValueFromJtree[0])) {
				for (final ParentNode parentNode : workFlow.getParentNodeList()) {
					if (parentNode.getParentNodeName().equals(selectedValueFromJtree[1])) {
						return parentNode.getChildNodeList();
					}
				}
			}
		}
		return null;
	}

	/**
	 * Gets the child nodes from child node name.
	 *
	 * @param selectedValueFromJtree
	 *            the selected value from jtree
	 * @return the child nodes from child node name
	 */
	private ArrayList<ChildNode> getChildNodesFromChildNodeName(String selectedValueFromJtree[]) {
		ArrayList<ChildNode> arrChildNode = null;
		for (final WorkFlow workFlow : dataManagerObject.getWorkFlowManager().getWorkFlowList()) {
			if (workFlow.getWorkFlowName().equals(selectedValueFromJtree[0])) {
				for (final ParentNode parentNode : workFlow.getParentNodeList()) {
					if (parentNode.getParentNodeName().equals(selectedValueFromJtree[1])) {
						for (final ChildNode childNode : parentNode.getChildNodeList()) {
							if (childNode.getTagName().equals(selectedValueFromJtree[2])) {
								arrChildNode = new ArrayList<ChildNode>();
								arrChildNode.add(childNode);
								return arrChildNode;
							}
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * Calculate total values for parent node.
	 *
	 * @param arrString
	 *            the arr string
	 * @param totValues
	 *            the tot values
	 */
	private void calculateTotalValuesForParentNode(ArrayList<String> arrString, ArrayList<String> totValues) {
		int count = 0;
		for (final String str : arrString) {
			if (!str.equals("")) {
				count += Integer.parseInt(str.replaceAll("[\\D]", ""));
			}
		}
		totValues.add("" + count);

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.tool.reportmaker.interfaces.WorkFlowManagerInterface#
	 * clearAllDataFromWorkflow()
	 */
	@Override
	public void clearAllDataFromWorkflow() {

		for (final WorkFlow workFlow : dataManagerObject.getWorkFlowManager().getWorkFlowList()) {
			for (final ParentNode parentNode : workFlow.getParentNodeList()) {
				for (final ChildNode childNode : parentNode.getChildNodeList()) {
					childNode.setValues(null);
				}
			}
		}
	}

}
