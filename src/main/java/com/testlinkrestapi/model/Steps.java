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
 *  { "step_number":12,
        "actions": "red12",
        "expected_results": "#f00",
        "execution_type":2
      }
      */
public class Steps  implements Serializable {

    private static final long serialVersionUID = 3030116951146834578L;

    private Integer step_number;
    private String actions;
    private String expected_results;
    private Integer execution_type;
	public Integer getStep_number() {
		return step_number;
	}
	public String getActions() {
		return actions;
	}
	public String getExpected_results() {
		return expected_results;
	}
	public Integer getExecution_type() {
		return execution_type;
	}
	public Steps setStep_number(Integer step_number) {
		this.step_number = step_number;
		return this;
	}
	public Steps setActions(String actions) {
		this.actions = actions;
		return this;
	}
	public Steps setExpected_results(String expected_results) {
		this.expected_results = expected_results;
		return this;
	}
	public Steps setExecution_type(Integer execution_type) {
		this.execution_type = execution_type;
		return this;
	}

}
