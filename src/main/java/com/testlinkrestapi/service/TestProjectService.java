package com.testlinkrestapi.service;

import java.util.ArrayList;

import org.junit.Ignore;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.testlinkrestapi.model.TestPlanBean;
import com.testlinkrestapi.model.TestProjectBean;
import com.testlinkrestapi.model.constants.TestLinkResponse;
import com.testlinkrestapi.model.constants.TestLinkRestApis;
import com.testlinkrestapi.restclient.Response;
import com.testlinkrestapi.util.DataUtils;

import net.sf.json.JSON;


public class TestProjectService extends BaseService {
	
	public TestProjectService(String restBaseUrl,String devKey) {
		super(restBaseUrl,devKey);
		// TODO Auto-generated constructor stub
	}
//	public JSON createTestPlan(String url,String string){
//	String result=getRestClient().post(url, string);
//	
//	return DataUtils.getJSON(result);
//    }
	
    public String createTestProject(TestProjectBean project){
    	String string =DataUtils.getJSONTestProject(project);
    	System.out.println(string);
    	String url=getRestBaseUrl()+TestLinkRestApis.TEST_PROJECTS;
		String result=getRestClient().post(url, string);
	  	//TODO:covert result to testplan object
	//	System.out.println(result);
	  	return result;
    }
    
    public String createTestProject(String string){
    	System.out.println(string);
    	String url=getRestBaseUrl()+TestLinkRestApis.TEST_PROJECTS;
		String result=getRestClient().post(url, string);
	  	//TODO:covert result to testplan object
	//	System.out.println(result);
	  	return result;
    }
    
//    public TestPlanBean updateTestPlan(TestPlanBean testplan){
//    	Integer id =testplan.getId() ;
//    	if (null !=id && 0!=id){
//    	String string =DataUtils.getJSONTestPlanEdit(testplan);
//    	String url=getRestBaseUrl()+TestLinkRestApis.TEST_PLANS+"/"+id;
//		String result=getRestClient().post(url, string);
//	  	//TODO:covert result to testplan object
//		
//    	Response response = new Response(result);
//    	Integer planid = response.getInt(TestLinkResponse.ID.toString());
////		System.out.println("testplan updated::"+planid);
////		System.out.println(result);
//    	testplan.setId(planid);
//    	}
//	  	return testplan;
//    }
//    
    public ArrayList<TestProjectBean> getTestProjects(){
    	//testprojects/:id/testplans
    	String url=getRestBaseUrl()+TestLinkRestApis.TEST_PROJECTS;
    	System.out.println(url);
    	String result=getRestClient().get(url);
    	System.out.println(result);
    	//TODO:parse result to arraylist
    	return null;
    }
    public TestProjectBean getTestProject(int testprojectID){
    	//testprojects/:id/testplans
    	String url=getRestBaseUrl()+TestLinkRestApis.TEST_PROJECTS+"/"+testprojectID;
    	System.out.println(url);
    	String result=getRestClient().get(url);
    	System.out.println(result);
    	//TODO:parse result to arraylist
    	return null;
    }
}
