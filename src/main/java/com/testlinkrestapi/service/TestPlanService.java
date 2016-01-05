package com.testlinkrestapi.service;

import java.util.ArrayList;



import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.testlinkrestapi.model.TestPlanBean;
import com.testlinkrestapi.model.constants.TestLinkResponse;
import com.testlinkrestapi.model.constants.TestLinkRestApis;
import com.testlinkrestapi.restclient.Response;
import com.testlinkrestapi.util.DataUtils;

import net.sf.json.JSON;


public class TestPlanService extends BaseService {
	
	public TestPlanService(String restBaseUrl,String devKey) {
		super(restBaseUrl,devKey);
		// TODO Auto-generated constructor stub
	}
	public JSON createTestPlan(String url,String string){
	String result=getRestClient().post(url, string);
	
	return DataUtils.getJSON(result);
    }
	
    public TestPlanBean createTestPlan(TestPlanBean testplan){
    	String string =DataUtils.getJSONTestPlan(testplan);
    	String url=getRestBaseUrl()+TestLinkRestApis.TEST_PLANS;
		String result=getRestClient().post(url, string);
	  	//TODO:covert result to testplan object
	  	return testplan;
    }
    
    public TestPlanBean updateTestPlan(TestPlanBean testplan){
    	Integer id =testplan.getId() ;
    	if (null !=id && 0!=id){
    	String string =DataUtils.getJSONTestPlanEdit(testplan);
    	String url=getRestBaseUrl()+TestLinkRestApis.TEST_PLANS+"/"+id;
		String result=getRestClient().post(url, string);
	  	//TODO:covert result to testplan object
		
    	Response response = new Response(result);
    	Integer planid = response.getInt(TestLinkResponse.ID.toString());
//		System.out.println("testplan updated::"+planid);
//		System.out.println(result);
    	testplan.setId(planid);
    	}
	  	return testplan;
    }
    
    public ArrayList<TestPlanBean> getProjectTestPlans(int projectID){
    	//testprojects/:id/testplans
    	String url=getRestBaseUrl()+TestLinkRestApis.TEST_PROJECTS+"/"+projectID+"/"+TestLinkRestApis.TEST_PLANS;
    	System.out.println(url);
    	String result=getRestClient().get(url);
    	System.out.println(result);
    	//TODO:parse result to arraylist
    	return null;
    }
    public TestPlanBean getTestPlan(int testplanID){
    	//testprojects/:id/testplans
    	String url=getRestBaseUrl()+TestLinkRestApis.TEST_PLANS+"/"+testplanID;
    	System.out.println(url);
    	String result=getRestClient().get(url);
    	System.out.println(result);
    	//TODO:parse result to arraylist
    	return null;
    }
}
