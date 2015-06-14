package com.schappet.weight.dao;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.schappet.spring.GenericDao;
import com.schappet.weight.domain.SummaryTable;
import com.schappet.weight.domain.Vitals;

/**
 * Generated by Protogen 
 * @since 04/11/2015 07:34:51 CDT
 */
@Repository("com_schappet_weight_dao_SummaryTableHome")
@Transactional
public class SummaryTableHome extends GenericDao<SummaryTable> implements SummaryTableService {

	private static final Log log = LogFactory.getLog( SummaryTableHome.class );

	public SummaryTableHome() {
		setDomainName( "com.schappet.weight.domain.SummaryTable" );
	}

	public SummaryTable findById( Integer id ) {
		return (SummaryTable) this.sessionFactory.getCurrentSession().get( SummaryTable.class, id );
	}

	
	public SummaryTable findByPersonIdAndDate( Integer id , Date date) {
		//vitalsDate
		     Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(SummaryTable.class);
		     criteria.add(Restrictions.eq("personId", id));
		     criteria.add(Restrictions.eq("vitalsDate", date));
		     //criteria.addOrder(Order.desc("activityDate"));
		     criteria.setMaxResults(1);
		     return (SummaryTable)criteria.uniqueResult();

		
	}

	@Override
	public List<SummaryTable> latest(int personId, int count) {
	
	     Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Vitals.class);
	     criteria.add(Restrictions.eq("personId", personId));
	     criteria.addOrder(Order.desc("vitalsDate"));
	     criteria.setMaxResults(count < 50 ? count : 50);
	     return criteria.list();
	     
		
	}
}