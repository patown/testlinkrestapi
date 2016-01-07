package service;

import net.sf.json.JSONObject;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.testlinkrestapi.model.TestPlanBean;
import com.testlinkrestapi.model.TestSuiteBean;
import com.testlinkrestapi.model.constants.TestLinkParams;
import com.testlinkrestapi.service.MiscService;
import com.testlinkrestapi.service.TestPlanService;
import com.testlinkrestapi.service.TestSuiteService;

public class TestSuiteServiceTests {

    static String baseURL = "http://localhost/testlink1914";
	private static String restpath=baseURL+"/lib/api/rest/v2/";
	private static String testsuitepath=restpath+"testsuites";
    private static String devKey="0dcfc5b0ef5e5df6c7fc4fa9a3b9df95";
    

    TestSuiteService suiteService = new TestSuiteService(restpath, devKey);
	@Ignore
    @Test
	public void TestCreateTestSuiteJSON(){ 
		
		/*
		 * {
 	"name":"TestSuite  TS100-B",
 	"testProjectID":358,
 	"parentID":358,
 	"notes":"This is my first TS via REST", 
 	"order":100
}

//{"id":0,
 * "parentID":1,
 * "order":104,
 * "testProjectID":1,
 * "name":"tsname003",
 * "notes":"iamnotes"}
 * 
 * 
		 */
 		JSONObject jo = new JSONObject();
 	  	jo.put(TestLinkParams.NAME,"tsname002");
 	  	jo.put(TestLinkParams.TEST_PROJECT_ID, 1);
 	  	jo.put(TestLinkParams.NOTES, "iamnotes");
 	  	jo.put("parentID", 1);
 	  	jo.put("order", 101);
		System.out.println(jo.toString());
		String result=suiteService.createTestSuite(jo.toString());
		System.out.println(result);
	}
	
	@Test
	public void TestCreateTestSuiteBean(){ 
		TestSuiteBean tsbean = new TestSuiteBean();		
		tsbean.setName("tsname004")
		.setTestProjectID(1)
		.setNotes("iamnotes")
		.setParentID(1)
		.setOrder(104);
		
		
		System.out.println("");
		String result=suiteService.createTestSuite(tsbean);
		System.out.println(result);
	}
	
}
