package restapi.service.testplan;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.testlinkrestapi.TLException;
import com.testlinkrestapi.model.TestPlanBean;
import com.testlinkrestapi.restclient.RestClient;
import com.testlinkrestapi.service.TestPlanService;
import com.testlinkrestapi.util.DataUtils;

public class CreateTestPlan {
    static String username = "admin";
    static String password = "admin";
    static String baseURL = "http://localhost/testlink1914";
	private static String restpath=baseURL+"/lib/api/rest/v2/";
   // private static String devKey="40f388699bf787b88f92030f6caff55f";
    private static String devKey="0dcfc5b0ef5e5df6c7fc4fa9a3b9df95";
    TestPlanBean tp= new TestPlanBean();
  	TestPlanService	tlService = new TestPlanService(restpath, devKey);
    @Before
    public void setTestPlanBean(){
    	tp.setIsActive(true);
	  	tp.setIsPublic(true);
	  	tp.setName(DataUtils.getRandom("tp"));
	  	tp.setTestrojectID(1).setNotes("notes");	
    }
    //@Ignore
    /*
     * @Bug
     * url------>http://localhost/testlink1914/lib/api/rest/v2/testplans
     * result--->{"status":"ok","message":"Undefined variable: api_key"}
     */
	@Test
	public void TestCreateTestPlan(){
		TestPlanBean bean=	tlService.createTestPlan(tp);
		System.out.println("id='"+bean.getId()+"'\nname='"+bean.getName()+"'");
	}
}
