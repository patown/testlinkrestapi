package com.testlinkrestapi;


import net.sf.json.JSON;
import net.sf.json.JSONObject;

import com.testlinkrestapi.model.TestPlanBean;
import com.testlinkrestapi.model.constants.TestLinkRestApis;
import com.testlinkrestapi.restclient.Response;
import com.testlinkrestapi.restclient.RestClient;
import com.testlinkrestapi.service.TestPlanService;
import com.testlinkrestapi.util.DataUtils;

public class TLRestClient {

    static String username = "admin";
    static String password = "admin";
    static String baseURL = "http://localhost/testlink1914";
	private static String loginURL=baseURL+"/login.php";
	private static String restpath=baseURL+"/lib/api/rest/v2/";
    static String testprojects = restpath+"testprojects";
    private static String who=restpath+"who";
    private static String whoAmI=restpath+"whoAmI";
    
    static String testcases = "testcases";

    private static String key="40f388699bf787b88f92030f6caff55f";
    private RestClient restClient;
    private String TESTPLAN=restpath+TestLinkRestApis.TEST_PLANS;
    private String testplanString=restpath+"/testplans/304";
    
    private TestPlanService tpService;
    //TESTLINK_USER_AUTH_COOKIE=17b844ec7be41289d1cb94703d3ecfae21232f297a57a5a743894a0e4a801fc3
    
    /**
     * Creates an authenticated TestLink rest client.
     *
     * @param baseURL Base URI of the Testlink server
     * @param userName username to authenticate with. Use Testlink apikey for now.
     * @param password password to authenticate with. put whatever is ok. willl be ignored
     * @throws TLException 
     */
    public TLRestClient(String baseURL, String userName, String passWord) throws TLException {

    	this.restClient= new RestClient(userName,passWord);
     	this.tpService= new TestPlanService(restpath,key);
	}


	

        
	public static void main(String[] args) {
    	TLRestClient sample;
		try {
			sample = new TLRestClient(baseURL, key, "iamapawword");

		//sample.testCasesInProject("2");
    	//sample.testProjects();
    	//sample.who();
    	//sample.whoAmI();
			
			TestPlanBean tp= new TestPlanBean();
		  	tp.setIsActive(true);
		  	tp.setIsPublic(true);
		  	tp.setName("tp0007");
		  	tp.setTestrojectID(1).setNotes("notes");
			
			//sample.CreateTestPlan();
			sample.CreateTestPlanByService(tp);
		//	sample.testPlans();
    		} catch (TLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
    	
    }
    
   
	public void testPlans(){
		
		JSONObject jo = new JSONObject();
		jo.put("active", "1");
		jo.put("is_open", "0");
	  	jo.put("is_public", "0");
		jo.toString();
//		JSONStringer js = new JSONStringer();
//            js.object();
//            js.key("active").value("0");
            String string =jo.toString();;
            System.out.println(testplanString+"\n"+string);
		String result=restClient.post(testplanString, jo.toString());
        System.out.println(result);
	}
 
    
    public void testProjects(){
    	
    	JSON json=restClient.request(testprojects);
        System.out.println(json.toString());
    	
//        Map classMap = new HashMap();
//        classMap.put("list", TestProject.class);
//        TestProjects projects = (TestProjects)JSONObject.toBean(JSONObject.fromObject(json),TestProjects.class , classMap);
        System.out.println((JSONObject.fromObject(json)).getJSONArray("item").toString());
         Response response = (Response)JSONObject.toBean(JSONObject.fromObject(json),Response.class );
        System.out.println(response.getStatus());
//        System.out.println(response.getItem());
//        java.util.List<TestProject> prjList = (java.util.List<TestProject>) JSONObject.toBean(JSONObject.fromObject(response.getItem()),TestProject.class );
        
        
//        java.util.List<TestProject> prjList = projects.getItem();
//        for(TestProject proj : prjList){
//             
//                System.out.println(proj.getName());
//        }
        
        //        try {
//        	  
//
//            HttpResponse response =doGet(httpClient,testprojects);
//    
//            BufferedReader br = new BufferedReader(
//                    new InputStreamReader((response.getEntity().getContent())));
//
//            String output;
//            System.out.println("Output from Server .... \n");
//            while ((output = br.readLine()) != null) {
//       System.out.println(output);
//   }
//
//            
//            if (response.getStatusLine().getStatusCode() != 200) {
//                throw new RuntimeException("Failed : HTTP error code : "
//                   + response.getStatusLine().getStatusCode());
//            }
//        } catch (ClientProtocolException e) {
//            
//            e.printStackTrace();
//    
//          } catch (IOException e) {
//    
//            e.printStackTrace();
//          }
    }
    
    public TestPlanBean CreateTestPlan(TestPlanBean testplan){
    	String string =DataUtils.getJSONTestPlan(testplan);
		String result=restClient.post(TESTPLAN, string);
	  	System.out.println(result);//TODO:covert result to testplan
	  	return testplan;
    }
    
    public TestPlanBean CreateTestPlanByService(TestPlanBean testplan){
    	tpService.createTestPlan(testplan);
    	return testplan;
    }
    
	public void CreateTestPlan(){

//		JSONObject jo = new JSONObject();
//		jo.put("active", 1);
//		//jo.put("is_open", "0");
//	  	jo.put("is_public", 1);
//	  	jo.put("name","tp003");
//	  	//jo.put("name", "");
//	  	jo.put("testProjectID", 1);
//	  	jo.put("notes", "iamnotes");
//	  	//jo.put("api_key", "llll");
//	  	System.out.println(testplan);
//	  	System.out.println(jo.toString());
//	  	
//	  	JSON json=restClient.post(testplan, jo.toString());
//	  	System.out.println(json.toString());
		TestPlanBean tp=new TestPlanBean();
		tp.setName("tp006").setIsActive(true).setIsPublic(true).setNotes("iamnotes").setTestrojectID(1);

	  	System.out.println(CreateTestPlan(tp));
        
        
        
	  	
	  	tpService.createTestPlan(tp);
	  	
        
        //JSONObject.toBean(JSONObject.fromObject(json),Response.class
        
        
	}
    
	
	
	
	
    public void testCasesInProject(String projectID){
    	
    	JSON json=restClient.request(testprojects+"/"+projectID+"/testcases");
        System.out.println(json.toString());
    	
//        Map classMap = new HashMap();
//        classMap.put("list", TestProject.class);
//        TestProjects projects = (TestProjects)JSONObject.toBean(JSONObject.fromObject(json),TestProjects.class , classMap);
        System.out.println((JSONObject.fromObject(json)).getJSONArray("item").toString());
         Response response = (Response)JSONObject.toBean(JSONObject.fromObject(json),Response.class );
        System.out.println(response.getStatus());
//        System.out.println(response.getItem());
//        java.util.List<TestProject> prjList = (java.util.List<TestProject>) JSONObject.toBean(JSONObject.fromObject(response.getItem()),TestProject.class );
        
        
//        java.util.List<TestProject> prjList = projects.getItem();
//        for(TestProject proj : prjList){
//             
//                System.out.println(proj.getName());
//        }
        
        //        try {
//        	  
//
//            HttpResponse response =doGet(httpClient,testprojects);
//    
//            BufferedReader br = new BufferedReader(
//                    new InputStreamReader((response.getEntity().getContent())));
//
//            String output;
//            System.out.println("Output from Server .... \n");
//            while ((output = br.readLine()) != null) {
//       System.out.println(output);
//   }
//
//            
//            if (response.getStatusLine().getStatusCode() != 200) {
//                throw new RuntimeException("Failed : HTTP error code : "
//                   + response.getStatusLine().getStatusCode());
//            }
//        } catch (ClientProtocolException e) {
//            
//            e.printStackTrace();
//    
//          } catch (IOException e) {
//    
//            e.printStackTrace();
//          }
    }
    
    public void who(){
        System.out.println(restClient.request(who).toString());
    }
    
    public void whoAmI(){
//        try {
//        	  
//
//            HttpResponse response =doGet(httpClient,whoAmI);
//    
//            BufferedReader br = new BufferedReader(
//                    new InputStreamReader((response.getEntity().getContent())));
//
//            String output;
//            System.out.println("Output from Server .... \n");
//            while ((output = br.readLine()) != null) {
//       System.out.println(output);
    	
        System.out.println(restClient.request(whoAmI).toString());
//   }
//
//            
//            if (response.getStatusLine().getStatusCode() != 200) {
//                throw new RuntimeException("Failed : HTTP error code : "
//                   + response.getStatusLine().getStatusCode());
//            }
//        } catch (ClientProtocolException e) {
//            
//            e.printStackTrace();
//    
//          } catch (IOException e) {
//    
//            e.printStackTrace();
//          }
    }
    
 


}
