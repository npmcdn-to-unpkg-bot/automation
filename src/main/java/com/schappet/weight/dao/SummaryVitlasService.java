package com.schappet.weight.dao;

import java.util.Date;
import java.util.List;

import com.schappet.spring.GenericDaoInterface;
import com.schappet.weight.domain.SummaryTable;
import com.schappet.weight.domain.SummaryVitals;

/**
 * Generated by Protogen 
 * @since 04/11/2015 07:34:51 CDT
 */
public interface SummaryVitlasService extends GenericDaoInterface<SummaryVitals> {

	public SummaryVitals findById( Integer id );
	public SummaryVitals findByPersonIdAndDate( Integer id, Date date );
	public List<SummaryVitals> latest(int defaultPerson, int i);

}