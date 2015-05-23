package com.schappet.web;


public class TableView {
	private String dateInstance ;
	private String weightValue ;
	private String activityValue ;
	
	//private SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");

	public TableView(String date, String[] tmp) {

		this.setDateInstance(date);
    	this.setWeightValue(tmp[0]);
    	this.setActivityValue(tmp[1]);

	}

//	public String getDate() {
//		return sdf.format(date);
//	}
//
//	public void setDate(String date) {
//		this.date = date;
//	}

	public String getWeightValue() {
		return weightValue;
	}

	public void setWeightValue(String weightValue) {
		this.weightValue = weightValue;
	}

	public String getActivityValue() {
		return activityValue;
	}

	public void setActivityValue(String activityValue) {
		this.activityValue = activityValue;
	}

	public String getDateInstance() {
		return dateInstance;
	}

	public void setDateInstance(String dateInstance) {
		this.dateInstance = dateInstance;
	}
	

}
