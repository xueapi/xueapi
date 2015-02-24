package junit;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.xueapi.life.weather.openweather.IndexInfo;
import com.xueapi.life.weather.openweather.Weather;

public class IndexTest extends TestCase{
	
	private static final Log log = LogFactory.getLog(IndexTest.class);
	
	private static final String FORMAT = "yyyyMMddHHmm";
	
	@Test
	public void testIndex(){
		// beijing 101010100
		SimpleDateFormat format = new SimpleDateFormat(FORMAT);
		String date = format.format(new Date());
		Weather w = new Weather();
		String json = w.getWeatherInfo("101010100", "index_f", date);
		log.info("json = " + json);
		Map map = JSONObject.parseObject(json, Map.class);
		List<IndexInfo> indexInfoList = new ArrayList<IndexInfo>();
		List list = JSONObject.parseObject(map.get("i").toString(), List.class);
		for (int i = 0; i < list.size(); i++) {
			IndexInfo info = JSONObject.parseObject(list.get(i).toString(), IndexInfo.class);
			indexInfoList.add(info);
		}

		for (int i = 0; i < indexInfoList.size(); i++) {
			IndexInfo info = indexInfoList.get(i);
			System.out.println("第"+(i+1)+"个指数信息：");
			System.out.println("指数简称：" + info.getI1());
			System.out.println("指数中文名称：" + info.getI2());
			System.out.println("指数中文别名：" + info.getI3());
			System.out.println("指数级别：" + info.getI4());
			System.out.println("指数详情：" + info.getI5());
			System.out.println("");
		}
	}

}
