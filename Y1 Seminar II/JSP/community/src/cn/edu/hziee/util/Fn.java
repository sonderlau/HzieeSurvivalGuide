package cn.edu.hziee.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

public class Fn {
	
	/**
	 * 获取当前时间的时间戳，单位秒
	 * 
	 * @return
	 */
	public static int time() {
		Long time = System.currentTimeMillis() / 1000;
		return time.intValue();
	}

	/**
	 * 格式化时间戳成日期时间
	 * 
	 * @param timestamp
	 * @param format
	 * @return
	 */
	public static String date(int timestamp, String... format) {
		if (timestamp == 0) {
			return " - "; // 无数据
		}
		String formatString = "yyyy-MM-dd HH:mm:ss";
		if (format.length == 1) {
			formatString = format[0];
		}
		SimpleDateFormat sdf = new SimpleDateFormat(formatString);
		return sdf.format(new Date(timestamp * 1000L));
	}
	
	/**
	 * 乱码处理
	 * @param temp
	 * @return
	 */
	public static String GBK(String temp){
		try {
			return new String(temp.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
		}
		return "";
	}
	
	public static void ajaxReturn(HttpServletResponse response,Object data,String info,String status){
		Map<String, Object> jsonData = new HashMap<String, Object>();
		jsonData.put("data", data);
		jsonData.put("info", info);
		jsonData.put("status", status);
		render(response, JSON.toJSONString(jsonData), "json");
	}
	
	public static void render(HttpServletResponse response, 
			String text, String... contentType) {

				response.setContentType("text/html");
				response.setCharacterEncoding("UTF-8");
				response.setHeader("Cache-Control", "no-cache");
				response.setDateHeader("Expires", 0);
				PrintWriter out = null;
				try {
					out = response.getWriter();
					out.write(text);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					out.close();
				}
			}

}
