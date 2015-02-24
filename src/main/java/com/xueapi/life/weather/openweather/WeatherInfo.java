package com.xueapi.life.weather.openweather;

import java.io.Serializable;

public class WeatherInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String fa;	//白天天气现象编号

	private String fb;	//晚上天气现象编号

	private String fc;	//白天天气温度(摄氏度)

	private String fd;	//晚上天气温度(摄氏度)

	private String fe;	//白天风向编号

	private String ff;	//晚上风向编号

	private String fg;	//白天风力编号

	private String fh;	//晚上风力编号

	private String fi;	//日出日落时间(中间用|分割)

	public String getFa() {
		return fa;
	}

	public void setFa(String fa) {
		this.fa = fa;
	}

	public String getFb() {
		return fb;
	}

	public void setFb(String fb) {
		this.fb = fb;
	}

	public String getFc() {
		return fc;
	}

	public void setFc(String fc) {
		this.fc = fc;
	}

	public String getFd() {
		return fd;
	}

	public void setFd(String fd) {
		this.fd = fd;
	}

	public String getFe() {
		return fe;
	}

	public void setFe(String fe) {
		this.fe = fe;
	}

	public String getFf() {
		return ff;
	}

	public void setFf(String ff) {
		this.ff = ff;
	}

	public String getFg() {
		return fg;
	}

	public void setFg(String fg) {
		this.fg = fg;
	}

	public String getFh() {
		return fh;
	}

	public void setFh(String fh) {
		this.fh = fh;
	}

	public String getFi() {
		return fi;
	}

	public void setFi(String fi) {
		this.fi = fi;
	}

}
