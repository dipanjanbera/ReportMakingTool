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
 * The Class ChildNode.
 */
public class ChildNode implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The values. */
	private ArrayList<String> values = new ArrayList<String>();

	/** The tag name. */
	private String tagName;

	/** The is childnode. */
	private boolean isChildnode;

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ChildNode [values=" + values + ", tagName=" + tagName + ", isChildnode=" + isChildnode + "]";
	}

	/**
	 * Instantiates a new child node.
	 */
	public ChildNode() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Gets the values.
	 *
	 * @return the values
	 */
	public ArrayList<String> getValues() {
		return values;
	}

	/**
	 * Sets the values.
	 *
	 * @param values
	 *            the new values
	 */
	public void setValues(ArrayList<String> values) {
		this.values = values;
	}

	/**
	 * Gets the tag name.
	 *
	 * @return the tag name
	 */
	public String getTagName() {
		return tagName;
	}

	/**
	 * Sets the tag name.
	 *
	 * @param tagName
	 *            the new tag name
	 */
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	/**
	 * Checks if is childnode.
	 *
	 * @return true, if is childnode
	 */
	public boolean isChildnode() {
		return isChildnode;
	}

	/**
	 * Sets the childnode.
	 *
	 * @param isChildnode
	 *            the new childnode
	 */
	public void setChildnode(boolean isChildnode) {
		this.isChildnode = isChildnode;
	}

	/**
	 * Instantiates a new child node.
	 *
	 * @param values
	 *            the values
	 * @param tagName
	 *            the tag name
	 * @param isChildnode
	 *            the is childnode
	 */
	public ChildNode(ArrayList<String> values, String tagName, boolean isChildnode) {
		super();
		this.values = values;
		this.tagName = tagName;
		this.isChildnode = isChildnode;
	}

}
