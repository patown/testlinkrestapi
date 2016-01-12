
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
package com.testlinkrestapi.service;


import com.testlinkrestapi.model.TestProjectBean;
import com.testlinkrestapi.model.constants.TestLinkRestApis;
import com.testlinkrestapi.util.DataUtils;



/**
 * @author Antony Chen
 * @since 1.9.14
 */
public class TestProjectService extends BaseService {
	
	public TestProjectService(String restBaseUrl,String devKey) {
		super(restBaseUrl,devKey);
		// TODO Auto-generated constructor stub
	}

    /*
     * @param TestProjectBean 
     * @return result
     */
    public String createTestProject(TestProjectBean project){
    	String string =DataUtils.getJSONTestProject(project);
	  	return createTestProject(string);
    }
    /*
     * @param testproject String
     * @return result
     */
    public String createTestProject(String string){
    	System.out.println(string);
    	String url=getRestUrl();
		String result=getRestClient().post(url, string);
	  	return result;
    }
    
    /*
     * @return testprojects
     */
    public String getTestProjects(){
    	String url=getRestUrl();
    	String result=doGet(url);
    	//System.out.println(result);
    	//TODO:parse result to arraylist
    	return result;
    }
    
    /*
     * @param testprojectID
     * @return testproject
     */
    public String getTestProject(int testprojectID){
    	String url=getRestUrl()+"/"+testprojectID;
    	String result=doGet(url);
    	return result;
    }
    
    /*
     * @param testprojectName
     * @return testproject
     */
    public String getTestProject(String testprojectName ){
    	String url=getRestUrl()+"/"+testprojectName;
    	String result=doGet(url);
    	return result;
    }

	@Override
	protected String setRestUrl() {
		return getRestBaseUrl()+TestLinkRestApis.TEST_PROJECTS;
	}
}
