package com.bert.client;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;

public class StringResponseHandler{

	public static ResponseHandler<String> ResponseHandler(){

		ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
			@Override
			public String handleResponse(HttpResponse response)
					throws ClientProtocolException, IOException {
				int status = response.getStatusLine().getStatusCode();
				if (status >= 200 && status < 300) {
					HttpEntity entity = response.getEntity();
					String str = EntityUtils.toString(entity);
					return str;
				} else {
					throw new ClientProtocolException("Unexpected response status: " + status);
				}
			}
		};
		return responseHandler;
	}

}
