package br.com.controlealuno.util;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class JSONUtil {
	
	private static final String TYPE_JSON = "application/json; charset=UTF-8";
	
	public static void writeJsonResponse(JSONObject json, HttpServletResponse response) {
		writeResponse(json.toString(), TYPE_JSON, response);
	}
	
	private static void writeResponse(String message, String contentType, HttpServletResponse response) {
		response.setHeader("Content-Type", contentType);
		try {
			ServletOutputStream out = response.getOutputStream();
			out.write(message.getBytes("UTF-8"));
			out.flush();
			out.close();
			response.setStatus(HttpServletResponse.SC_OK);
		} catch (IOException e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}
}
