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
package com.tool.reportmaker.eventListener;

import com.tool.reportmaker.exception.WorkFlowTreeDrawingFailedException;

/**
 * The listener interface for receiving workflowTreeEvent events. The class that
 * is interested in processing a workflowTreeEvent event implements this
 * interface, and the object created with that class is registered with a
 * component using the component's <code>addWorkflowTreeEventListener
 * <code> method. When the workflowTreeEvent event occurs, that object's
 * appropriate method is invoked.
 *
 * @see WorkflowTreeEventEvent
 */
public interface WorkflowTreeEventListener {

	/**
	 * On workflow tree drawing start.
	 */
	public void onWorkflowTreeDrawingStart();

	/**
	 * On workflow tree drawing complete.
	 */
	public void onWorkflowTreeDrawingComplete();

	/**
	 * On workflow tree drawing failed.
	 *
	 * @throws WorkFlowTreeDrawingFailedException
	 *             the work flow tree drawing failed exception
	 */
	public void onWorkflowTreeDrawingFailed() throws WorkFlowTreeDrawingFailedException;

}
