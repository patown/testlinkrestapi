package restapi.testproject;




import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.testlinkrestapi.TLException;
import com.testlinkrestapi.model.Options;
import com.testlinkrestapi.model.TestPlanBean;
import com.testlinkrestapi.model.TestProjectBean;
import com.testlinkrestapi.model.TestProjectRspBean;

import com.testlinkrestapi.restclient.Response;
import com.testlinkrestapi.restclient.RestClient;
import com.testlinkrestapi.service.TestPlanService;
import com.testlinkrestapi.service.TestProjectService;

public class GetTestProject {

    static String baseURL = "http://localhost/testlink1914";
	private static String restpath=baseURL+"/lib/api/rest/v1/";

   // private static String devKey="40f388699bf787b88f92030f6caff55f";
    private static String devKey="0dcfc5b0ef5e5df6c7fc4fa9a3b9df95";
    
    TestProjectBean project= new TestProjectBean();
    Options options = new Options();
  	TestProjectService	tpService = new TestProjectService(restpath, devKey);
  	

	@Test
	public void TestGetTestProject(){
    	String res=tpService.getTestProject(1);
    	JSONObject item=JSONObject.fromObject(res).getJSONObject("item");
    	TestProjectRspBean bean =(TestProjectRspBean) JSONObject.toBean(item, TestProjectRspBean.class);
    	System.out.println(JSONObject.fromObject(bean).toString());
	}
    	@Ignore	
	@Test
	public void TestGetTestProjects(){
       	String res=tpService.getTestProjects();
    	System.out.println(res);
    	JSONArray jsonArray =JSONObject.fromObject(res).getJSONArray("item");
    	List<TestProjectsRspBean> beanList = new ArrayList<TestProjectsRspBean>();
    	for(int i=0;i<jsonArray.size();i++){
    		System.out.println(jsonArray.getString(i));
    		JSONObject obj=JSONObject.fromObject(jsonArray.getString(i));
    		TestProjectsRspBean bean =(TestProjectsRspBean) JSONObject.toBean(obj,TestProjectsRspBean.class);
        	beanList.add(bean);
    	}
    	
    	System.out.println(beanList.get(1).getName());
	}
	
}
