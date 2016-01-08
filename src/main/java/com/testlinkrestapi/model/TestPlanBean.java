/*
 * The MIT License
 *
 * Copyright (c) <2015> <Antony Chen>
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
public class TestPlanBean implements Serializable {

    private static final long serialVersionUID = 3030116951146834578L;
    
    private Integer id;
    private String name;
    private Integer testprojectID;
    private String notes;
    private Boolean isActive;
    private Boolean isPublic;
    

    /**
	 * 
	 */
    public TestPlanBean() {
	super();
    }

    /**
     * @param id
     * @param name
     * @param projectName
     * @param notes
     * @param isActive
     * @param isPublic
     */
    public TestPlanBean(Integer id, String name, Integer testprojectID, String notes,
	    Boolean isActive, Boolean isPublic) {
	super();
	this.id = id;
	this.name = name;
	this.testprojectID = testprojectID;
	this.notes = notes;
	this.isActive = isActive;
	this.isPublic = isPublic;
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
    public TestPlanBean setId(Integer id) {
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
    public TestPlanBean setName(String name) {
	this.name = name;
	return this;
    }

    /**
     * @return the testprojectID
     */
    public Integer getTestprojectID() {
	return testprojectID;
    }

    /**
     * @param testprojectID
     *            the testprojectID to set
     */
    public TestPlanBean setTestrojectID(Integer testprojectID) {
	this.testprojectID = testprojectID;
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
    public TestPlanBean setNotes(String notes) {
	this.notes = notes;
	return this;
    }

    /**
     * @return the isActive
     */
    public Boolean getIsActive() {
	return isActive;
    }

    /**
     * @param isActive
     *            the isActive to set
     */
    public TestPlanBean setIsActive(Boolean isActive) {
	this.isActive = isActive;
	return this;
    }

    /**
     * @return the isPublic
     */
    public Boolean getIsPublic() {
	return isPublic;
    }

    /**
     * @param isPublic
     *            the isPublic to set
     */
    public TestPlanBean setIsPublic(Boolean isPublic) {
	this.isPublic = isPublic;
	return this;
    }

//    /*
//     * (non-Javadoc)
//     * 
//     * @see java.lang.Object#toString()
//     */
//    @Override
//    public String toString() {
//	return "{id=" + id + ", name=" + name + ", projectName="
//		+ projectID + ", notes=" + notes + ", isActive=" + isActive
//		+ ", isPublic=" + isPublic + "}";
//    }

}
