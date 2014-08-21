package com.qing.common.util;

/**
 * ip转城市
 * 
 * @author luoqinglong
 * @date 2014-1-2 上午10:10:02
 * @since 1.0
 **/
public class Address {
	String fullAddress;
	String country;
	String province;
	String city;

	/**
	 * @return the fullAddress
	 **/
	public String getFullAddress() {
		return fullAddress;
	}

	/**
	 * @param fullAddress
	 *            the fullAddress to set
	 **/
	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	/**
	 * @return the country
	 **/
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 **/
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the province
	 **/
	public String getProvince() {
		return province;
	}

	/**
	 * @param province
	 *            the province to set
	 **/
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * @return the city
	 **/
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 **/
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Description:
	 * 
	 * @return
	 * @see java.lang.Object#toString()
	 **/
	@Override
	public String toString() {
		return "Address [fullAddress=" + fullAddress + ", country=" + country + ", province=" + province + ", city="
				+ city + "]";
	}

}
