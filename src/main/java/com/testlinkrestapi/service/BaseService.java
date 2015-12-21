package com.testlinkrestapi.service;

import com.testlinkrestapi.restclient.RestClient;

public class BaseService {
	/**
	 * REST client.
	 */
	private RestClient restClient;
	
	/**
	 * TestLink User devkey.
	 */
	private String devKey;
	
	/**
	 * TestLink REST API base url.
	 */
	private String restBaseUrl;
	
	/**
	 * @param restClient
	 *            XML-RPC Client.
	 * @param devKey
	 *            TestLink user DevKey.
	 */
	public BaseService(String restBaseUrl, String devKey) {
		this.devKey = devKey;
		this.restBaseUrl=restBaseUrl;
		this.restClient = new RestClient(devKey,devKey);
	}

	protected RestClient getRestClient(){
		return restClient;
	}
	protected String getRestBaseUrl(){
		return restBaseUrl;
	}
	
	public void resetRestClient(String devkey){
		this.restClient=new RestClient(devKey, devKey);
	}
	
}
