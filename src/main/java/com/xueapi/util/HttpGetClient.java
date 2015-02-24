package com.xueapi.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;

public class HttpGetClient {
	
	private static String charset = "utf-8";

	public String getWeatherInfo(String url) {
		return getWeatherInfo(url, charset);
	}

	public String getWeatherInfo(String url, String charset) {

		HttpClient client = new HttpClient();
		GetMethod httpGet = null;
		httpGet = new GetMethod(url);
		StringBuffer buffer = null;
		try {
			client.executeMethod(httpGet);
			InputStream in = httpGet.getResponseBodyAsStream();
			InputStreamReader inputStreamReader = new InputStreamReader(in, charset);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			// 读取返回结果
			buffer = new StringBuffer();
			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}

			bufferedReader.close();
			inputStreamReader.close();
			in.close();
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			httpGet.releaseConnection();
		}
		
		return buffer.toString();

	}

}
