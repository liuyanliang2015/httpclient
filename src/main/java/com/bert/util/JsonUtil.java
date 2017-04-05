package com.bert.util;

import com.google.gson.Gson;

public class JsonUtil {
	public static  Gson g = new Gson();

	private JsonUtil(){}

	public static <T> T parseObject(String json,Class<T> clazz){
		return g.fromJson(json, clazz);
	}

	public static String toJSONString(Object object){
		return g.toJson(object);
	}
}
