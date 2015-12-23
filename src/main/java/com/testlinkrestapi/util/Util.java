/*
 * The MIT License
 *
 * Copyright (c) <2010> <Bruno P. Kinoshita>
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


import java.util.logging.Logger;

import net.sf.json.JSON;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import org.apache.commons.lang.StringUtils;

import com.testlinkrestapi.model.TestPlanBean;
import com.testlinkrestapi.model.constants.TestLinkParams;
import com.testlinkrestapi.restclient.Response;



/**
 * Utility class with methods to handle the response or prepare the request to the PHP REST API. This class is able
 * to convert from a json string to an Object and vice-versa.
 *
 * @author Antony Chen
 * @since 1.9.14
 */
public final class Util {
    
//    private static final Logger log = Logger.getLogger(Util.class.getName());

    private Util() {
    }

 
    public static JSON getJSON(String jsonString){
        return (null !=jsonString && jsonString.length()> 0 ) ? JSONSerializer.toJSON(jsonString): null;
    }



    /**
     * @param TestPlanBean
     * @return Json String of Test Plan.
     */
    public static final String getJSONTestPlan(TestPlanBean plan) {
 		JSONObject jo = new JSONObject();
 		jo.put(TestLinkParams.ISACTIVE, plan.getIsActive()==true?1:0);
 		jo.put(TestLinkParams.ISPUBLIC, plan.getIsPublic()==true?1:0);
 	  	jo.put(TestLinkParams.NAME,plan.getName());
 	  	jo.put(TestLinkParams.TEST_PROJECT_ID, plan.getTestprojectID());
 	  	jo.put(TestLinkParams.NOTES, plan.getNotes());
 	  	return jo.toString();
    }
    /**
     * @param TestPlanBean
     * @return Json String of Test Plan to be edited.
     */
    public static final String getJSONTestPlanEdit(TestPlanBean plan) {
 		JSONObject jo = new JSONObject();
 		if(null !=plan.getIsActive()){
 		jo.put(TestLinkParams.ISACTIVE, plan.getIsActive()==true?1:0);
 		}
 		if(null !=plan.getIsPublic()){
 			jo.put(TestLinkParams.ISPUBLIC, plan.getIsPublic()==true?1:0);
 		}
 		if(null !=plan.getName()){
 	 	  	jo.put(TestLinkParams.NAME,plan.getName());
 		}
 		if(null !=plan.getTestprojectID()){
 	 	  	jo.put(TestLinkParams.TEST_PROJECT_ID, plan.getTestprojectID());
 		}
 		if(null !=plan.getNotes()){
 	 	  	jo.put(TestLinkParams.NOTES, plan.getNotes());
 		}
 		//System.out.println(jo.toString());
  	  	return jo.toString();
    }
    
    public static JSONObject decode2JSON(String jsonString){
    	//{"status":"ok","message":"ok","id":18}
    	JSONObject jsonObj = new JSONObject();
    	if (jsonString !=null){
    		jsonObj =JSONObject.fromObject(jsonString);
        //.getJSONArray("item").toString());
    	}	
    	return jsonObj;
    }
    
    
 
    


}
