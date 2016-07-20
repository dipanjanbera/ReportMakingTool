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

// TODO: Auto-generated Javadoc
/**
 * The Interface AppConstants.
 */
public interface AppConstants {

	/** The appname. */
	String APPNAME = "OmniKey";
	
	/** The version. */
	String VERSION = "v2.1.0"; 
	

	/** The initial text on footer. */
	String INITIAL_TEXT_ON_FOOTER = "After coping Omniture data click on Generate button";

	/** The break point default value. */
	String BREAK_POINT_DEFAULT_VALUE = "24";

	/** The default coloum index. */
	int DEFAULT_COLOUM_INDEX = 1;

	/**
	 * The Interface DialogBoxHeader.
	 */
	public interface DialogBoxHeader{
		
		/** The about footer. */
		String ABOUT_FOOTER = APPNAME+" "+VERSION+" || Designed and Developed By Dipanjan Bera";
		
		/** The workflow manager. */
		String WORKFLOW_MANAGER = APPNAME+" | WorkFlow Manager";
		
		/** The data manager. */
		String DATA_MANAGER = APPNAME+" | Data Manager";
		
		/** The extract data. */
		String EXTRACT_DATA = APPNAME+" | Extract Data";
		
		/** The import data. */
		String IMPORT_DATA = APPNAME+" | Import Data";
		
		/** The keyboard shortcut. */
		String KEYBOARD_SHORTCUT = APPNAME+" | Keyboard Shortcut List";
	}
	
	
	/**
	 * The Interface DialogBoxVerbage.
	 */
	public interface DialogBoxVerbage {

		/** The clear text confirm. */
		String clearTextConfirm = "Are You Sure to Clear Input Text ?";

		/** The error status. */
		String errorStatus = "ERROR !! \nPlease Try Again.  ";

		/** The error status for invalid input. */
		String errorStatusForInvalidInput = "Input Text is not in Correct Format !! ";

		/** The error status for empty input. */
		String errorStatusForEmptyInput = "Error !! \nPlease Enter Input Text";

		/** The error status no coloum no. */
		String errorStatusNoColoumNo = "Error !! \nPlease Enter Coloum No";

	}
	
	/**
	 * The Interface QuickGuideVerbage.
	 */
	public interface QuickGuideVerbage{
		
		
		
		/**
		 * The Interface QuickGuideHeaderVerbage.
		 */
		public interface QuickGuideHeaderVerbage{
			
			/** The data extractor. */
			String DATA_EXTRACTOR = "Extact Data from Webpage";
			
			/** The data manager. */
			String DATA_MANAGER = "Manage Extracted Data";
			
			/** The create workflow. */
			String CREATE_WORKFLOW = "Create / Update Workflow";
		}
		
		/**
		 * The Interface QuickGuideContentVerbage.
		 */
		public interface QuickGuideContentVerbage{
			
			/** The data extractor. */
			String DATA_EXTRACTOR = "Extract Data from Keynote / Omniture Website with a Click . Also it allows you to import extacted data into exisiting Workflow Tags.";
			
			/** The data manager. */
			String DATA_MANAGER = "This will prepare ready to paste data into Keynote / Omniture report from Workflow. You can select parent Node / Child Node from Workflow for which report will be prepared.";
			
			/** The create workflow. */
			String CREATE_WORKFLOW = "This allows you to create / update / delate / Save a workflow. A workflow is a high level view of your report, which organised and showcased reporting tags in visual format";
		}
		
		
	}

}
