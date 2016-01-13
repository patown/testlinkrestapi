package com.tlrestlcient;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.testlinkrestapi.TLException;
import com.testlinkrestapi.TLRestClient;
import com.testlinkrestapi.model.TestPlanBean;
import com.testlinkrestapi.service.MiscService;
import com.testlinkrestapi.service.TestPlanService;

public class TestTLRestClientMisc {

    static String baseURL = "http://localhost/testlink1914";
	private static String restpath=baseURL+"/lib/api/rest/v2/";

    private static String devKey="40f388699bf787b88f92030f6caff55f";
    private TLRestClient tlclient;


		String who ="tlRestApi : Get Route /who";
		String whoami="{\"name\":\"tlRestApi : Get Route \\/whoAmI\"}";
	@Test
	public void TestWHO(){    	
	    try {
			TLRestClient tlclient = new TLRestClient(restpath, devKey);
			System.out.println(tlclient.who());
		} catch (TLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	@Test
	public void TestWHOAMI(){ 
		try {
			TLRestClient tlclient = new TLRestClient(restpath, devKey);
			System.out.println(tlclient.whoAmI());
		} catch (TLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
