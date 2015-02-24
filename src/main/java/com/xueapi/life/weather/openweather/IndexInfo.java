package com.xueapi.life.weather.openweather;

import java.io.Serializable;

public class IndexInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String i1;	//指数简称

	private String i2;	//指数中文名称

	private String i3;	//指数中文别名

	private String i4;	//指数级别

	private String i5;	//指数详情

	public String getI1() {
		return i1;
	}

	public void setI1(String i1) {
		this.i1 = i1;
	}

	public String getI2() {
		return i2;
	}

	public void setI2(String i2) {
		this.i2 = i2;
	}

	public String getI3() {
		return i3;
	}

	public void setI3(String i3) {
		this.i3 = i3;
	}

	public String getI4() {
		return i4;
	}

	public void setI4(String i4) {
		this.i4 = i4;
	}

	public String getI5() {
		return i5;
	}

	public void setI5(String i5) {
		this.i5 = i5;
	}
}
