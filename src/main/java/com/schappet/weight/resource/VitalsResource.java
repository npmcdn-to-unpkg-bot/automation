package com.schappet.weight.resource;



import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.NonUniqueObjectException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.*;

import com.schappet.weight.domain.*;
import edu.uiowa.icts.exception.EntityNotFoundException;
import edu.uiowa.icts.spring.GenericDaoListOptions;

/**
 * Generated by Protogen 
 * @see <a href="https://github.com/ui-icts/protogen">https://github.com/ui-icts/protogen</a>
 * @since 02/14/2016 12:33:31 CST
 */
@RestController( value = "com_schappet_weight_resource_vitals_resource" )
@RequestMapping( "/rest/vitals" )
public class VitalsResource extends AbstractWeightApiResource {

    private static final Log log = LogFactory.getLog( VitalsResource.class );
    
    @RequestMapping( value = { "{vitalsId}" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    public Vitals get( @PathVariable( "vitalsId" ) Integer vitalsId ) {
    	 Vitals vitals = weightDaoService.getVitalsService().findById( vitalsId );
		 if (vitals == null){
			 throw new EntityNotFoundException();
		 } 
	     return vitals;
    }
    
    @RequestMapping( method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE  )
    public Vitals create( @RequestBody @Valid Vitals vitals ) {
		 weightDaoService.getVitalsService().save( vitals );
		 return vitals;
    }
    
    @RequestMapping( value = { "{vitalsId}" }, method = { RequestMethod.POST, RequestMethod.PUT }, produces = MediaType.APPLICATION_JSON_VALUE  )
    public Vitals update( @PathVariable( "vitalsId" ) Integer vitalsId, @RequestBody @Valid Vitals vitals ) {
    	Vitals vitalsRecord = weightDaoService.getVitalsService().findById( vitalsId );
    	if ( vitalsRecord == null || !vitalsRecord.getVitalsId().equals(vitals.getVitalsId())){
			 throw new EntityNotFoundException(); 
		 } 
    	 weightDaoService.getVitalsService().getSession().flush();
         weightDaoService.getVitalsService().getSession().clear();
		 weightDaoService.getVitalsService().update( vitals );
		 return vitals;
    }
    
    @RequestMapping( value = { "{vitalsId}" }, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE )
    public String delete( @PathVariable( "vitalsId" ) Integer vitalsId ) {
    	Vitals vitals = weightDaoService.getVitalsService().findById( vitalsId );
		 if ( vitals == null ){
			 throw new EntityNotFoundException();
		 } 
		 weightDaoService.getVitalsService().delete(vitals);
	     return "";
    }
    
    @RequestMapping( value = {  "", "/"  }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    public List<Vitals> list() {
    	 return weightDaoService.getVitalsService().list();
    }

}