package com.bert.client;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;

import com.bert.util.CommonUtil;

public class StreamResponseHandler{

	public static ResponseHandler<byte[]> ResponseHandler(){

		ResponseHandler<byte[]> responseHandler = new ResponseHandler<byte[]>() {
			@Override
			public byte[] handleResponse(HttpResponse response)
					throws ClientProtocolException, IOException {
				int status = response.getStatusLine().getStatusCode();
				if (status >= 200 && status < 300) {
					HttpEntity entity = response.getEntity();
					return CommonUtil.getByteByInputStream(entity.getContent());
				} else {
					throw new ClientProtocolException("Unexpected response status: " + status);
				}
			}
		};
		return responseHandler;
	}

}
