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
@RestController( value = "com_schappet_weight_resource_emailaddress_resource" )
@RequestMapping( "/rest/emailaddress" )
public class EmailAddressResource extends AbstractWeightApiResource {

    private static final Log log = LogFactory.getLog( EmailAddressResource.class );
    
    @RequestMapping( value = { "{emailAddressId}" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    public EmailAddress get( @PathVariable( "emailAddressId" ) Integer emailAddressId ) {
    	 EmailAddress emailAddress = weightDaoService.getEmailAddressService().findById( emailAddressId );
		 if (emailAddress == null){
			 throw new EntityNotFoundException();
		 } 
	     return emailAddress;
    }
    
    @RequestMapping( method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE  )
    public EmailAddress create( @RequestBody @Valid EmailAddress emailAddress ) {
		 weightDaoService.getEmailAddressService().save( emailAddress );
		 return emailAddress;
    }
    
    @RequestMapping( value = { "{emailAddressId}" }, method = { RequestMethod.POST, RequestMethod.PUT }, produces = MediaType.APPLICATION_JSON_VALUE  )
    public EmailAddress update( @PathVariable( "emailAddressId" ) Integer emailAddressId, @RequestBody @Valid EmailAddress emailAddress ) {
    	EmailAddress emailAddressRecord = weightDaoService.getEmailAddressService().findById( emailAddressId );
    	if ( emailAddressRecord == null || !emailAddressRecord.getEmailId().equals(emailAddress.getEmailId())){
			 throw new EntityNotFoundException(); 
		 } 
    	 weightDaoService.getEmailAddressService().getSession().flush();
         weightDaoService.getEmailAddressService().getSession().clear();
		 weightDaoService.getEmailAddressService().update( emailAddress );
		 return emailAddress;
    }
    
    @RequestMapping( value = { "{emailAddressId}" }, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE )
    public String delete( @PathVariable( "emailAddressId" ) Integer emailAddressId ) {
    	EmailAddress emailAddress = weightDaoService.getEmailAddressService().findById( emailAddressId );
		 if ( emailAddress == null ){
			 throw new EntityNotFoundException();
		 } 
		 weightDaoService.getEmailAddressService().delete(emailAddress);
	     return "";
    }
    
    @RequestMapping( value = {  "", "/"  }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    public List<EmailAddress> list() {
    	 return weightDaoService.getEmailAddressService().list();
    }

}