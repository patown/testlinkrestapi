package restapi.service.testproject;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.testlinkrestapi.model.Options;
import com.testlinkrestapi.model.TestProjectBean;
import com.testlinkrestapi.service.TestProjectService;
import com.testlinkrestapi.util.DataUtils;

public class GetNewlyTestProject {
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
		  	project.setName(DataUtils.getRandom("tp")).setPrefix(DataUtils.getRandomShort()).setColor("iamcolor").setNotes("iamnote");
	    	project.setActive(0).setIs_public(1).setOptions(options);
	    }

		@Test
		public void TestCreateTestProject(){
			
			ArrayList<TestProjectBean> orignalList = tpService.getTestProjectList();
	    	TestProjectBean result =tpService.createTestProject(project);
	    	System.out.println("id='"+result.getId()+"' name='"+result.getName()+"'");
			ArrayList<TestProjectBean> newList = tpService.getTestProjectList();
			int detla=newList.size()-orignalList.size();
			if(detla==1){
				System.out.println(newList.get(newList.size()-1).getId());
			}
			}
}
