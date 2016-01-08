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
public class TestCaseBean implements Serializable {

    private static final long serialVersionUID = 3030116951146834578L;
    
    private Integer id;
    private String name;
    private Integer testSuite;
    private Integer testProject;
    private String summary;
    private String preconditions;
    private Integer order;
    private Integer authorID;
    private Integer importance ;
    private Integer executionType;
    

    /**
	 * 
	 */
    public TestCaseBean() {
	super();
    }


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Integer getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public Integer getTestSuite() {
		return testSuite;
	}


	public Integer getTestProject() {
		return testProject;
	}


	public String getSummary() {
		return summary;
	}


	public String getPreconditions() {
		return preconditions;
	}


	public Integer getOrder() {
		return order;
	}


	public Integer getAuthorID() {
		return authorID;
	}


	public Integer getImportance() {
		return importance;
	}


	public Integer getExecutionType() {
		return executionType;
	}


	public TestCaseBean setId(Integer id) {
		this.id = id;
		return this;
	}


	public TestCaseBean setName(String name) {
		this.name = name;
		return this;
	}


	public TestCaseBean setTestSuite(Integer testSuiteID) {
		this.testSuite = testSuiteID;
		return this;
	}


	public TestCaseBean setTestProject(Integer testproject) {
		this.testProject = testproject;
		return this;
	}


	public TestCaseBean setSummary(String summary) {
		this.summary = summary;
		return this;
	}


	public TestCaseBean setPreconditions(String preconditions) {
		this.preconditions = preconditions;
		return this;
	}


	public TestCaseBean setOrder(Integer order) {
		this.order = order;
		return this;
	}


	public TestCaseBean setAuthorID(Integer authorID) {
		this.authorID = authorID;
		return this;
	}


	public TestCaseBean setImportance(Integer importance) {
		this.importance = importance;
		return this;
	}


	public TestCaseBean setExecutionType(Integer executionType) {
		this.executionType = executionType;
		return this;
	}


}
