package com.testlinkrestapi;



import net.sf.json.JSON;
import net.sf.json.JSONObject;

import com.testlinkrestapi.model.Response;
import com.testlinkrestapi.restclient.RestClient;

public class TLRestClient {

    static String username = "admin";
    static String password = "admin";
    static String baseURL = "http://localhost/testlink";
	private static String loginURL=baseURL+"/login.php";
	private static String restpath=baseURL+"/lib/api/rest/v1/";
    static String testprojects = restpath+"testprojects";
    private static String who=restpath+"who";
    private static String whoAmI=restpath+"whoAmI";
    
    static String testcases = "testcases";

    private static final String PHP_AUTH_USER="PHP_AUTH_USER";
    private static String cookiePHP_AUTH_USER=null;
    private static String key="996e36ad56718a4b0238c1f0310e00e4";
    private RestClient restClient;
    
    private String testplanString=restpath+"/testplans/304";
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
	}


	

        
	public static void main(String[] args) {
    	TLRestClient sample;
		try {
			sample = new TLRestClient(baseURL, key, "iamapawword");

		//sample.testCasesInProject("2");
    	//sample.testProjects();
    	//sample.who();
    	sample.whoAmI();
			sample.testPlans();
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
		JSON json=restClient.post(testplanString, string);
        System.out.println(json.toString());
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
