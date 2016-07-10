/*
 * ********************************************************
 * OmniKey : A Workflow Driven Smart Data Extraction Tool *
 * ********************************************************
 * 
 * @Package 	:	com.tool.reportmaker.interfaces	
 * @File 	  	: 	WorkFlowConstants.java
 * @Created  	: 	07-10-2016(mm-dd-yyyy)
 * @Version		:	2.1.0
 * @Author     	: 	Dipanjan Bera Copyright (2016)
 * @Email		:	dipanjan033@gmail.com
 * 
 */
package com.tool.reportmaker.interfaces;

// TODO: Auto-generated Javadoc
/**
 * The Interface WorkFlowConstants.
 */
public interface WorkFlowConstants extends AppConstants {

		/** The exit conformatoin txt. */
		public String EXIT_CONFORMATOIN_TXT = "Modified Workflow not saved yet , Are you sure to Exit";
		
		/** The exit conformatoin header. */
		public String EXIT_CONFORMATOIN_HEADER = "Confirm Exit";
	
		/**
		 * The Interface DataImportDialogBoxConstants.
		 */
		public interface DataImportDialogBoxConstants{
			
			/** The data import dialog title. */
			String DATA_IMPORT_DIALOG_TITLE = "Import Data";
			
			/** The child node not selected error. */
			String CHILD_NODE_NOT_SELECTED_ERROR = "Please Select child node to Import Data";
			
			/** The data import successful. */
			String DATA_IMPORT_SUCCESSFUL = "Data Imported Successfully";
			
			/** The data delete successfull. */
			String DATA_DELETE_SUCCESSFULL = "Data Deleted Successfully";
			
			/** The no workflow imported error. */
			String NO_WORKFLOW_IMPORTED_ERROR = "No Workflow found to import data";
			
			/** The data import dialog box open error msg. */
			String DATA_IMPORT_DIALOG_BOX_OPEN_ERROR_MSG = "Please precess data to be imported in Workflow";
			
			/**
			 * The Interface deleteConfirmConstants.
			 */
			public interface deleteConfirmConstants{
				
				/** The confirm text. */
				String CONFIRM_TEXT = "Would You Like to Delete All Values From This Node?";
				
				/** The confirm box title. */
				String CONFIRM_BOX_TITLE = "All Data Will be Lost";
				
				/** The delete conformation msg. */
				String DELETE_CONFORMATION_MSG = "Are you Sure to Continue with this Delete Operation";
				
				/** The delete conformation header. */
				String DELETE_CONFORMATION_HEADER = "Please Confirm";
			}
			
			
			
		}
	
}
