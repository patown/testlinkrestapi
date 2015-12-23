package service;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.testlinkrestapi.model.TestPlanBean;
import com.testlinkrestapi.service.MiscService;
import com.testlinkrestapi.service.TestPlanService;

public class TestMiscService {

    static String baseURL = "http://localhost/testlink1914";
	private static String restpath=baseURL+"/lib/api/rest/v2/";

    private static String devKey="40f388699bf787b88f92030f6caff55f";
    

  	MiscService miscService = new MiscService(restpath, devKey);
		String who ="tlRestApi : Get Route /who";
		String whoami="{\"name\":\"tlRestApi : Get Route \\/whoAmI\"}";
	@Test
	public void TestWHO(){    	
		Assert.assertTrue(who.equalsIgnoreCase(miscService.who()));
		}
	@Test
	public void TestWHOAMI(){ 
		System.out.println(miscService.whoami());
		Assert.assertTrue(whoami.equalsIgnoreCase(miscService.whoami()));
	}
}
