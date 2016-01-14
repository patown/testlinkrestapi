package restapi.service.testplan;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.testlinkrestapi.TLException;
import com.testlinkrestapi.model.TestPlanBean;
import com.testlinkrestapi.restclient.RestClient;
import com.testlinkrestapi.service.TestPlanService;

public class GetTestPlan {
    static String username = "admin";
    static String password = "admin";
    static String baseURL = "http://localhost/testlink1914";
	private static String restpath=baseURL+"/lib/api/rest/v2/";

    private static String devKey="40f388699bf787b88f92030f6caff55f";
    
    
//    TestPlanBean tp= new TestPlanBean();
  	TestPlanService	tlService = new TestPlanService(restpath, devKey);
// 
//	@Ignore
//	@Test
//	
//	
//	public void TestTestPlanGetList(){    	
//	    int projectID=1;
//     	tlService.getProjectTestPlans(projectID);
//	}
	@Test
	public void TestTestPlanGet(){    	
	    int testplanID=40;
     System.out.println(tlService.getTestPlan(testplanID));
	}
}
