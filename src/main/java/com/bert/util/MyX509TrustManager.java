/**
 * 文件名:MyX509TrustManager.java 
 * 工程名：lsp
 * 包名:com.lzz.lsp.psi.util
 * 作者:LiuYanliang
 * 创建时间:2016年9月21日
 * Copyright (C) 2016 绿蜘蛛科技有限公司
 */
package com.bert.util;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

/**
 * 证书信任管理器（用于https请求）
 * @author liuyanliang
 * 
 */
public class MyX509TrustManager implements X509TrustManager {
	public void checkClientTrusted(X509Certificate[] chain, String authType)
			throws CertificateException {
	}

	public void checkServerTrusted(X509Certificate[] chain, String authType)
			throws CertificateException {
	}

	public X509Certificate[] getAcceptedIssuers() {
		return null;
	}
}
