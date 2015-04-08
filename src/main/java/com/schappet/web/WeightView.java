package com.schappet.web;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WeightView {
	private Date date ;
	private String value ;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm");

	/**
	 * @return the date
	 */
	public String getDate() {
		return sdf.format(date);
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	
	

}
