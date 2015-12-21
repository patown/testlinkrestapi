package testplan;


import org.junit.Test;

import com.testlinkrestapi.TLException;
import com.testlinkrestapi.model.TestPlanBean;
import com.testlinkrestapi.restclient.RestClient;
import com.testlinkrestapi.service.TestPlanService;

public class CreateTestPlan {
    static String username = "admin";
    static String password = "admin";
    static String baseURL = "http://localhost/testlink1914";
	private static String restpath=baseURL+"/lib/api/rest/v2/";

    private static String devKey="40f388699bf787b88f92030f6caff55f";
	@Test
	public void TestCreateTestPlan(){
		TestPlanBean tp= new TestPlanBean();
	  	tp.setIsActive(true);
	  	tp.setIsPublic(true);
	  	tp.setName("tp0006");
	  	tp.setTestrojectID(1).setNotes("notes");		
	  	TestPlanService	tlService = new TestPlanService(restpath, devKey);
  //	tlService.createTestPlan(testplanString,jo.toString());
     	tlService.CreateTestPlan(tp);
	}
}
