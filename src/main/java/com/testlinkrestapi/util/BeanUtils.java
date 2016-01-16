/*
 * The MIT License
 *
 * Copyright (c) <2010> <Antony Chen>
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
import java.util.ArrayList;
import java.util.List;
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
import com.testlinkrestapi.restclient.Response;



/**
 * Utility class with methods to convert beans.
 *
 * @author Antony Chen
 * @since 1.9.14
 */
public final class BeanUtils {
    
//    private static final Logger log = Logger.getLogger(Util.class.getName());

    private BeanUtils() {
    }

 

    
    /**
     * @param  TestProjectRspBean
     * @return TestProjectBean.
     */
    public static final TestProjectBean getTestProjectBeanFromTestProjectRspBean(TestProjectRspBean rspBean) {
    	TestProjectBean tpBean =new TestProjectBean();
     	tpBean.setId(rspBean.getId())
    	.setName(rspBean.getName())
    	.setPrefix(rspBean.getPrefix())
    	.setNotes(rspBean.getNotes())
    	.setActive(DataUtils.getInt(rspBean.getActive()))
    	.setIs_public(DataUtils.getInt(rspBean.getIs_public()))
    	//.setOptions(rspBean.getOpt())
    	.setColor(rspBean.getColor());
    	return tpBean;
    }
    /**
     * @param  ArrayList<TestProjectBean>,ArrayList<TestProjectBean>
     * @return TestProjectBean.
     */	
    public static final TestProjectBean getDeltaTestProject(ArrayList<TestProjectBean> before, ArrayList<TestProjectBean> after){
		TestProjectBean bean = new TestProjectBean();
		int detla=after.size()-before.size();
		if(detla==1){
			bean=after.get(after.size()-1);
		}
		return bean;
	}
    
    /**
     * @param  TestProjectRspBean
     * @return TestProjectBean.
     */
    public static final ArrayList<TestProjectBean> getTestProjectBeanListFromTestProjectsRsp(List<TestProjectsRspBean> beanList) {
    	ArrayList<TestProjectBean> projBeanList =new ArrayList<TestProjectBean>();
     	 for(int i=0;i<beanList.size();i++){
     		TestProjectBean bean = new TestProjectBean();
     		 if(null!=beanList.get(i)){
     			bean=getTestProjectBeanFromTestProjectRspBean(beanList.get(i));
     		 }
     		projBeanList.add(bean);
     	 }
    	return projBeanList;
    }

    /**
     * @param  Json String of Test Project Options.
     * @return Options
     */
    public static final Options getOptions(String string) {
    	Options options =(Options) getBeanfromString(string, Options.class);
    	return options;
    }
    
	public static <T> T getBeanfromString(String string, Class<T> clazz)  {
    			JSONObject item=JSONObject.fromObject(string);
	    		return (T) JSONObject.toBean(item,clazz);
	    	}
 
    private static Integer getInt(String string){
    	return Integer.parseInt(string);
    }

    


}
