package com.testlinkrestapi.service;

import java.util.ArrayList;






import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.testlinkrestapi.model.TestPlanBean;
import com.testlinkrestapi.model.constants.TestLinkResponse;
import com.testlinkrestapi.model.constants.TestLinkRestApis;
import com.testlinkrestapi.restclient.Response;
import com.testlinkrestapi.util.BeanUtils;
import com.testlinkrestapi.util.DataUtils;
import com.testlinkrestapi.util.ResponseUtils;

import net.sf.json.JSON;


public class TestPlanService extends BaseService {
	
	public TestPlanService(String restBaseUrl,String devKey) {
		super(restBaseUrl,devKey);
		// TODO Auto-generated constructor stub
	}
//	public JSON createTestPlan(String string){
//	String result=doPost(string);
//	return DataUtils.getJSON(result);
//    }
	
	public String createTestPlan(String string){
	String result=doPost(string);
	return result;
    }
    public TestPlanBean createTestPlan(TestPlanBean testplan){
    	TestPlanBean bean = new TestPlanBean();
    	String string =DataUtils.getJSONTestPlan(testplan);
    	String response=createTestPlan(string);
    	if(ResponseUtils.IsResponseOK(response)){
    		Integer id =ResponseUtils.getID(response);
    		String testplaString =getTestPlan(id);
    		bean=BeanUtils.getBeanfromString(testplaString, TestPlanBean.class);
    	}
		return bean ;
	  	}
    
//    public TestPlanBean updateTestPlan(TestPlanBean testplan){
//    	Integer id =testplan.getId() ;
//    	if (null !=id && 0!=id){
//    	String string =DataUtils.getJSONTestPlanEdit(testplan);
//    	String url=getRestBaseUrl()+TestLinkRestApis.TEST_PLANS+"/"+id;
//		String result=doPost(url, string);
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
    public String updateTestPlan(TestPlanBean testplan){
    	Integer id =testplan.getId() ;
    	String result = null ;
    	if (null !=id && 0!=id){
    	String string =DataUtils.getJSONTestPlanEdit(testplan);
    	String url=getRestBaseUrl()+TestLinkRestApis.TEST_PLANS+"/"+id;
    	result =doPost(url, string);
    	}
    	return result;
    }
    
    public String updateTestPlan(Integer id, String string){
    	String url=getRestBaseUrl()+TestLinkRestApis.TEST_PLANS+"/"+id;
    	return doPost(url, string);
    }
    
    
    public ArrayList<TestPlanBean> getProjectTestPlans(Integer projectID){
    	//testprojects/:id/testplans
    	String url=getRestBaseUrl()+TestLinkRestApis.TEST_PROJECTS+"/"+projectID+"/"+TestLinkRestApis.TEST_PLANS;
    	System.out.println(url);
    	String result=getRestClient().get(url);
    	System.out.println(result);
    	//TODO:parse result to arraylist
    	return null;
    }
    public String getTestPlan(Integer testplanID){
    	//testprojects/:id/testplans
    	String url=getRestUrl()+"/"+testplanID;
    	System.out.println(url);
    	return doGet(url);
    }
	@Override
	protected String setRestUrl() {
		// TODO Auto-generated method stub
		return getRestBaseUrl()+TestLinkRestApis.TEST_PLANS;
	}
}
