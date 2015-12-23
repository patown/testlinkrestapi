package restclient;

import junit.framework.Assert;

import org.junit.Test;

import com.testlinkrestapi.restclient.Response;

public class TestResponse {
	private static final String responseString= "{\"status\":\"ok\",\"message\":\"ok\",\"id\":18}";
	@Test
	public void TestResesponseStatus(){
		Response response = new Response(responseString);
		Assert.assertEquals(response.getStatus(),"ok");
	}
	@Test
	public void TestResesponseMessage(){
		Response response = new Response(responseString);
		Assert.assertEquals(response.getMessage(),"ok");
	}	
	@Test
	public void TestIsResponseOK(){
		Response response = new Response(responseString);
		Assert.assertTrue(response.IsResponseOK());
	}	
	
	
	
	
	}
