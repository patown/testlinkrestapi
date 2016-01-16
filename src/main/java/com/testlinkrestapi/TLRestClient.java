package com.testlinkrestapi;


import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSON;
import net.sf.json.JSONObject;

import com.testlinkrestapi.itestlink.ITestLink;
import com.testlinkrestapi.model.TestCaseBean;
import com.testlinkrestapi.model.TestPlanBean;
import com.testlinkrestapi.model.TestProjectBean;
import com.testlinkrestapi.model.TestSuiteBean;
import com.testlinkrestapi.model.constants.TestLinkRestApis;
import com.testlinkrestapi.restclient.Response;
import com.testlinkrestapi.restclient.RestClient;
import com.testlinkrestapi.service.MiscService;
import com.testlinkrestapi.service.TestCaseService;
import com.testlinkrestapi.service.TestPlanService;
import com.testlinkrestapi.service.TestProjectService;
import com.testlinkrestapi.service.TestSuiteService;
import com.testlinkrestapi.util.DataUtils;

public class TLRestClient implements ITestLink{

    private RestClient restClient;

    
    private TestCaseService testCaseService;
    private MiscService miscService;
    private TestProjectService testprojectService;
    private TestSuiteService testSuiteService ;
    private TestPlanService testPlanService;
    /**
     * Creates an authenticated TestLink rest client.
     *
     * @param baseURL Base URI of the Testlink server
     * @param userName username to authenticate with. Use Testlink apikey for now.
     * @param password password to authenticate with. put whatever is ok. willl be ignored
     * @throws TLException 
     */
    public TLRestClient(String baseURL, String devKey) throws TLException {
    	this.restClient= new RestClient(devKey,devKey);
    	this.miscService= new MiscService(baseURL,devKey);
    	this.testprojectService= new TestProjectService(baseURL,devKey) ;
    	this.testSuiteService = new TestSuiteService(baseURL,devKey);
    	this.testCaseService= new TestCaseService(baseURL,devKey);
    }


	

        


    /**
     * test route with anonymous function 
     * @return tlRestApi : Get Route /who
     */
	@Override
	public String who() {
		return miscService.who();
	}
    /**
     * test route with devKey  
     * @return {"name":"tlRestApi : Get Route \/whoAmI"}
     */
	@Override
	public String whoAmI() {
		// TODO Auto-generated method stub
		return miscService.whoami();
	}



    /* XX Test Project operations XX */

	@Override
	public TestProjectBean createTestProject(TestProjectBean project) {
		// TODO Auto-generated method stub
		return testprojectService.createTestProject(project);
	}

	@Override
	public TestProjectBean getTestProjectByID(Integer projectID) {
		// TODO Auto-generated method stub
		return testprojectService.getTestProjectByID(projectID);
	}

	@Override
	public TestProjectBean getTestProjectByName(String projectName) {
		return testprojectService.getTestProjectByName(projectName);
	}





	@Override
	public ArrayList<TestProjectBean> getProjects() {
		// TODO Auto-generated method stub
		return testprojectService.getTestProjectList();
	}







	@Override
	public ArrayList<TestPlanBean> getTestPlansInTestProject(Integer projectID) {
		// TODO Auto-generated method stub
		return testprojectService.getTestPlansInTestProject(projectID);
	}


	@Override
	public TestPlanBean createTestPlan(TestPlanBean testPlanBean) {
		// TODO Auto-generated method stub
		 return testPlanService.createTestPlan(testPlanBean);
		 
	}







	@Override
	public TestPlanBean updateTestPlan(TestPlanBean testPlanBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TestSuiteBean createTestSuite(TestSuiteBean testsuite) {
		// TODO Auto-generated method stub
		return testSuiteService.createTestSuite(testsuite);
	}







	@Override
	public TestCaseBean createTestCase(TestCaseBean testcase) {
		// TODO Auto-generated method stub
		return testCaseService.createTestCase(testcase);
	}
    
 


}
