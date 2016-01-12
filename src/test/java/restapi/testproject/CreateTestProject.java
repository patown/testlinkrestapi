package restapi.testproject;


import junit.framework.Assert;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.testlinkrestapi.TLException;
import com.testlinkrestapi.model.Options;
import com.testlinkrestapi.model.TestPlanBean;
import com.testlinkrestapi.model.TestProjectBean;
import com.testlinkrestapi.restclient.Response;
import com.testlinkrestapi.restclient.RestClient;
import com.testlinkrestapi.service.TestPlanService;
import com.testlinkrestapi.service.TestProjectService;

public class CreateTestProject {

    static String baseURL = "http://localhost/testlink1914";
	private static String restpath=baseURL+"/lib/api/rest/v1/";

	   // private static String devKey="40f388699bf787b88f92030f6caff55f";
    private static String devKey="0dcfc5b0ef5e5df6c7fc4fa9a3b9df95";
    
    
    TestProjectBean project= new TestProjectBean();
    Options options = new Options();
  	TestProjectService	tpService = new TestProjectService(restpath, devKey);
    @Before
    public void setBeans(){
    	options.setAutomationEnabled(1);
    	options.setInventoryEnabled(1);
    	options.setTestPriorityEnabled(1);
    	options.setTestPriorityEnabled(1);
	  	project.setName("tp220").setPrefix("220").setColor("iamcolor").setNotes("iamnote");
    	project.setActive(0).setIs_public(1).setOptions(options);
    }

	@Test
	public void TestCreateTestProject(){
    	String result =tpService.createTestProject(project);
    	Response response= new Response(result);
    	System.out.println(result);
    	Assert.assertTrue(response.IsResponseOK());
    	result =tpService.createTestProject(project);
    	System.out.println(result);
    	response= new Response(result);
    	Assert.assertEquals("ko", response.getStatus());
	}

}
