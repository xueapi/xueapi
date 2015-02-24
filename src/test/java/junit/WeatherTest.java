package junit;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.xueapi.life.weather.openweather.CityInfo;
import com.xueapi.life.weather.openweather.Weather;
import com.xueapi.life.weather.openweather.WeatherInfo;

import junit.framework.TestCase;

public class WeatherTest extends TestCase{
	
	private static final Log log = LogFactory.getLog(WeatherTest.class);
	
	private static final String FORMAT = "yyyyMMddHHmm";
	
	@Test
	public void testWeather(){
		// beijing 101010100
		SimpleDateFormat format = new SimpleDateFormat(FORMAT);
		String date = format.format(new Date());
		Weather w = new Weather();
		String json = w.getWeatherInfo("101010100", "forecast_f", date);
		log.info("json = " + json);
		Map map = JSONObject.parseObject(json, Map.class);
		CityInfo cityInfo = JSONObject.parseObject(map.get("c").toString(), CityInfo.class);
		Map f = JSONObject.parseObject(map.get("f").toString(), Map.class);
		String f0 = (String)f.get("f0");
		List<WeatherInfo> weatherInfoList = new ArrayList<WeatherInfo>();
		List list = JSONObject.parseObject(f.get("f1").toString(), List.class);
		for (int i = 0; i < list.size(); i++) {
			WeatherInfo info = JSONObject.parseObject(list.get(i).toString(), WeatherInfo.class);
			weatherInfoList.add(info);
		}

		System.out.println("城市信息：");
		System.out.println("区域ID：" + cityInfo.getC1());
		System.out.println("城市英文名：" + cityInfo.getC2());
		System.out.println("城市中文名：" + cityInfo.getC3());
		System.out.println("城市所在市英文名：" + cityInfo.getC4());
		System.out.println("城市所在市中文名：" + cityInfo.getC5());
		System.out.println("城市所在省英文名：" + cityInfo.getC6());
		System.out.println("城市所在省中文名：" + cityInfo.getC7());
		System.out.println("城市所在国家英文名：" + cityInfo.getC8());
		System.out.println("城市所在国家中文名：" + cityInfo.getC9());
		System.out.println("城市级别：" + cityInfo.getC10());
		System.out.println("城市区号：" + cityInfo.getC11());
		System.out.println("邮编：" + cityInfo.getC12());
		System.out.println("经度：" + cityInfo.getC13());
		System.out.println("纬度：" + cityInfo.getC14());
		System.out.println("海拔：" + cityInfo.getC15());
		System.out.println("雷达站号：" + cityInfo.getC16());
		System.out.println("时区：" + cityInfo.getC17());
		System.out.println("");
		for (int i = 0; i < weatherInfoList.size(); i++) {
			WeatherInfo info = weatherInfoList.get(i);
			System.out.println("第"+(i+1)+"天天气预报：");
			System.out.println("白天天气现象编号：" + info.getFa());
			System.out.println("晚上天气现象编号：" + info.getFb());
			System.out.println("白天天气温度(摄氏度)：" + info.getFc());
			System.out.println("晚上天气温度(摄氏度)：" + info.getFd());
			System.out.println("白天风向编号：" + info.getFe());
			System.out.println("晚上风向编号：" + info.getFf());
			System.out.println("白天风力编号：" + info.getFg());
			System.out.println("晚上风力编号：" + info.getFh());
			System.out.println("日出日落时间(中间用|分割)：" + info.getFi());
			System.out.println("");
		}
		System.out.println("更新时间：" + f0);
	}

}
