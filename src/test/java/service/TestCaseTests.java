package service;

import net.sf.json.JSONObject;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.testlinkrestapi.model.TestCaseBean;
import com.testlinkrestapi.service.TestCaseService;


public class TestCaseTests {

    static String baseURL = "http://localhost/testlink1914";
	private static String restpath=baseURL+"/lib/api/rest/v2/";

    //private static String devKey="0dcfc5b0ef5e5df6c7fc4fa9a3b9df95";//pc
    private static String devKey="40f388699bf787b88f92030f6caff55f";//nb

    TestCaseService suiteService = new TestCaseService(restpath, devKey);
//	@Ignore
//    @Test
//	public void TestCreateTestSuiteJSON(){ 
//		
//		/*
//		 * {
// 	"name":"TestSuite  TS100-B",
// 	"testProjectID":358,
// 	"parentID":358,
// 	"notes":"This is my first TS via REST", 
// 	"order":100
//}
//
////{"id":0,
// * "parentID":1,
// * "order":104,
// * "testProjectID":1,
// * "name":"tsname003",
// * "notes":"iamnotes"}
// * 
// * 
//		 */
// 		JSONObject jo = new JSONObject();
// 	  	jo.put(TestLinkParams.NAME,"tsname002");
// 	  	jo.put(TestLinkParams.TEST_PROJECT_ID, 1);
// 	  	jo.put(TestLinkParams.NOTES, "iamnotes");
// 	  	jo.put("parentID", 1);
// 	  	jo.put("order", 101);
//		System.out.println(jo.toString());
//		String result=suiteService.createTestSuite(testsuitepath, jo.toString());
//		System.out.println(result);
//	}
	
	@Test
	public void TestCreateTestSuiteBean(){ 
		TestCaseBean bean = new TestCaseBean();		
		bean.setName("tcname001")
		.setAuthorID(1).setExecutionType(1).setImportance(2).setOrder(100)
		.setPreconditions("noprecondition").setTestSuite(2).setSummary("iamsummary")
		.setTestProject(1);
		
		System.out.println("");
		String result=suiteService.createTestCase(bean);
		System.out.println(result);
	}
	
}
