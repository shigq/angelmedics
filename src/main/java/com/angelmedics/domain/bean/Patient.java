package com.angelmedics.domain.bean;

import javax.persistence.Entity;

import com.angelmedics.domain.BaseDomain;

/**
 * <b> </b>
 * <p>
 * 功能:患者实体
 * </p>
 * 
 * @作者 stone
 * @创建时间 2015年7月19日 上午10:06:51
 * @修改内容
 * @修改时间
 */
@Entity
public class Patient extends BaseDomain{

	/**
	 * 
	 */
	private static final long serialVersionUID = -266891045336640940L;
	
	private String usercode;
	
	private String username;
	
	private String tel;
	
	private String password;
	
	private String sex;

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	

}
