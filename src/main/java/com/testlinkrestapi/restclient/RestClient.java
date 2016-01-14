/**
 * Testlink-rest-client - a simple TestLink REST client
 * Copyright (c) 2015 Antony Chen (dongyan_guai@hotmail)
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.

 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

package com.testlinkrestapi.restclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.xml.bind.DatatypeConverter;

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;



public class RestClient {
	private String username;
	private String password;
	private HttpClient httpClient;
	private HttpResponse response;
	
	public RestClient(String username,String password){
		this.username=username;
		this.password=password;
		httpClient=HttpClientBuilder.create().build();
	}
	
	public RestClient(HttpClient httpClient,String username,String password){
		this(username,password);
		this.httpClient=httpClient;
	}

    
    //static List<Cookie> cookies;
    private String cookies;
    private HttpResponse doGet(String url){
        HttpGet getRequest = new HttpGet(url);
        getRequest=(HttpGet) auth(getRequest,username,password);
        HttpResponse response =null;
		try {
			response = httpClient.execute(getRequest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return response;
    }
    
    public JSON request(String url){
    	String result =get(url);
    	return null!=result ? JSONSerializer.toJSON(result): null;

    }
    
    public String get(String url){
    	String result=null;
    	 HttpGet get = new HttpGet(url);
    	 try {
		result =request(auth(get, username, password));
		} catch (RestException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 System.out.println("url------>"+url+"\nresult--->"+result);
    	 return result;
    }
    
    public String post(String url,String string){

        HttpPost post = new HttpPost(url);
        StringEntity entity;
        String result=null;
        try {
		entity = new StringEntity(string);
        post.setEntity(entity);

       
			result = doRequest(auth(post, username, password));
		} catch (RestException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	 System.out.println("url------>"+url+"\nrequest-->"+string+"\nresult--->"+result);
        return result;
}
    
//    public HttpResponse post(String url,StringEntity entity){
//
//            HttpPost httpost = new HttpPost(url);
//            httpost.setEntity(entity);
//
//            HttpResponse response=null;
//			try {
//				response = httpClient.execute(httpost);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//        
//            return response;
//    }
    
    private String request(HttpUriRequest request,String username, String password) throws RestException, IOException{
    	return request(auth(request, username, password));
    }
    
    private String request(HttpUriRequest req) throws RestException, IOException {
        req.addHeader("Accept", "application/json");
        HttpResponse resp = httpClient.execute(req);
        HttpEntity ent = resp.getEntity();
        StringBuilder result = new StringBuilder();

        if (ent != null) {
            String encoding = null;
            if (ent.getContentEncoding() != null) {
            	encoding = ent.getContentEncoding().getValue();
            }
            
            if (encoding == null) {
    	        Header contentTypeHeader = resp.getFirstHeader("Content-Type");
    	        HeaderElement[] contentTypeElements = contentTypeHeader.getElements();
    	        for (HeaderElement he : contentTypeElements) {
    	        	NameValuePair nvp = he.getParameterByName("charset");
    	        	if (nvp != null) {
    	        		encoding = nvp.getValue();
    	        	}
    	        }
            }
            
            InputStreamReader isr =  encoding != null ?
                new InputStreamReader(ent.getContent(), encoding) :
                new InputStreamReader(ent.getContent());
            BufferedReader br = new BufferedReader(isr);
            String line = "";

            while ((line = br.readLine()) != null)
                result.append(line);
        }

        StatusLine sl = resp.getStatusLine();

        if (sl.getStatusCode() >= 300)
            throw new RestException(sl.getReasonPhrase(), sl.getStatusCode(), result.toString());
        return result.length() > 0 ? result.toString(): null;
        
        //return result.length() > 0 ? JSONSerializer.toJSON(result.toString()): null;
    }
    
    private String doRequest(HttpUriRequest req) throws RestException, IOException {
        req.addHeader("Accept", "application/json");
        HttpResponse resp = httpClient.execute(req);
        HttpEntity ent = resp.getEntity();
        StringBuilder result = new StringBuilder();

        if (ent != null) {
            String encoding = null;
            if (ent.getContentEncoding() != null) {
            	encoding = ent.getContentEncoding().getValue();
            }
            
            if (encoding == null) {
    	        Header contentTypeHeader = resp.getFirstHeader("Content-Type");
    	        HeaderElement[] contentTypeElements = contentTypeHeader.getElements();
    	        for (HeaderElement he : contentTypeElements) {
    	        	NameValuePair nvp = he.getParameterByName("charset");
    	        	if (nvp != null) {
    	        		encoding = nvp.getValue();
    	        	}
    	        }
            }
            
            InputStreamReader isr =  encoding != null ?
                new InputStreamReader(ent.getContent(), encoding) :
                new InputStreamReader(ent.getContent());
            BufferedReader br = new BufferedReader(isr);
            String line = "";

            while ((line = br.readLine()) != null)
                result.append(line);
        }
      //  System.out.println(result.toString());
        StatusLine sl = resp.getStatusLine();

        if (sl.getStatusCode() >= 300)
            throw new RestException(sl.getReasonPhrase(), sl.getStatusCode(), result.toString());

        return result.length() > 0 ? result.toString(): null;
    }
    
    private HttpUriRequest auth(HttpUriRequest request,String username,String password){
    	  String encoding;
		try {
			encoding = DatatypeConverter.printBase64Binary((username+":"+password).getBytes("UTF-8"));
    	     request.setHeader("Authorization", "Basic " + encoding);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return request;
    }
    
 
    public String getCookies() {
    	return cookies;
      }

      public void setCookies(String cookies) {
    	this.cookies = cookies;
      }
}
