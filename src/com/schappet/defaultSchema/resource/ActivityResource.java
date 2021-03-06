package com.schappet.defaultSchema.resource;



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

import com.schappet.defaultSchema.domain.*;
import edu.uiowa.icts.exception.EntityNotFoundException;
import edu.uiowa.icts.spring.GenericDaoListOptions;

/**
 * Generated by Protogen 
 * @see <a href="https://github.com/ui-icts/protogen">https://github.com/ui-icts/protogen</a>
 * @since 02/14/2016 12:30:14 CST
 */
@RestController( value = "com_schappet_defaultSchema_resource_activity_resource" )
@RequestMapping( "/rest/activity" )
public class ActivityResource extends AbstractDefaultSchemaApiResource {

    private static final Log log = LogFactory.getLog( ActivityResource.class );
    
    @RequestMapping( value = { "{activityId}" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    public Activity get( @PathVariable( "activityId" ) Integer activityId ) {
    	 Activity activity = defaultSchemaDaoService.getActivityService().findById( activityId );
		 if (activity == null){
			 throw new EntityNotFoundException();
		 } 
	     return activity;
    }
    
    @RequestMapping( method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE  )
    public Activity create( @RequestBody @Valid Activity activity ) {
		 defaultSchemaDaoService.getActivityService().save( activity );
		 return activity;
    }
    
    @RequestMapping( value = { "{activityId}" }, method = { RequestMethod.POST, RequestMethod.PUT }, produces = MediaType.APPLICATION_JSON_VALUE  )
    public Activity update( @PathVariable( "activityId" ) Integer activityId, @RequestBody @Valid Activity activity ) {
    	Activity activityRecord = defaultSchemaDaoService.getActivityService().findById( activityId );
    	if ( activityRecord == null || !activityRecord.getActivityId().equals(activity.getActivityId())){
			 throw new EntityNotFoundException(); 
		 } 
    	 defaultSchemaDaoService.getActivityService().getSession().flush();
         defaultSchemaDaoService.getActivityService().getSession().clear();
		 defaultSchemaDaoService.getActivityService().update( activity );
		 return activity;
    }
    
    @RequestMapping( value = { "{activityId}" }, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE )
    public String delete( @PathVariable( "activityId" ) Integer activityId ) {
    	Activity activity = defaultSchemaDaoService.getActivityService().findById( activityId );
		 if ( activity == null ){
			 throw new EntityNotFoundException();
		 } 
		 defaultSchemaDaoService.getActivityService().delete(activity);
	     return "";
    }
    
    @RequestMapping( value = {  "", "/"  }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    public List<Activity> list() {
    	 return defaultSchemaDaoService.getActivityService().list();
    }

}