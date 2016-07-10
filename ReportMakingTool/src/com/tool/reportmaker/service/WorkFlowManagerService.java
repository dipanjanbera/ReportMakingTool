/*
 * ********************************************************
 * OmniKey : A Workflow Driven Smart Data Extraction Tool *
 * ********************************************************
 * 
 * @Package 	:	com.tool.reportmaker.service	
 * @File 	  	: 	WorkFlowManagerService.java
 * @Created  	: 	07-10-2016(mm-dd-yyyy)
 * @Version		:	2.1.0
 * @Author     	: 	Dipanjan Bera Copyright (2016)
 * @Email		:	dipanjan033@gmail.com
 * 
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

	/* (non-Javadoc)
	 * @see com.tool.reportmaker.interfaces.WorkFlowManagerInterface#createWorkflow()
	 */
	@Override
	public DataManagerObject createWorkflow() throws WorkFlowValidationException, WorkFlowDuplicateElementException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.tool.reportmaker.interfaces.WorkFlowManagerInterface#createWorkflow(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public DataManagerObject createWorkflow(String workFlowName, String parentName, String childName)
			throws WorkFlowValidationException, WorkFlowDuplicateElementException {
		DataManagerObject dataManagerObject = workFlowManagerDao.createWorkflow(workFlowName, parentName, childName);
		
		return dataManagerObject;
	}

	/* (non-Javadoc)
	 * @see com.tool.reportmaker.interfaces.WorkFlowManagerInterface#createWorkFlowTree()
	 */
	@Override
	public DefaultMutableTreeNode createWorkFlowTree() throws WorkFlowTreeDrawingFailedException {
		DefaultMutableTreeNode treeNode = workFlowManagerDao.createWorkFlowTree();
		return treeNode;
	}

	/* (non-Javadoc)
	 * @see com.tool.reportmaker.interfaces.WorkFlowManagerInterface#deleteNodeController(java.lang.String[])
	 */
	@Override
	public boolean deleteNodeController(String[] seletedValueToBeDeleted) {

		return workFlowManagerDao.deleteNodeController(seletedValueToBeDeleted);
	}

	/* (non-Javadoc)
	 * @see com.tool.reportmaker.interfaces.WorkFlowManagerInterface#updateNodeController(java.lang.String[], java.lang.String)
	 */
	@Override
	public boolean updateNodeController(String[] seletedValueToBeUpdated, String tagNmaetoBeUpdated) {

		return workFlowManagerDao.updateNodeController(seletedValueToBeUpdated, tagNmaetoBeUpdated);
	}

	/* (non-Javadoc)
	 * @see com.tool.reportmaker.interfaces.WorkFlowManagerInterface#loadTagNamesController(java.lang.String, java.lang.String, int)
	 */
	@Override
	public ArrayList<String> loadTagNamesController(String parentName, String workFlowName, int origin) {
		System.out.println("sdfasdf");
		return workFlowManagerDao.loadTagNamesController(parentName, workFlowName, origin);
	}

	/* (non-Javadoc)
	 * @see com.tool.reportmaker.interfaces.WorkFlowManagerInterface#serializeWorkFlowDiagram(java.lang.String, java.io.File)
	 */
	@Override
	public void serializeWorkFlowDiagram(String dataManagerObjectName , File file) throws IOException  {
		workFlowManagerDao.serializeWorkFlowDiagram(dataManagerObjectName,file);
		
	}

	/* (non-Javadoc)
	 * @see com.tool.reportmaker.interfaces.WorkFlowManagerInterface#deSerializeWorkFlowDiagram(java.io.File)
	 */
	@Override
	public DataManagerObject deSerializeWorkFlowDiagram(File file) throws ClassNotFoundException, IOException,StreamCorruptedException {
		return workFlowManagerDao.deSerializeWorkFlowDiagram(file);
		
	}

	/* (non-Javadoc)
	 * @see com.tool.reportmaker.interfaces.WorkFlowManagerInterface#fetchValuesFromChildNode(java.lang.String[])
	 */
	@Override
	public ArrayList<String> fetchValuesFromChildNode(String[] selectedValueFromJtree) {
		
		return workFlowManagerDao.fetchValuesFromChildNode(selectedValueFromJtree);
	}

	/* (non-Javadoc)
	 * @see com.tool.reportmaker.interfaces.WorkFlowManagerInterface#insertDataIntoChildNode(java.lang.String[], java.util.ArrayList, java.io.File)
	 */
	@Override
	public boolean insertDataIntoChildNode(String[] selectedValueFromJtree,ArrayList<String> valuesTobeInserted,File fileToBeSaved)throws IOException {
		
		return workFlowManagerDao.insertDataIntoChildNode(selectedValueFromJtree, valuesTobeInserted,fileToBeSaved);
	}

	/* (non-Javadoc)
	 * @see com.tool.reportmaker.interfaces.WorkFlowManagerInterface#appendDataIntoChildNode(java.lang.String[], java.util.ArrayList, java.io.File)
	 */
	@Override
	public boolean appendDataIntoChildNode(String[] selectedValueFromJtree,ArrayList<String> valuesTobeInserted, File fileToBeSaved)throws IOException {
		
		return workFlowManagerDao.appendDataIntoChildNode(selectedValueFromJtree, valuesTobeInserted, fileToBeSaved);
	}

	/* (non-Javadoc)
	 * @see com.tool.reportmaker.interfaces.WorkFlowManagerInterface#deleteValuesFromChildNode(java.lang.String[], java.util.ArrayList, java.io.File)
	 */
	@Override
	public boolean deleteValuesFromChildNode(String[] selectedValueFromJtree, ArrayList<String> valuesTobeInserted,
			File fileToBeSaved) throws IOException {
		
		return workFlowManagerDao.deleteValuesFromChildNode(selectedValueFromJtree, valuesTobeInserted, fileToBeSaved);
	}

	/* (non-Javadoc)
	 * @see com.tool.reportmaker.interfaces.WorkFlowManagerInterface#buildJTableController(java.lang.String[], java.util.ArrayList)
	 */
	@Override
	public DefaultTableModel buildJTableController(String selectedValueFromJtree[],ArrayList<String> totvalues) {
		// TODO Auto-generated method stub
		return workFlowManagerDao.buildJTableController(selectedValueFromJtree,totvalues);
	}

	/* (non-Javadoc)
	 * @see com.tool.reportmaker.interfaces.WorkFlowManagerInterface#getDataManagerObject()
	 */
	@Override
	public DataManagerObject getDataManagerObject() {
		// TODO Auto-generated method stub
		return workFlowManagerDao.getDataManagerObject();
	}
	
	

}
