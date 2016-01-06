package com.testlinkrestapi.service;

import com.testlinkrestapi.restclient.RestClient;

public abstract class BaseService {
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
	 * TestLink REST API  url.
	 */
	protected String restUrl;
	
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
		this.restUrl=setRestUrl();
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
	
	 protected  abstract  String setRestUrl();
	
	protected String getRestUrl(){
		return restUrl;
	}
	
	protected String doPost(String string){
		return getRestClient().post(getRestUrl(), string);
	}
	
}
