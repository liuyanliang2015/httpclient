package com.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.json.JSONObject;
import org.junit.Test;

import com.bert.base.BaseAPI;
import com.bert.base.Result;
import com.bert.client.LocalHttpClient;
import com.bert.util.HttpUtil;
import com.google.gson.Gson;

/**
 * 单元测试
 * @author LiuYanliang
 */
public class TestApi extends BaseAPI {

	private static final String host = "http://192.168.0.7:9090/asfp-server";
	private static final Gson g = new Gson();
	
	
	/**
	 * 输出字符串
	 * @param name
	 * @param age
	 * 
	 * 116.318393,40.041916
	 * @return
	 */
	@Test
	public  void testHttpClientString() {
		HttpUriRequest request = RequestBuilder
				.post()
				.setHeader(formHeader)
				.setUri(host + "/gas/getNearByStores.do")
				.addParameter("accessToken", "cf8918f60571a1baf5b6d373e9c1df74")
				.addParameter("lng",  "116.318393")
				.addParameter("lat",  "40.041916")
				.build();
			System.out.println(LocalHttpClient.executeString(request));
	}
	
	/**
	 * 输出json对象
	 * @param name
	 * @param age
	 * @return
	 */
	@Test
	public  void testHttpClientJson() {
		HttpUriRequest request = RequestBuilder
				.post()
				.setHeader(formHeader)
				.setUri(host + "/gas/getNearByStores.do")
				.addParameter("accessToken", "cf8918f60571a1baf5b6d373e9c1df74")
				.addParameter("lng",  "116.318393")
				.addParameter("lat",  "40.041916")
				.build();
		System.out.println(LocalHttpClient.executeJson(request, Result.class));
	}
	
	
	@Test
	public  void testHttpUtil() {
		Map <String,String> map = new HashMap<String,String>();
		map.put("accessToken", "cf8918f60571a1baf5b6d373e9c1df74");
		map.put("lng", "116.318393");
		map.put("lat",  "40.041916");
		JSONObject obj  =HttpUtil.httpRequest(host + "/gas/getNearByStores.do", "POST", map);
		System.out.println(g.toJson(obj));
	}
	
	
	
	
	
	
	
	
	
}
