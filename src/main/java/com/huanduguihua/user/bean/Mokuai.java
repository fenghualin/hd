package com.huanduguihua.user.bean;

import java.io.Serializable;

import com.huanduguihua.system.bean.DefaultBean;

public class Mokuai extends DefaultBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4930301122426772284L;
	private Integer id;
	private String mokuaiUrl;
	private Integer orderu;
	private Integer fid;
	private String loadflw;
	private String timucont;
	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	public Integer getOrderu() {
		return orderu;
	}
	public void setOrderu(Integer orderu) {
		this.orderu = orderu;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMokuaiUrl() {
		return mokuaiUrl;
	}
	public void setMokuaiUrl(String mokuaiUrl) {
		this.mokuaiUrl = mokuaiUrl;
	}
	public String getLoadflw() {
		return loadflw;
	}
	public void setLoadflw(String loadflw) {
		this.loadflw = loadflw;
	}
	public String getTimucont() {
		return timucont;
	}
	public void setTimucont(String timucont) {
		this.timucont = timucont;
	}
	@Override
	public String __getMyjdbcTableName() {
		return "mokuai";
	}
}
