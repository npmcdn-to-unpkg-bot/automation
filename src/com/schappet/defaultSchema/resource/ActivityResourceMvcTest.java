package com.schappet.defaultSchema.resource;




import java.util.List;

import org.hamcrest.core.IsNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;

import edu.uiowa.icts.datatable.DataTableColumn;
import edu.uiowa.icts.datatable.DataTableRequest;
import edu.uiowa.icts.datatable.DataTableSearch;
import com.schappet.defaultSchema.dao.*;
import com.schappet.defaultSchema.domain.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.schappet.defaultSchema.controller.AbstractControllerMVCTests;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;

/**
 * Generated by Protogen
 * @see <a href="https://github.com/ui-icts/protogen">https://github.com/ui-icts/protogen</a>
 * @since Sun Feb 14 12:30:14 CST 2016
 */
public class ActivityResourceMvcTest extends AbstractControllerMVCTests {
	
    private Activity firstActivity;
    private ObjectMapper mapper;
    
    @Before
    public void before() { 
        // add 20 records to test database
        for(int x=1; x<21; x++){
        	Activity activity = new Activity();
        	defaultSchemaDaoService.getActivityService().save(activity);
	        if (x == 1){
	        	// use this ID for update, show, and delete assertions
	        	firstActivity = activity;
	        }
        }   
        this.mapper = new ObjectMapper();
        // fix NonUniqueObjectException
        this.defaultSchemaDaoService.getActivityService().getSession().flush();
        this.defaultSchemaDaoService.getActivityService().getSession().clear();
    }    
      
    @Test
    public void getByPathVariableIdShouldLoadAndReturnObject() throws Exception {
    	mockMvc.perform(get("null/activity/"+firstActivity.getActivityId().toString()))
         .andExpect(status().isOk())
         .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(jsonPath("$.activityId", is(firstActivity.getActivityId())))
        ;
    }
  
    @Test
    public void getByPathVariableIdShouldReturn404ForBogusId() throws Exception {
    	mockMvc.perform(get("null/activity/-123")).andExpect(status().isNotFound()).andExpect(jsonPath("$.message", is("null/activity/-123 could not be found.")));
    }
    
    @Test
    public void restMappingNotFoundShouldReturn404() throws Exception {
    	mockMvc.perform(get("null/activity/asdfasdf/asdfasdf"))
    	.andExpect(status().isNotFound())
    	 .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(jsonPath("$.message", is("null/activity/asdfasdf/asdfasdf could not be found.")))
    	;
    }
    
    @Test
    public void createShouldPersistAndReturnObject() throws Exception {
	   long count = defaultSchemaDaoService.getActivityService().count();	       
	   Activity activity = new Activity(); 
       
       mockMvc.perform(post("null/activity/").content(this.mapper.writeValueAsString(activity))
	   .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
	   .with(csrf()))
       .andExpect(status().isOk())
       .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
       .andExpect(jsonPath("$.activityId").value(IsNull.notNullValue()))  
       ;
       
       assertEquals("count should increase by 1", count +1 , defaultSchemaDaoService.getActivityService().count());
	}
     
    @Test
    public void updateShouldPersistExistingAndReturnObject() throws Exception {
       long count = defaultSchemaDaoService.getActivityService().count();

       mockMvc.perform(post("null/activity/"+ firstActivity.getActivityId().toString())
    		   .content(this.mapper.writeValueAsString(firstActivity))
    		   .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
    		   .with(csrf()))
       .andExpect(status().isOk())
       .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
       .andExpect(jsonPath("$.activityId", is(firstActivity.getActivityId())))
       ;
         
       assertEquals("count NOT should increase", count , defaultSchemaDaoService.getActivityService().count());
  	}  
    
    @Test
    public void updateByPathVariableIdShouldReturn404ForMismatchBetweenPathIdAndObjectId() throws Exception {	       
       String correctId =  firstActivity.getActivityId().toString();
       // this ID manipulation should be overwritten with path variable id
       firstActivity.setActivityId(-123);
       
       mockMvc.perform(post("null/activity/"+correctId)
    		   .content(this.mapper.writeValueAsString(firstActivity))
    		   .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
    		   .with(csrf()))
       .andExpect(status().isNotFound())
       .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
       .andExpect(jsonPath("$.message", is("null/activity/" +correctId +" could not be found.")))
       ;
  	} 
    
    @Test
    public void updateByPathVariableIdShouldReturn404ForBogusPathId() throws Exception {
    	mockMvc.perform(post("null/activity/-123")
    			.content(this.mapper.writeValueAsString(firstActivity))
    		   .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
    		   .with(csrf()))
    	.andExpect(status().isNotFound())
    	.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
	    .andExpect(jsonPath("$.message", is("null/activity/-123 could not be found.")));
    }
    
    @Test
    public void deleteShouldDeleteAndReturnStatusOk() throws Exception {
        long count = defaultSchemaDaoService.getActivityService().count();

        mockMvc.perform(delete("null/activity/"+ firstActivity.getActivityId().toString()).with(csrf()))
       .andExpect(status().isOk());  
       
       assertEquals("count should decrease by 1", count - 1 , defaultSchemaDaoService.getActivityService().count());
    }
    
    @Test
    public void deleteShouldFailWithBogusId() throws Exception {
        long count = defaultSchemaDaoService.getActivityService().count();

        mockMvc.perform(delete("null/activity/-123").with(csrf()))
       .andExpect(status().isNotFound())
       .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
       .andExpect(jsonPath("$.message", is("null/activity/-123 could not be found.")));  
       
       assertEquals("count should NOT decrease by 1", count , defaultSchemaDaoService.getActivityService().count());
    }

    @Test
    public void listShouldReturnAllByDefault() throws Exception {
    	mockMvc.perform(get("null/activity/"))
         .andExpect(status().isOk())
         .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
         .andExpect(jsonPath("$.", hasSize(is(20))))
        .andExpect(jsonPath("$.[0].activityId", is(firstActivity.getActivityId())))
        ;
    }
    
    @Test
    public void listShouldReturnAllByDefaultWithoutTrailUrlSlash() throws Exception {
    	mockMvc.perform(get("null/activity"))
         .andExpect(status().isOk())
         .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
         .andExpect(jsonPath("$.", hasSize(is(20))))
        .andExpect(jsonPath("$.[0].activityId", is(firstActivity.getActivityId())))
        ;
    }
}