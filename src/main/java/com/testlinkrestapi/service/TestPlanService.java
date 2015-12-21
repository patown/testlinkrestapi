package com.testlinkrestapi.service;

import com.testlinkrestapi.model.TestPlanBean;
import com.testlinkrestapi.model.constants.TestLinkRestApis;
import com.testlinkrestapi.util.Util;

import net.sf.json.JSON;


public class TestPlanService extends BaseService {
	
	public TestPlanService(String restBaseUrl,String devKey) {
		super(restBaseUrl,devKey);
		// TODO Auto-generated constructor stub
	}
	public JSON createTestPlan(String url,String string){
	String result=getRestClient().post(url, string);
	
	return Util.getJSON(result);
    }
	
    public TestPlanBean CreateTestPlan(TestPlanBean testplan){
    	String string =Util.getTestPlanJSON(testplan);
    	String url=getRestBaseUrl()+TestLinkRestApis.TEST_PLANS;
		String result=getRestClient().post(url, string);
	  	//TODO:covert result to testplan object
	  	return testplan;
    }
}
