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
 *   {	"requirementsEnabled":0,
 * 		"testPriorityEnabled":1,
 * 		"automationEnabled":1,
 * 		"inventoryEnabled":0
 * }
 */
public class Options  implements Serializable {

    private static final long serialVersionUID = 3030116951146834578L;
  
	Integer requirementsEnabled;
	Integer testPriorityEnabled;
	Integer automationEnabled;
	Integer inventoryEnabled;
	public Integer getRequirementsEnabled() {
		return requirementsEnabled;
	}
	public Integer getTestPriorityEnabled() {
		return testPriorityEnabled;
	}
	public Integer getAutomationEnabled() {
		return automationEnabled;
	}
	public Integer getInventoryEnabled() {
		return inventoryEnabled;
	}
	public Options setRequirementsEnabled(Integer requirementsEnabled) {
		this.requirementsEnabled = requirementsEnabled;
		return this;
	}
	public Options setTestPriorityEnabled(Integer testPriorityEnabled) {
		this.testPriorityEnabled = testPriorityEnabled;
		return this;
	}
	public Options setAutomationEnabled(Integer automationEnabled) {
		this.automationEnabled = automationEnabled;
		return this;
	}
	public Options setInventoryEnabled(Integer inventoryEnabled) {
		this.inventoryEnabled = inventoryEnabled;
		return this;
	}

}
