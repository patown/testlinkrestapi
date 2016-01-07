package com.testlinkrestapi.service;


import com.testlinkrestapi.model.TestCaseBean;
import com.testlinkrestapi.model.constants.TestLinkRestApis;
import com.testlinkrestapi.util.DataUtils;


public class TestCaseService extends BaseService {
	

	
	public TestCaseService(String restBaseUrl,String devKey) {
		super(restBaseUrl,devKey);
		// TODO Auto-generated constructor stub
	}
	public String  createTestCase(String string){
	 return doPost(string);
    }
	
    public String createTestCase(TestCaseBean testcase){
    	String string =DataUtils.getJSONTestCase(testcase);
    	System.out.println(string);
    	return createTestCase(string);
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
