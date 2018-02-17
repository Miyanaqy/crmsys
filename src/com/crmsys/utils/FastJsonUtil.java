package com.crmsys.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class FastJsonUtil {
	
	public static String toJson(Object object) {
		return JSON.toJSONString(object, SerializerFeature.DisableCircularReferenceDetect);
	}
	
	public static void writeJson(HttpServletResponse response, String json) {
		response.setContentType("application/json;utf-8");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().print(json);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
