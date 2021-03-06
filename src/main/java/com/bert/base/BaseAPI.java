/**
 * 文件名:BaseAPI.java 
 * 作者:LiuYanliang
 * 创建时间:2017年4月3日
 */
package com.bert.base;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.entity.ContentType;
import org.apache.http.message.BasicHeader;

/**
 * 基础API
 * @author LiuYanliang	
 */
public abstract class BaseAPI {
	protected static Header jsonHeader = new BasicHeader(HttpHeaders.CONTENT_TYPE,ContentType.APPLICATION_JSON.toString());
	protected static Header xmlHeader = new BasicHeader(HttpHeaders.CONTENT_TYPE,ContentType.APPLICATION_XML.toString());
	protected static Header htmlHeader = new BasicHeader(HttpHeaders.CONTENT_TYPE,ContentType.TEXT_HTML.toString());
	protected static Header streamHeader = new BasicHeader(HttpHeaders.CONTENT_TYPE,ContentType.APPLICATION_OCTET_STREAM.toString());
	protected static Header formHeader = new BasicHeader(HttpHeaders.CONTENT_TYPE,ContentType.APPLICATION_FORM_URLENCODED.toString());
}
