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

import net.sf.json.JSONObject;

/**
 * @author Antony Chen
 * @since 1.9.14
 */
public class TestProjectRspBean implements Serializable {

    private static final long serialVersionUID = 3030116951146834578L;
  
    private String id;
 	private String notes;
 	private String name;
    private String color;

    private String active;
    private String option_reqs;
    private String option_priority;
    private String option_automation;
    private String options;
//    private OptionsRsp options;

	private String prefix;
    private String is_public;

	private String tc_counter;
    private String issue_tracker_enabled;
    private String reqmgr_integration_enabled;
    private String api_key;
    private Options opt;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}
	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
    /**
	 * @return the is_public
	 */
	public String getIs_public() {
		return is_public;
	}
	/**
	 * @param is_public the is_public to set
	 */
	public void setIs_public(String is_public) {
		this.is_public = is_public;
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * @return the active
	 */
	public String getActive() {
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(String active) {
		this.active = active;
	}
	/**
	 * @return the option_reqs
	 */
	public String getOption_reqs() {
		return option_reqs;
	}
	/**
	 * @param option_reqs the option_reqs to set
	 */
	public void setOption_reqs(String option_reqs) {
		this.option_reqs = option_reqs;
	}
	/**
	 * @return the option_priority
	 */
	public String getOption_priority() {
		return option_priority;
	}
	/**
	 * @param option_priority the option_priority to set
	 */
	public void setOption_priority(String option_priority) {
		this.option_priority = option_priority;
	}
	/**
	 * @return the option_automation
	 */
	public String getOption_automation() {
		return option_automation;
	}
	/**
	 * @param option_automation the option_automation to set
	 */
	public void setOption_automation(String option_automation) {
		this.option_automation = option_automation;
	}



	/**
	 * @return the prefix
	 */
	public String getPrefix() {
		return prefix;
	}
	
    /**
	 * @return the options
	 */
//	public OptionsRsp getOptions() {
//		return options;
//	}
	public String getOptions() {
		return options;
	}
	/**
	 * @param options the options to set
	 */
//	public void setOptions(OptionsRsp options) {
//		this.options = options;
//	}
	public void setOptions(String options) {
	this.options = options;
}
	/**
	 * @param prefix the prefix to set
	 */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	/**
	 * @return the tc_counter
	 */
	public String getTc_counter() {
		return tc_counter;
	}
	/**
	 * @param tc_counter the tc_counter to set
	 */
	public void setTc_counter(String tc_counter) {
		this.tc_counter = tc_counter;
	}
	/**
	 * @return the issue_tracker_enabled
	 */
	public String getIssue_tracker_enabled() {
		return issue_tracker_enabled;
	}
	/**
	 * @param issue_tracker_enabled the issue_tracker_enabled to set
	 */
	public void setIssue_tracker_enabled(String issue_tracker_enabled) {
		this.issue_tracker_enabled = issue_tracker_enabled;
	}
	/**
	 * @return the reqmgr_integration_enabled
	 */
	public String getReqmgr_integration_enabled() {
		return reqmgr_integration_enabled;
	}
	/**
	 * @param reqmgr_integration_enabled the reqmgr_integration_enabled to set
	 */
	public void setReqmgr_integration_enabled(String reqmgr_integration_enabled) {
		this.reqmgr_integration_enabled = reqmgr_integration_enabled;
	}
	/**
	 * @return the api_key
	 */
	public String getApi_key() {
		return api_key;
	}
	/**
	 * @param api_key the api_key to set
	 */
	public void setApi_key(String api_key) {
		this.api_key = api_key;
	}
	/**
	 * @return the opt
	 */
	public Options getOpt() {
		return opt;
	}
	/**
	 * @param opt the opt to set
	 */
	public void setOpt(Options opt) {
		this.opt = opt;
	}


	
}
