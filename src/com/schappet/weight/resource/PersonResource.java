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
 * @since 02/16/2016 20:51:24 CST
 */
@RestController( value = "com_schappet_weight_resource_person_resource" )
@RequestMapping( "/rest/person" )
public class PersonResource extends AbstractWeightApiResource {

    private static final Log log = LogFactory.getLog( PersonResource.class );
    
    @RequestMapping( value = { "{personId}" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    public Person get( @PathVariable( "personId" ) Integer personId ) {
    	 Person person = weightDaoService.getPersonService().findById( personId );
		 if (person == null){
			 throw new EntityNotFoundException();
		 } 
	     return person;
    }
    
    @RequestMapping( method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE  )
    public Person create( @RequestBody @Valid Person person ) {
		 weightDaoService.getPersonService().save( person );
		 return person;
    }
    
    @RequestMapping( value = { "{personId}" }, method = { RequestMethod.POST, RequestMethod.PUT }, produces = MediaType.APPLICATION_JSON_VALUE  )
    public Person update( @PathVariable( "personId" ) Integer personId, @RequestBody @Valid Person person ) {
    	Person personRecord = weightDaoService.getPersonService().findById( personId );
    	if ( personRecord == null || !personRecord.getPersonId().equals(person.getPersonId())){
			 throw new EntityNotFoundException(); 
		 } 
    	 weightDaoService.getPersonService().getSession().flush();
         weightDaoService.getPersonService().getSession().clear();
		 weightDaoService.getPersonService().update( person );
		 return person;
    }
    
    @RequestMapping( value = { "{personId}" }, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE )
    public String delete( @PathVariable( "personId" ) Integer personId ) {
    	Person person = weightDaoService.getPersonService().findById( personId );
		 if ( person == null ){
			 throw new EntityNotFoundException();
		 } 
		 weightDaoService.getPersonService().delete(person);
	     return "";
    }
    
    @RequestMapping( value = {  "", "/"  }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    public List<Person> list() {
    	 return weightDaoService.getPersonService().list();
    }

}