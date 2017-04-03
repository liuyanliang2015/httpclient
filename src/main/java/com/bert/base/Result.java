/**
 * 文件名:Result.java 
 * 工程名：asfp-server
 * 包名:com.lzz.asfp.api
 * 作者:Administrator
 * 创建时间:2017年3月23日
 * Copyright (C) 2017 绿蜘蛛科技有限公司
 */
package com.bert.base;
/**
 * 接口返回结果
 * @author Administrator	
 */
public class Result {
	private Object data;
	private int errorCode;
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
	
}
