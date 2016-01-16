package restapi.service.testplan;


import junit.framework.Assert;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.testlinkrestapi.TLException;
import com.testlinkrestapi.model.TestPlanBean;
import com.testlinkrestapi.restclient.RestClient;
import com.testlinkrestapi.service.TestPlanService;
import com.testlinkrestapi.util.ResponseUtils;

public class UpdateTestPlan {
    static String username = "admin";
    static String password = "admin";
    static String baseURL = "http://localhost/testlink1914";
	private static String restpath=baseURL+"/lib/api/rest/v2/";

	   // private static String devKey="40f388699bf787b88f92030f6caff55f";
    private static String devKey="0dcfc5b0ef5e5df6c7fc4fa9a3b9df95";
    
    TestPlanBean tp= new TestPlanBean();
  	TestPlanService	tlService = new TestPlanService(restpath, devKey);

	
	@Test
	public void TestTestPlanChangeNotes(){    	
 
     	tp.setId(18).setNotes("nnnnn");//.setIsPublic(false);
    	 String response =tlService.updateTestPlan(tp);
    	 System.out.println(response);
    	 Assert.assertTrue(ResponseUtils.IsResponseOK(response));
    	//Assert.assertEquals(tp.getId(), tp2.getId());
	}
//	@Test
//	public void TestTestPlanInPublic(){    	
//	    TestPlanBean tp= new TestPlanBean();
//     	tp.setId(18).setIsPublic(false);
//    	 TestPlanBean tp2 =tlService.updateTestPlan(tp);
//    	Assert.assertEquals(tp.getId(), tp2.getId());
//	}
//	@Test
//	public void TestTestPlanInActive(){    	
//	    TestPlanBean tp= new TestPlanBean();
//     	tp.setId(18).setIsActive(false);
//    	 TestPlanBean tp2 =tlService.updateTestPlan(tp);
//    	Assert.assertEquals(tp.getId(), tp2.getId());
//	}
//	@Test
//	public void TestTestPlanChangeName(){    	
//	    TestPlanBean tp= new TestPlanBean();
//     	tp.setId(18).setName("nameChanged");//.setTestrojectID(1);
//    	 TestPlanBean tp2 =tlService.updateTestPlan(tp);
//    	Assert.assertEquals(tp.getId(), tp2.getId());
//	}
	
	/*
	 * @Bug: RESTAPI-POST- eror while updating two test plan's attributes at the same request
	 * https://github.com/patown/testlinkrestapi/issues/3
	 */
	@Ignore	
	@Test
	public void TestTestPlan(){    	
	    TestPlanBean tp= new TestPlanBean();
     	tp.setId(18).setIsActive(true).setIsPublic(true);
     	String response =tlService.updateTestPlan(tp);
     	System.out.println(response);
     	Assert.assertTrue(ResponseUtils.IsResponseOK(response));
	}
}
