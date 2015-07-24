package com.angelmedics.domain.bean;

import javax.persistence.Entity;

import com.angelmedics.domain.BaseDomain;

/**
 * <b> </b>
 * <p>
 * 功能:医院实体
 * </p>
 * 
 * @作者 stone
 * @创建时间 2015年7月23日 下午10:22:41
 * @修改内容
 * @修改时间
 */
@Entity
public class Hospital extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7521609265441896856L;
	
	String hospitalname;
	String hospitalcode;
	String country;
	String address;
	String property;
	public String getHospitalname() {
		return hospitalname;
	}
	public void setHospitalname(String hospitalname) {
		this.hospitalname = hospitalname;
	}
	public String getHospitalcode() {
		return hospitalcode;
	}
	public void setHospitalcode(String hospitalcode) {
		this.hospitalcode = hospitalcode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}

	
}
