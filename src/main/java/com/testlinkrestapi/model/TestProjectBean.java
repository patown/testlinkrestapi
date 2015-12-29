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
public class TestProjectBean implements Serializable {

    private static final long serialVersionUID = 3030116951146834578L;
  
    private String id;
    private String name;
    private String color;
    private String prefix;
    private Boolean isActive;
    private Boolean isPublic;
	private String notes;
    public String getNotes() {
		return notes;
	}



	private Options options;

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getColor() {
		return color;
	}

	public String getPrefix() {
		return prefix;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public Boolean getIsPublic() {
		return isPublic;
	}

	public Options getOptions() {
		return options;
	}

	public TestProjectBean setId(String id) {
		this.id = id;
		return this;
	}

	public TestProjectBean setName(String name) {
		this.name = name;
		return this;
	}

	public TestProjectBean setColor(String color) {
		this.color = color;
		return this;
	}

	public TestProjectBean setPrefix(String prefix) {
		this.prefix = prefix;
		return this;
	}

	public TestProjectBean setIsActive(Boolean isActive) {
		this.isActive = isActive;
		return this;
	}

	public TestProjectBean setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
		return this;
	}
	public TestProjectBean setNotes(String notes) {
		this.notes = notes;
		return this;
	}
	public TestProjectBean setOptions(Options options) {
		this.options = options;
		return this;
	}
	
/*{"name":"FrenchToJD(month, day, year)",
 * "notes":"This is a FrenchToJD",
 * "color":"",
 * "prefix":"FTJD",
 * "active":1,
 * "is_public":1,
 * "options":
 * {	"requirementsEnabled":0,
 * 		"testPriorityEnabled":1,
 * 		"automationEnabled":1,
 * 		"inventoryEnabled":0
 * }
 * }	
 */

	
}
