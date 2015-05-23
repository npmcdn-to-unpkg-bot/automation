package com.schappet.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.schappet.weight.domain.Activity;
import com.schappet.weight.domain.Weight;

public class SummaryDetails {

	private SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");

	
	private List<TableView> table = new ArrayList<TableView>();
	private String weightMin = "";
	private String weightMax = "";
	
	public SummaryDetails(List<Weight> list, List<Activity> aList) {
		Float minWeight = 350f;
		Float maxWeight = 0f;
		Map<String, String[]> tmp = new HashMap<String,String[]>();
		
		for (Weight w : list) {
			String key = sdf.format(w.getWeightInDate());
			String[] act = tmp.get(key);
			if (act == null) act = new String[2];
			act[0] = w.getValue();
			tmp.put(key, act);
			if (w.getValueFloat() > maxWeight) {
				maxWeight = w.getValueFloat(); 
			}
			if (w.getValueFloat() < minWeight) {
				minWeight = w.getValueFloat(); 
			}
			//TableView wv = new TableView(w);
	       	//table.add(new TableView(w));	
		}
		
		for (Activity a : aList) {
			String key = sdf.format(a.getActivityDate());
			String[] act = tmp.get(key);
			if (act == null) act = new String[2];
			act[1] = a.getValue();
			tmp.put(key, act);		
		}
		for (String key : tmp.keySet()) {
			table.add(new TableView(key, tmp.get(key)));	
		}
		
		weightMin = ""+ minWeight;
		weightMax = ""+ maxWeight;
	}

	public List<TableView> getTable() {
		return table;
	}

	public void setTable(List<TableView> table) {
		this.table = table;
	}

	public String getWeightMin() {
		return weightMin;
	}

	public void setWeightMin(String weightMin) {
		this.weightMin = weightMin;
	}

	public String getWeightMax() {
		return weightMax;
	}

	public void setWeightMax(String weightMax) {
		this.weightMax = weightMax;
	}

	/*
	List<TableView> output = new ArrayList<WeightView>();
	for (Weight w: list) {
		
	}
	*/
	
}
