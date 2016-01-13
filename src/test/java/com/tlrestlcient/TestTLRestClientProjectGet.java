package com.tlrestlcient;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import com.testlinkrestapi.TLException;
import com.testlinkrestapi.TLRestClient;

import com.testlinkrestapi.model.TestProjectBean;


public class TestTLRestClientProjectGet {

    static String baseURL = "http://localhost/testlink1914";
	private static String restpath=baseURL+"/lib/api/rest/v2/";

  //  private static String devKey="40f388699bf787b88f92030f6caff55f";
    
    private static String devKey="0dcfc5b0ef5e5df6c7fc4fa9a3b9df95";
    private TLRestClient tlclient;


		String who ="tlRestApi : Get Route /who";
		String whoami="{\"name\":\"tlRestApi : Get Route \\/whoAmI\"}";
	@Before
	public void setup(){
		try {
			tlclient = new TLRestClient(restpath, devKey);
		} catch (TLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	@Test
//	public void TestgetTestProjectByName(){    	
//		String projectName="tp001";
//		TestProjectBean bean=tlclient.getTestProjectByName(projectName);
//			Assert.assertEquals("error while retriving a project", projectName, bean.getName());
//		}
	@Test
	public void TestgetTestProjectByID(){    	
		Integer id =1;
		TestProjectBean bean=tlclient.getTestProjectByID(id);
		Assert.assertFalse("error while retriving a project",bean.getId()==id.toString());
		}
}
