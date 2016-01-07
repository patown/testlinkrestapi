package com.testlinkrestapi.service;

import com.testlinkrestapi.model.TestCaseBean;
import com.testlinkrestapi.model.TestSuiteBean;
import com.testlinkrestapi.model.constants.TestLinkRestApis;
import com.testlinkrestapi.util.DataUtils;



public class TestSuiteService extends BaseService {
	
	

	public TestSuiteService(String restBaseUrl,String devKey) {
		super(restBaseUrl,devKey);
		// TODO Auto-generated constructor stub
	}
	public String  createTestSuite(String string){
	String result=doPost(string);
	return result;
    }
	
    public String createTestSuite(TestSuiteBean testsuite){
    	String string =DataUtils.getJSONTestSuite(testsuite);
    	System.out.println(string);
    	return createTestSuite(string);
    }
	@Override
	protected String setRestUrl() {
		// TODO Auto-generated method stub
		return getRestBaseUrl()+TestLinkRestApis.TEST_SUITES;
	}
	

}
