package com.test;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.junit.Test;

import com.bert.base.BaseAPI;
import com.bert.base.Result;
import com.bert.client.LocalHttpClient;
import com.google.gson.Gson;

public class TestApi extends BaseAPI {

	private static final String host = "http://localhost";
	private static final Gson g = new Gson();
	
	
	public static String outPutString(String name, Integer age) {
		HttpUriRequest request = RequestBuilder
				.post()
				.setHeader(formHeader)
				//.setHeader("Content-type", "application/x-www-form-urlencoded")
				.setUri(host + "/test/hello.do")
				.addParameter("name", name).
				addParameter("age", age + "")
				.build();
		return LocalHttpClient.executeString(request);
	}
	
	
	public static Result outPutJson(String name, Integer age) {
		HttpUriRequest request = RequestBuilder
				.post()
				.setHeader(formHeader)
				//.setHeader("Content-type", "application/x-www-form-urlencoded")
				.setUri(host + "/test/hello.do")
				.addParameter("name", name).
				addParameter("age", age + "")
				.build();
		return LocalHttpClient.executeJson(request, Result.class);
	}
	
	@Test
    public void testOutPutString(){
		System.out.println(outPutString("liuyanliang", 18));
    }
	
	
	@Test
    public void testOutPutJson(){
		System.out.println(outPutJson("liuyanliang", 18));
		System.out.println(g.toJson(outPutJson("liuyanliang", 18)));
    }
	
	
}
