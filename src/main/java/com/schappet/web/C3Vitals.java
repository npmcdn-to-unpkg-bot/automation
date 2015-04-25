package com.schappet.web;

import java.util.List;

public class C3Vitals {


	public List<Integer> getSystolic() {
		return systolic;
	}


	public void setSystolic(List<Integer> systolic) {
		this.systolic = systolic;
	}


	
	public List<Integer> getDiastolic() {
		return diastolic;
	}


	public void setDiastolic(List<Integer> diastolic) {
		this.diastolic = diastolic;
	}


	public List<Integer> getPulse() {
		return pulse;
	}


	public void setPulse(List<Integer> pulse) {
		this.pulse = pulse;
	}


	public void setX(List<String> x) {
		this.x = x;
	}


	private List<String> x;
	private List<Integer> systolic;
	private List<Integer> diastolic;
	private List<Integer> pulse;

	
	public List<String> getX() {
		return x;
	}
	
}
