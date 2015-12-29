package restapi.testproject;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.testlinkrestapi.TLException;
import com.testlinkrestapi.model.Options;
import com.testlinkrestapi.model.TestPlanBean;
import com.testlinkrestapi.model.TestProjectBean;
import com.testlinkrestapi.restclient.RestClient;
import com.testlinkrestapi.service.TestPlanService;
import com.testlinkrestapi.service.TestProjectService;

public class CreateTestProject {

    static String baseURL = "http://localhost/testlink1914";
	private static String restpath=baseURL+"/lib/api/rest/v2/";

    private static String devKey="40f388699bf787b88f92030f6caff55f";
    
    
    TestProjectBean project= new TestProjectBean();
    Options options = new Options();
  	TestProjectService	tpService = new TestProjectService(restpath, devKey);
    @Before
    public void setBeans(){
    	options.setAutomationEnabled(1).setInventoryEnabled(1).setTestPriorityEnabled(1).setTestPriorityEnabled(1);
	  	project.setName("tp00088").setPrefix("tp1").setColor("iamcolor").setNotes("iamnote");
    	project.setIsActive(true).setIsPublic(true).setOptions(options);
    }
    @Ignore
	@Test
	public void TestCreateTestProject(){
    	tpService.createTestProject(project);
	}
    @Ignore
	@Test
	public void TestGetTestProject(){
    	tpService.getTestProject(24);
	}
	
	@Test
	public void TestGetTestProjects(){
    	tpService.getTestProjects();
	}
	
}
