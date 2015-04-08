package com.schappet.weight.dao;

import edu.uiowa.icts.spring.*;
import com.schappet.weight.domain.*;
import java.util.ArrayList;
import java.util.List;
import edu.uiowa.icts.util.SortColumn;

/**
 * Generated by Protogen 
 * @since 04/07/2015 08:12:26 CDT
 */
public interface WeightService extends GenericDaoInterface<Weight> {

	public Weight findById( Integer id );

	public Weight latest(int personId);

}