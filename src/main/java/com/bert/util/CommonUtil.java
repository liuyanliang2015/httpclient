package com.bert.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class CommonUtil {
	public static List<Integer> changeStringToList(String attIds){
		if(StringUtils.isNotBlank(attIds)){
			List<Integer> idList = new ArrayList<Integer>();
			for(String id:attIds.split(",")){
				idList.add(Integer.parseInt(id));
			}
			return idList;
		}
		return null;
	}
	
	

	public static byte[] getByteByInputStream(InputStream fileInputStream) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int read = 0;
		byte[] bytes = new byte[1024];

		try {
			while ((read = fileInputStream.read(bytes)) != -1) {
				baos.write(bytes, 0, read);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		byte[] array0 = baos.toByteArray();

		return array0;

	}
}
