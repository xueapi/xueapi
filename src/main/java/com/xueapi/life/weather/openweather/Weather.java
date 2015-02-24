package com.xueapi.life.weather.openweather;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.xueapi.util.HttpGetClient;

public class Weather {
	
	private static final Log log = LogFactory.getLog(Weather.class);
	
	private static final String AppId = "xxxxxxxxxxxxxx";  //此处替换成你的AppId

    //密钥
	private static final String Private_Key = "xxxxxx_SmartWeatherAPI_xxxxxxx";  //此处替换成你的Private_Key

	public String getWeatherInfo(String areaid, String type, String date){
		String dateStr = "http://open.weather.com.cn/data/?areaid=" + areaid + "&type=" + type + "&date=" + date;
		//需要加密的数据
        String data = dateStr + "&appid=" + AppId;        
        String key = StandardURLEncoder.encoder(data, Private_Key);
        String url = dateStr + "&appid=" + AppId.substring(0, 6) + "&key=" + key;

		log.info("url = " + url);
        HttpGetClient client = new HttpGetClient();
        String content = client.getWeatherInfo(url);
		
		return content;

	}

}
