
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


import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import com.testlinkrestapi.model.TestPlanBean;
import com.testlinkrestapi.model.TestProjectBean;
import com.testlinkrestapi.model.TestProjectRspBean;
import com.testlinkrestapi.model.constants.TestLinkRestApis;
import com.testlinkrestapi.restclient.Response;
import com.testlinkrestapi.util.BeanUtils;
import com.testlinkrestapi.util.DataUtils;
import com.testlinkrestapi.util.ResponseUtils;



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
     * @return TestProjectBean
     * @Bug RESTAPI-POST-CreateTestProject- no "id" in in response message
     * https://github.com/patown/testlinkrestapi/issues/4
     */
    public TestProjectBean createTestProject(TestProjectBean project){
    	String string =DataUtils.getJSONTestProject(project);
    	
		ArrayList<TestProjectBean> before = getTestProjectList();
		TestProjectBean bean = new TestProjectBean();
    	String response=createTestProject(string);
    	if(ResponseUtils.IsResponseOK(response)){
    	//id =ResponseUtils.getID(response);
			ArrayList<TestProjectBean> after = getTestProjectList();
			bean=BeanUtils.getDeltaTestProject(before,after);
    	} 
       //	return getTestProjectByID(id); 	
    	return bean;
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
     * @return testprojects
     */
    public ArrayList<TestProjectBean> getTestProjectList(){
    	String url=getRestUrl();
    	String result=doGet(url);
    	//System.out.println(result);
    	//TODO:parse result to arraylist
    	return ResponseUtils.getTestProjectBeanList(result);
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
    
    /*
     * @param testprojectName
     * @return TestProjectBean
     */
    public TestProjectBean getTestProjectByName(String testprojectName){
    	String result=getTestProject(testprojectName);
    	//TODO: using response class
    	TestProjectRspBean rspBean =ResponseUtils.getTestProjectRspBean(result);
    	TestProjectBean bean =BeanUtils.getTestProjectBeanFromTestProjectRspBean(rspBean);
    	return bean;
    }

    /*
     * @param testprojectID
     * @return TestProjectBean
     */
	public TestProjectBean getTestProjectByID(Integer projectID) {
    	String result=getTestProject(projectID);
    	//TODO: using response class
    	TestProjectRspBean rspBean =ResponseUtils.getTestProjectRspBean(result);
    	TestProjectBean bean =BeanUtils.getTestProjectBeanFromTestProjectRspBean(rspBean);
    	return bean;
	}
	
    /*
     * @param testprojectID
     * @return TestProjectBean
     */
	public ArrayList<TestPlanBean>  getTestPlansInTestProject(Integer projectID) {
    	//testprojects/:id/testplans
    	String url=getRestUrl()+"/"+projectID+"/"+TestLinkRestApis.TEST_PLANS;
    	String result=getRestClient().get(url);
    	System.out.println(result);
    	return null;
	}
	

	
	@Override
	protected String setRestUrl() {
		return getRestBaseUrl()+TestLinkRestApis.TEST_PROJECTS;
	}
}
