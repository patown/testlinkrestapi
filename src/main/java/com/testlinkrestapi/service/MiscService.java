package com.testlinkrestapi.service;


import com.testlinkrestapi.model.constants.TestLinkRestApis;



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
	@Override
	protected String setRestUrl() {
		// TODO Auto-generated method stub
		return getRestBaseUrl();
	}
	
}
