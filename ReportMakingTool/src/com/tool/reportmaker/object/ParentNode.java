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
 * The Class ParentNode.
 */
public class ParentNode implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The child node list. */
	private ArrayList<ChildNode> childNodeList = new ArrayList<ChildNode>();
	
	/** The is parent node. */
	private boolean isParentNode;
	
	/** The creation date time. */
	private String creationDateTime;
	
	/** The parent node name. */
	private String parentNodeName;

	

	/**
	 * Gets the parent node name.
	 *
	 * @return the parent node name
	 */
	public String getParentNodeName() {
		return parentNodeName;
	}

	/**
	 * Sets the parent node name.
	 *
	 * @param parentNodeName
	 *            the new parent node name
	 */
	public void setParentNodeName(String parentNodeName) {
		this.parentNodeName = parentNodeName;
	}

	/**
	 * Instantiates a new parent node.
	 *
	 * @param childNodeList
	 *            the child node list
	 * @param isParentNode
	 *            the is parent node
	 * @param creationDateTime
	 *            the creation date time
	 * @param parentNodeName
	 *            the parent node name
	 */
	public ParentNode(ArrayList<ChildNode> childNodeList, boolean isParentNode, String creationDateTime,
			String parentNodeName) {
		super();
		this.childNodeList = childNodeList;
		this.isParentNode = isParentNode;
		this.creationDateTime = creationDateTime;
		this.parentNodeName = parentNodeName;
	}

	/**
	 * Instantiates a new parent node.
	 */
	public ParentNode() {
		super();
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ParentNode [childNodeList=" + childNodeList + ", isParentNode=" + isParentNode + ", creationDateTime="
				+ creationDateTime + ", parentNodeName=" + parentNodeName + "]";
	}

	/**
	 * Gets the child node list.
	 *
	 * @return the child node list
	 */
	public ArrayList<ChildNode> getChildNodeList() {
		return childNodeList;
	}

	/**
	 * Sets the child node list.
	 *
	 * @param childNodeList
	 *            the new child node list
	 */
	public void setChildNodeList(ArrayList<ChildNode> childNodeList) {
		this.childNodeList = childNodeList;
	}

	/**
	 * Checks if is parent node.
	 *
	 * @return true, if is parent node
	 */
	public boolean isParentNode() {
		return isParentNode;
	}

	/**
	 * Sets the parent node.
	 *
	 * @param isParentNode
	 *            the new parent node
	 */
	public void setParentNode(boolean isParentNode) {
		this.isParentNode = isParentNode;
	}

	/**
	 * Gets the creation date time.
	 *
	 * @return the creation date time
	 */
	public String getCreationDateTime() {
		return creationDateTime;
	}

	/**
	 * Sets the creation date time.
	 *
	 * @param creationDateTime
	 *            the new creation date time
	 */
	public void setCreationDateTime(String creationDateTime) {
		this.creationDateTime = creationDateTime;
	}

}
