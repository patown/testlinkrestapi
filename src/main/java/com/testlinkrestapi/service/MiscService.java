package com.testlinkrestapi.service;

import java.util.ArrayList;

import org.junit.Ignore;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.testlinkrestapi.model.TestPlanBean;
import com.testlinkrestapi.model.constants.TestLinkParams;
import com.testlinkrestapi.model.constants.TestLinkResponse;
import com.testlinkrestapi.model.constants.TestLinkRestApis;
import com.testlinkrestapi.restclient.Response;
import com.testlinkrestapi.util.DataUtils;

import net.sf.json.JSON;


public class MiscService extends BaseService {
	
	public MiscService(String restBaseUrl,String devKey) {
		super(restBaseUrl,devKey);
		// TODO Auto-generated constructor stub
	}
	public String who(){
	String result=getRestClient().get(getRestBaseUrl()+TestLinkRestApis.WHO);
	
	return result;
    }
	public String whoami(){
	String result=getRestClient().get(getRestBaseUrl()+TestLinkRestApis.WHOAMI);
	return result;
    }
	
}
