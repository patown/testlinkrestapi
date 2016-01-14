package restapi.service.testplan;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.testlinkrestapi.TLException;
import com.testlinkrestapi.model.TestPlanBean;
import com.testlinkrestapi.restclient.RestClient;
import com.testlinkrestapi.service.TestPlanService;
import com.testlinkrestapi.service.TestProjectService;

public class GetTestPlan {
	private static String username = "admin";
	private static String password = "admin";
	private static String baseURL = "http://localhost/testlink1914";
	private static String  resturl=baseURL+"/lib/api/rest/v2/";
	   // private static String devKey="40f388699bf787b88f92030f6caff55f";
    private static String devKey="0dcfc5b0ef5e5df6c7fc4fa9a3b9df95";
    
//    TestPlanBean tp= new TestPlanBean();
    TestProjectService	tlService = new TestProjectService(resturl,devKey);
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
     System.out.println(tlService.getTestPlansInTestProject(6));
	}
}
