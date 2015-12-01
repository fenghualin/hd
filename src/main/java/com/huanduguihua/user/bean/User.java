/**
 * com.huanduguihua.user.bean
 * User.java
 * 
 * 2014-5-14-上午11:30:52
 *  2014成都酷信科技公司-版权所有
 * 
 */
package com.huanduguihua.user.bean;

import java.sql.Timestamp;


import com.huanduguihua.system.bean.DefaultBean;

/**
 * 
 * User
 * 
 * kin
 * kin
 * 2014-5-14 上午11:30:52
 * 
 * @author KangJia
 * @version 1.0.0
 * 
 */

public class User extends DefaultBean {
	
	public String __getMyjdbcTableName() {return "test_system_user";}
	
	public final static String PASSWORD_SALT = "jo8bMkl";
	
	private Integer id;
	private String name;
	private String username;
	private String password;
	private Timestamp createTime = new Timestamp(System.currentTimeMillis());
	private String xingbie;		//性别
	private Integer nianling;	//年龄
	private String minzu;		//民族
	private String guoji;
	private String xueli;		//学历
	private String nianji;		//年级
	private String banji;		//班级
	private String xueshengleixing;	//学生类型
	private String yuanxuelileixing;//原学习类型
	private String shenfenzheng;	//身份证
	private String fuqinxingming;	//父亲姓名
	private String muqinxingming;	//母亲姓名
	private Integer fuqinnianling;	//父亲年龄
	private Integer muqinnianling;	//母亲年龄
	private String danwei;			//单位
	private String gudingdianhua;	//固定电话
	private String yidongdianhua;	//移动电话
	private String email;	//邮箱
	private String dizhi;	//地址
	private String shili;	//视力
	private String tingli;	//听力
	private String xiexing;
	private String sejue;	//色觉
	private Integer jigou;//机构名称
	private String money;//金额
	private Integer isuse;//是否使用
	private String techang;
	private String school;
	private String fuqinwenhuachengdu;
	private String muqinwenhuachengdu;
	private String muqinzhiye;
	private String fuqinzhiye;
	private String fuqinshouru;
	private String muqinshouru;
	private Integer zuotijindu;//做题进度
	private Integer xiaotijd;//小题进度
	public Integer getZuotijindu() {
		return zuotijindu;
	}
	public void setZuotijindu(Integer zuotijindu) {
		this.zuotijindu = zuotijindu;
	}

	private Integer iswancheng;//是否完成所有题目
	private Integer jdfId;//进度是否完成的id;
	private Integer mokuaijdId;//模块进度;
	private Boolean online = false;
	private Timestamp wanchengTime;//add by fenghualin for 按完成时间排序
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public String getXingbie() {
		return xingbie;
	}
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	public Integer getNianling() {
		return nianling;
	}
	public void setNianling(Integer nianling) {
		this.nianling = nianling;
	}
	public String getMinzu() {
		return minzu;
	}
	public void setMinzu(String minzu) {
		this.minzu = minzu;
	}
	public String getGuoji() {
		return guoji;
	}
	public void setGuoji(String guoji) {
		this.guoji = guoji;
	}
	public String getXueli() {
		return xueli;
	}
	public void setXueli(String xueli) {
		this.xueli = xueli;
	}
	public String getNianji() {
		return nianji;
	}
	public void setNianji(String nianji) {
		this.nianji = nianji;
	}
	public String getBanji() {
		return banji;
	}
	public void setBanji(String banji) {
		this.banji = banji;
	}
	public String getXueshengleixing() {
		return xueshengleixing;
	}
	public void setXueshengleixing(String xueshengleixing) {
		this.xueshengleixing = xueshengleixing;
	}
	public String getYuanxuelileixing() {
		return yuanxuelileixing;
	}
	public void setYuanxuelileixing(String yuanxuelileixing) {
		this.yuanxuelileixing = yuanxuelileixing;
	}
	public String getShenfenzheng() {
		return shenfenzheng;
	}
	public void setShenfenzheng(String shenfenzheng) {
		this.shenfenzheng = shenfenzheng;
	}
	public String getFuqinxingming() {
		return fuqinxingming;
	}
	public void setFuqinxingming(String fuqinxingming) {
		this.fuqinxingming = fuqinxingming;
	}
	public String getMuqinxingming() {
		return muqinxingming;
	}
	public void setMuqinxingming(String muqinxingming) {
		this.muqinxingming = muqinxingming;
	}
	public Integer getFuqinnianling() {
		return fuqinnianling;
	}
	public void setFuqinnianling(Integer fuqinnianling) {
		this.fuqinnianling = fuqinnianling;
	}
	public Integer getMuqinnianling() {
		return muqinnianling;
	}
	public void setMuqinnianling(Integer muqinnianling) {
		this.muqinnianling = muqinnianling;
	}
	public String getDanwei() {
		return danwei;
	}
	public void setDanwei(String danwei) {
		this.danwei = danwei;
	}
	public String getGudingdianhua() {
		return gudingdianhua;
	}
	public void setGudingdianhua(String gudingdianhua) {
		this.gudingdianhua = gudingdianhua;
	}
	public String getYidongdianhua() {
		return yidongdianhua;
	}
	public void setYidongdianhua(String yidongdianhua) {
		this.yidongdianhua = yidongdianhua;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDizhi() {
		return dizhi;
	}
	public void setDizhi(String dizhi) {
		this.dizhi = dizhi;
	}
	public String getShili() {
		return shili;
	}
	public void setShili(String shili) {
		this.shili = shili;
	}
	public String getTingli() {
		return tingli;
	}
	public void setTingli(String tingli) {
		this.tingli = tingli;
	}
	public String getXiexing() {
		return xiexing;
	}
	public void setXiexing(String xiexing) {
		this.xiexing = xiexing;
	}
	public String getSejue() {
		return sejue;
	}
	public void setSejue(String sejue) {
		this.sejue = sejue;
	}
	public Integer getJigou() {
		return jigou;
	}
	public void setJigou(Integer jigou) {
		this.jigou = jigou;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public Integer getIsuse() {
		return isuse;
	}
	public void setIsuse(Integer isuse) {
		this.isuse = isuse;
	}
	public String getTechang() {
		return techang;
	}
	public void setTechang(String techang) {
		this.techang = techang;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getFuqinwenhuachengdu() {
		return fuqinwenhuachengdu;
	}
	public void setFuqinwenhuachengdu(String fuqinwenhuachengdu) {
		this.fuqinwenhuachengdu = fuqinwenhuachengdu;
	}
	public String getMuqinwenhuachengdu() {
		return muqinwenhuachengdu;
	}
	public void setMuqinwenhuachengdu(String muqinwenhuachengdu) {
		this.muqinwenhuachengdu = muqinwenhuachengdu;
	}
	public String getMuqinzhiye() {
		return muqinzhiye;
	}
	public void setMuqinzhiye(String muqinzhiye) {
		this.muqinzhiye = muqinzhiye;
	}
	public String getFuqinzhiye() {
		return fuqinzhiye;
	}
	public void setFuqinzhiye(String fuqinzhiye) {
		this.fuqinzhiye = fuqinzhiye;
	}
	public String getFuqinshouru() {
		return fuqinshouru;
	}
	public void setFuqinshouru(String fuqinshouru) {
		this.fuqinshouru = fuqinshouru;
	}
	public String getMuqinshouru() {
		return muqinshouru;
	}
	public void setMuqinshouru(String muqinshouru) {
		this.muqinshouru = muqinshouru;
	}
	public Integer getIswancheng() {
		return iswancheng;
	}
	public void setIswancheng(Integer iswancheng) {
		this.iswancheng = iswancheng;
	}
	public Integer getJdfId() {
		return jdfId;
	}
	public void setJdfId(Integer jdfId) {
		this.jdfId = jdfId;
	}
	public Integer getMokuaijdId() {
		return mokuaijdId;
	}
	public void setMokuaijdId(Integer mokuaijdId) {
		this.mokuaijdId = mokuaijdId;
	}
	public Boolean getOnline() {
		return online;
	}
	public void setOnline(Boolean online) {
		this.online = online;
	}
	
	public Timestamp getWanchengTime() {
		return wanchengTime;
	}
	public void setWanchengTime(Timestamp wanchengTime) {
		this.wanchengTime = wanchengTime;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", username=" + username
				+ ", password=" + password + ", createTime=" + createTime
				+ ", xingbie=" + xingbie + ", nianling=" + nianling
				+ ", minzu=" + minzu + ", guoji=" + guoji + ", xueli=" + xueli
				+ ", nianji=" + nianji + ", banji=" + banji
				+ ", xueshengleixing=" + xueshengleixing
				+ ", yuanxuelileixing=" + yuanxuelileixing + ", shenfenzheng="
				+ shenfenzheng + ", fuqinxingming=" + fuqinxingming
				+ ", muqinxingming=" + muqinxingming + ", fuqinnianling="
				+ fuqinnianling + ", muqinnianling=" + muqinnianling
				+ ", danwei=" + danwei + ", gudingdianhua=" + gudingdianhua
				+ ", yidongdianhua=" + yidongdianhua + ", email=" + email
				+ ", dizhi=" + dizhi + ", shili=" + shili + ", tingli="
				+ tingli + ", xiexing=" + xiexing + ", sejue=" + sejue
				+ ", jigou=" + jigou + ", money=" + money + ", isuse=" + isuse
				+ ", techang=" + techang + ", school=" + school
				+ ", fuqinwenhuachengdu=" + fuqinwenhuachengdu
				+ ", muqinwenhuachengdu=" + muqinwenhuachengdu
				+ ", muqinzhiye=" + muqinzhiye + ", fuqinzhiye=" + fuqinzhiye
				+ ", fuqinshouru=" + fuqinshouru + ", muqinshouru="
				+ muqinshouru + ", zuotijindu=" + zuotijindu + ", xiaotijd=" + xiaotijd + ", iswancheng="
				+ iswancheng + ", jdfId=" + jdfId + ", mokuaijdId="
				+ mokuaijdId + ", online=" + online + "]";
	}
	public Integer getXiaotijd() {
		return xiaotijd;
	}
	public void setXiaotijd(Integer xiaotijd) {
		this.xiaotijd = xiaotijd;
	}
}
