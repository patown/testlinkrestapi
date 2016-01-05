/*
 * The MIT License
 *
 * Copyright (c) <2010> <Bruno P. Kinoshita>
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.testlinkrestapi.model;

import java.io.Serializable;

/**
 * @author Antony Chen
 * @since 1.9.14
 */
public class TestSuiteBean implements Serializable {

    private static final long serialVersionUID = 3030116951146834578L;
    
    private Integer id;
    private String name;
    private Integer testProjectID;
    private String notes;
    private Integer parentID;
    private Integer order;



    /**
	 * 
	 */
    public TestSuiteBean() {
	super();
    }


    /**
     * @return the id
     */
    public Integer getId() {
	return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public TestSuiteBean setId(Integer id) {
	this.id = id;
	return this;
    }

    /**
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public TestSuiteBean setName(String name) {
	this.name = name;
	return this;
    }

    /**
     * @return the testProjectID
     */
    public Integer getTestProjectID() {
	return testProjectID;
    }

    /**
     * @param testprojectID
     *            the testprojectID to set
     */
    public TestSuiteBean setTestProjectID(Integer testprojectID) {
	this.testProjectID = testprojectID;
	return this;
    }

    /**
     * @return the notes
     */
    public String getNotes() {
	return notes;
    }

    /**
     * @param notes
     *            the notes to set
     */
    public TestSuiteBean setNotes(String notes) {
	this.notes = notes;
	return this;
    }

    /**
     * @return the parentID
     */
	public Integer getParentID() {
		return parentID;
	}


	public TestSuiteBean setParentID(Integer parentID) {
		this.parentID = parentID;
		return this;
	}

    /**
     * @return the order
     */
	public Integer getOrder() {
		return order;
	}


	public TestSuiteBean setOrder(Integer order) {
		this.order = order;
		return this;
	}


}
