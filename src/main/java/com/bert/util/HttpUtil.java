package com.bert.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;



/**
 * HTTP请求工具类
 * @author LiuYanliang
 */
public class HttpUtil {

	public static final String CHARSET = "UTF-8";

	
	/**
	 * HTTPS请求
	 * LiuYanliang
	 * @param requestUrl  请求地址
	 * @param requestMethod 请求方法 post/get
	 * @param params 请求参数map
	 * @return 
	 * 2017年4月5日 下午1:38:39
	 */
	public static JSONObject httpsRequest(String requestUrl,String requestMethod, Map<String, String> params) {
		JSONObject jsonObject = null;
		try {
			if (params != null && !params.isEmpty()) {
				List<NameValuePair> pairs = new ArrayList<NameValuePair>(params.size());
				for (String key : params.keySet()) {
					pairs.add(new BasicNameValuePair(key, params.get(key).toString()));
				}
				requestUrl += "?"+ EntityUtils.toString(new UrlEncodedFormEntity(pairs,CHARSET));
			}

			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			javax.net.ssl.SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setSSLSocketFactory(ssf);

			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			conn.setRequestMethod(requestMethod);

			// 从输入流读取返回内容
			InputStream inputStream = conn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String str = null;
			StringBuffer buffer = new StringBuffer();
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}

			// 释放资源
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			inputStream = null;
			conn.disconnect();
			
			jsonObject  = new JSONObject(buffer.toString());
			
		} catch (ConnectException ce) {
			System.err.println(ce);
		} catch (Exception e) {
			System.err.println(e);
		}
		return jsonObject;
	}

	
	/**
	 * HTTP请求
	 * LiuYanliang
	 * @param requestUrl  请求地址
	 * @param requestMethod 请求方法 post/get
	 * @param params 请求参数map
	 * @return 
	 * 2017年4月5日 下午1:39:45
	 */
	public static JSONObject httpRequest(String requestUrl, String method,
			Map<String, String> params) {
		JSONObject jsonObject = null;
		try {

			if (params != null && !params.isEmpty()) {
				List<NameValuePair> pairs = new ArrayList<NameValuePair>(params.size());
				for (String key : params.keySet()) {
					pairs.add(new BasicNameValuePair(key, params.get(key).toString()));
				}
				requestUrl += "?"+ EntityUtils.toString(new UrlEncodedFormEntity(pairs,CHARSET));
			}

			URL url = new URL(requestUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			conn.setRequestMethod(method);
			// 从输入流读取返回内容
			InputStream inputStream = conn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String str = null;
			StringBuffer buffer = new StringBuffer();
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}

			// 释放资源
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			inputStream = null;
			conn.disconnect();
			jsonObject = new JSONObject(buffer.toString());
		} catch (ConnectException ce) {
			System.err.println(ce);
		} catch (Exception e) {
			System.err.println(e);
		}
		return jsonObject;
	}

}
