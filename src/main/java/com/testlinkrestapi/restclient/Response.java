package com.testlinkrestapi.restclient;


import com.testlinkrestapi.model.constants.TestLinkResponse;
import com.testlinkrestapi.util.Util;

import net.sf.json.JSONObject;

public class Response {
 
private String status;
private String message;
//private String item;
private String response;
private JSONObject jsonObj;//=new JSONObject();
	public Response(String response){
		this.response=response;
		processResponse();
	}
	
	public String getStatus() {
		return status;
	}
	public String getMessage() {
		return message;
	}
	
	private void setStatus(String status) {
		this.status = status;
	}
	public void setMessage(String message) {
		this.message = message;
	}
//	public String getItem() {
//		return item;
//	}
//	private void setItem(String item) {
//		this.item = item;
//	}
	
	public boolean IsResponseOK(){
		return TestLinkResponse.OK.toString().equalsIgnoreCase(getStatus()) && TestLinkResponse.OK.toString().equalsIgnoreCase(getMessage());
	}
	
	
	private void processResponse(){
		jsonObj =Util.decode2JSON(response);	
		if(null!=jsonObj){
		setStatus(jsonObj.getString(TestLinkResponse.STATUS.toString()));
		setMessage(jsonObj.getString(TestLinkResponse.MESSAGE.toString()));
		}
	}

	public Integer getInt(String key){
		Integer value=null;
		if(IsResponseOK()){
		value=	jsonObj.getInt(key);
		System.out.println("key["+key+"]='"+value+"'");
		}
		return value;
	}
}
