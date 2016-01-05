package service;

import net.sf.json.JSONObject;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.testlinkrestapi.model.TestPlanBean;
import com.testlinkrestapi.model.constants.TestLinkParams;
import com.testlinkrestapi.service.MiscService;
import com.testlinkrestapi.service.TestPlanService;
import com.testlinkrestapi.service.TestSuiteService;

public class TestSuiteServiceTests {

    static String baseURL = "http://localhost/testlink1914";
	private static String restpath=baseURL+"/lib/api/rest/v2/";
	private static String testsuitepath=restpath+"testsuites";
    private static String devKey="40f388699bf787b88f92030f6caff55f";
    

    TestSuiteService suiteService = new TestSuiteService(restpath, devKey);
		String who ="tlRestApi : Get Route /who";
		String whoami="{\"name\":\"tlRestApi : Get Route \\/whoAmI\"}";
	
	@Test
	public void TestCreateTestSuite(){ 
		
		/*
		 * {
 	"name":"TestSuite  TS100-B",
 	"testProjectID":358,
 	"parentID":358,
 	"notes":"This is my first TS via REST", 
 	"order":100
}
		 */
 		JSONObject jo = new JSONObject();
 	  	jo.put(TestLinkParams.NAME,"tsname001");
 	  	jo.put(TestLinkParams.TEST_PROJECT_ID, 1);
 	  	jo.put(TestLinkParams.NOTES, "iamnotes");
 	  	jo.put("parentID", 1);
 	  	jo.put("order", 100);
		System.out.println(jo.toString());
		String result=suiteService.createTestSuite(testsuitepath, jo.toString());
		System.out.println(result);
	}
}
