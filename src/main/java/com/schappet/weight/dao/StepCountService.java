package com.schappet.weight.dao;

import edu.uiowa.icts.spring.*;

import java.util.List;

import com.schappet.weight.domain.*;

/**
 * Generated by Protogen 
 * @see <a href="https://github.com/ui-icts/protogen">https://github.com/ui-icts/protogen</a>
 * @since 06/08/2016 09:07:58 CDT
 */
public interface StepCountService extends GenericDaoInterface<StepCount> {

	public StepCount findById( Integer id );
	public List<StepCount> latest(Person person, int count);
}