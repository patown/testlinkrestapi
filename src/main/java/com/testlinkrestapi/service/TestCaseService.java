package com.testlinkrestapi.service;

import java.util.ArrayList;



import com.testlinkrestapi.model.constants.TestLinkRestApis;


import net.sf.json.JSON;


public class TestCaseService extends BaseService {
	
	/*
	 * {
  "name":"Test Case ALFA",
  "testSuiteID":360,
  "testProjectID":358,
  "summary":"This is a summary for Test Case",
  "preconditions":"No preconditions",
  "order":100,
  "authorID":1,
  "importance":2,
  "executionType":1
}
	 */
	
	public TestCaseService(String restBaseUrl,String devKey) {
		super(restBaseUrl,devKey);
		// TODO Auto-generated constructor stub
	}
	public String  createTestCase(String string){
	 return doPost(string);
    }
	
//    public String createTestSuite(TestSuiteBean testsuite){
//    	String string =DataUtils.getJSONTestSuite(testsuite);
//    	String url=getRestBaseUrl()+TestLinkRestApis.TEST_SUITES;
//    	System.out.println(string);
//		String result=createTestSuite(url,string);
//	  	return result;
//    }
	@Override
	protected  String setRestUrl() {
		 return getRestBaseUrl()+TestLinkRestApis.TEST_CASE;
	}
	
	public static void main(String args[]){
		TestCaseService tcservcie = new TestCaseService("htt://localhost/","{\"testSuiteID\":360}");
		System.out.println(tcservcie.getRestUrl());
	}
	
	
}
