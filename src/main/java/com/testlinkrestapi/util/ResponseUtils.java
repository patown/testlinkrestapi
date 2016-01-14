/*
 * The MIT License
 *
 * Copyright (c) <2015> <Antony Chen>
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.testlinkrestapi.util;


import java.io.IOException;
import java.util.logging.Logger;

import net.sf.json.JSON;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import org.apache.commons.lang.StringUtils;

import com.testlinkrestapi.model.Options;
import com.testlinkrestapi.model.TestCaseBean;
import com.testlinkrestapi.model.TestPlanBean;
import com.testlinkrestapi.model.TestProjectBean;
import com.testlinkrestapi.model.TestProjectRspBean;
import com.testlinkrestapi.model.TestProjectsRspBean;
import com.testlinkrestapi.model.TestSuiteBean;
import com.testlinkrestapi.model.constants.TestLinkParams;
import com.testlinkrestapi.model.constants.TestLinkResponse;
import com.testlinkrestapi.restclient.Response;



/**
 * Utility class with methods to handle the response.
 *
 * @author Antony Chen
 * @since 1.9.14
 */
public final class ResponseUtils {
    
//    private static final Logger log = Logger.getLogger(Util.class.getName());


//	public static String getStatus(String response)  { 
//		JSONObject item=JSONObject.fromObject(response).getJSONObject("item");
//	 	return   (T)JSONObject.toBean(item, clazz);
//  }
	
	public static JSONObject getJSONObj(String response,String key)  { 
		JSONObject item=JSONObject.fromObject(response).getJSONObject(key);
	 	return item;
  }
	
	public static String getJSONString(String response,String key)  { 
		String item=JSONObject.fromObject(response).getString(key);
		System.out.println(key+"="+item);
	 	return item;
  }
	
	public static String getStatus(String response){
		return getJSONString(response,TestLinkResponse.STATUS.toString());
	}
	public static String getMessage(String response){
		return getJSONString(response,TestLinkResponse.MESSAGE.toString());
	}

	public static  boolean IsResponseOK(String response){
		return TestLinkResponse.OK.toString().equalsIgnoreCase(getStatus(response)) && TestLinkResponse.OK.toString().equalsIgnoreCase(getMessage(response));
	}
	
	public static Integer getID(String response){
		return DataUtils.getInt(getJSONString(response,TestLinkResponse.ID.toString()));
	}

	public static <T> T getItem2Bean(String response, Class<T> clazz) { 
		JSONObject item=JSONObject.fromObject(response).getJSONObject(TestLinkResponse.ITEM.toString());
	 	return   (T)JSONObject.toBean(item, clazz);
  }
	
	public static TestProjectRspBean getTestProjectRspBean(String response) {
		TestProjectRspBean bean = new TestProjectRspBean();
		if(IsResponseOK(response)){
		bean= getItem2Bean(response,TestProjectRspBean.class);
		}
		return bean ;
	}
	
	public static TestProjectsRspBean getTestProjectsRspBean(String response) {
		TestProjectsRspBean bean = new TestProjectsRspBean();
		if(IsResponseOK(response)){
		bean= getItem2Bean(response,TestProjectsRspBean.class);
		}
		return bean ;
	}
	
    }
    
    



