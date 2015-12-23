package testplan;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.testlinkrestapi.TLException;
import com.testlinkrestapi.model.TestPlanBean;
import com.testlinkrestapi.restclient.RestClient;
import com.testlinkrestapi.service.TestPlanService;

public class UpdateTestPlans {
    static String username = "admin";
    static String password = "admin";
    static String baseURL = "http://localhost/testlink1914";
	private static String restpath=baseURL+"/lib/api/rest/v2/";

    private static String devKey="40f388699bf787b88f92030f6caff55f";
    
    
    TestPlanBean tp= new TestPlanBean();
  	TestPlanService	tlService = new TestPlanService(restpath, devKey);
    @Before
    public void setTestPlanBean(){
    	tp.setIsActive(true);
	  	tp.setIsPublic(true);
	  	tp.setName("tp00088");
	  	tp.setTestrojectID(1).setNotes("notes");	
    }
    @Ignore
	@Test
	public void TestCreateTestPlan(){
     	tlService.createTestPlan(tp);
	}
	
	@Test
	public void TestTestPlanChangeNotes(){    	
	    TestPlanBean tp= new TestPlanBean();
     	tp.setId(18).setNotes("nnnnn");//.setIsPublic(false);
     	tlService.updateTestPlan(tp);
	}
	@Test
	public void TestTestPlanInPublic(){    	
	    TestPlanBean tp= new TestPlanBean();
     	tp.setId(18).setIsPublic(false);
     	tlService.updateTestPlan(tp);
	}
	@Test
	public void TestTestPlanInActive(){    	
	    TestPlanBean tp= new TestPlanBean();
     	tp.setId(18).setIsActive(false);
     	tlService.updateTestPlan(tp);
	}
	@Test
	public void TestTestPlanChangeName(){    	
	    TestPlanBean tp= new TestPlanBean();
     	tp.setId(18).setName("nameChanged");//.setTestrojectID(1);
     	tlService.updateTestPlan(tp);
	}
	@Test
	public void TestTestPlan(){    	
	    TestPlanBean tp= new TestPlanBean();
     	tp.setId(18).setIsActive(true).setIsPublic(true);
     	tlService.updateTestPlan(tp);
	}
	@Ignore
	@Test
	public void TestTestPlanGetList(){    	
	    int projectID=1;
     	tlService.getProjectTestPlans(projectID);
	}
	@Test
	public void TestTestPlanGet(){    	
	    int testplanID=18;
     	tlService.getTestPlan(testplanID);
	}
}
