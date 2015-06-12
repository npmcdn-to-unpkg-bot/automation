package com.schappet.weight.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.schappet.spring.GenericDao;
import com.schappet.weight.domain.Weight;

/**
 * Generated by Protogen 
 * @since 04/07/2015 08:12:26 CDT
 */
@Repository("com_schappet_weight_dao_WeightHome")
@Transactional
public class WeightHome extends GenericDao<Weight> implements WeightService {
    protected final SimpleDateFormat shortDate = new SimpleDateFormat("yyyy-MM-dd");

    
	private static final Log log = LogFactory.getLog( WeightHome.class );

	public WeightHome() {
		setDomainName( "com.schappet.weight.domain.Weight" );
	}

	public Weight findById( Integer id ) {
		return (Weight) this.sessionFactory.getCurrentSession().get( Weight.class, id );
	}

	public Weight latest(int personId) {
		
	     Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Weight.class);
	        criteria.add(Restrictions.eq("personId", personId));
	        criteria.addOrder(Order.desc("weightInDate"));
	        criteria.setMaxResults(1);
	        return (Weight) criteria.uniqueResult();
		 
	}

	@Override
	public List<Weight> latest(int personId, int count) {
	     Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Weight.class);
	     criteria.add(Restrictions.eq("personId", personId));
	     criteria.addOrder(Order.desc("weightInDate"));
	     criteria.setMaxResults(count < 50 ? count : 50);
	     return criteria.list();
		 
	}


	@Override
	public List<Weight> lastNMonths(int personId, int count) {
		List<String> days = new ArrayList<String>();
				
		for (String day : days) {
			
		}
		Disjunction or = Restrictions.disjunction();
		
	    Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Weight.class);
	    criteria.add(Restrictions.eq("personId", personId));
	    //TODO: Format Date compare One Day to One Day, not Timestamp to timestamp
	     //criteria.addOrder(Order.desc("weightInDate"));
	    for (int i = 0 ; i <= count ; i++) {

	    	
			Calendar calendar = Calendar.getInstance(); // this would default to now
			calendar.add(Calendar.DAY_OF_MONTH, -( i * 30 )) ;
			log.debug("Date: " + shortDate.format(calendar.getTime()) );
			days.add(shortDate.format(calendar.getTime()));
			Conjunction and = Restrictions.conjunction();	
			and.add(Restrictions.ge("weightInDate", calendar.getTime()));
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			and.add(Restrictions.le("weightInDate", calendar.getTime()));
			
	    	or.add(and);
		}
		
	    criteria.add(or);
	     
	    //criteria.setMaxResults(count < 50 ? count : 50);
	    return criteria.list();
		 
	}
	
	@Override
	public List<Weight> between(int personId, Date start, Date end) {
		  Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Weight.class);
		  criteria.add(Restrictions.eq("personId", personId));
		  criteria.add(Restrictions.between("weightInDate", start, end));

		  criteria.addOrder(Order.desc("weightInDate"));
		// TODO Auto-generated method stub
		return criteria.list();
	}

}