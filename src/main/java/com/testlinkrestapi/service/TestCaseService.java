package com.testlinkrestapi.service;


import java.util.ArrayList;

import com.testlinkrestapi.model.TestCaseBean;
import com.testlinkrestapi.model.TestProjectBean;
import com.testlinkrestapi.model.constants.TestLinkRestApis;
import com.testlinkrestapi.util.BeanUtils;
import com.testlinkrestapi.util.DataUtils;
import com.testlinkrestapi.util.ResponseUtils;


public class TestCaseService extends BaseService {
	

	
	public TestCaseService(String restBaseUrl,String devKey) {
		super(restBaseUrl,devKey);
		// TODO Auto-generated constructor stub
	}
	public String  createTestCase(String string){
	 return doPost(string);
    }
	
    public TestCaseBean createTestCase(TestCaseBean testcase){
    	String string =DataUtils.getJSONTestCase(testcase);
    	System.out.println(string);
    	TestCaseBean bean = new TestCaseBean();
    	String response =createTestCase(string);
    	if(ResponseUtils.IsResponseOK(response)){
    	 Integer id =ResponseUtils.getID(response);
			bean.setId(id);
    	} 
    	return bean;
    }
	@Override
	protected  String setRestUrl() {
		 return getRestBaseUrl()+TestLinkRestApis.TEST_CASE;
	}
	
//	public static void main(String args[]){
//		TestCaseService tcservcie = new TestCaseService("htt://localhost/","{\"testSuiteID\":360}");
//		System.out.println(tcservcie.getRestUrl());
//	}
	
	
}
