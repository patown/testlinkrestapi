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
package com.testlinkrestapi.model.constants;


/**
 * 
 * <p>
 * This enum contains a list of the response parameters  from TestLink.
 * </p>
 * 
 * 
/**
 * @author Antony Chen
 * @since 1.9.14
 */
public enum TestLinkResponse {
    ID("id"), 
    ITEM("item"),
    MESSAGE("message"),
    OK("ok"),
    STATUS("status"),
    ;
    
    private String value;

    TestLinkResponse(String value) {
	this.value = value;
    }

    public String toString() {
	return this.value;
    }

}
