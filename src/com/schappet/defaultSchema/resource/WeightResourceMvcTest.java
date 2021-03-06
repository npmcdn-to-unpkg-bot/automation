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
public class WeightResourceMvcTest extends AbstractControllerMVCTests {
	
    private Weight firstWeight;
    private ObjectMapper mapper;
    
    @Before
    public void before() { 
        // add 20 records to test database
        for(int x=1; x<21; x++){
        	Weight weight = new Weight();
        	defaultSchemaDaoService.getWeightService().save(weight);
	        if (x == 1){
	        	// use this ID for update, show, and delete assertions
	        	firstWeight = weight;
	        }
        }   
        this.mapper = new ObjectMapper();
        // fix NonUniqueObjectException
        this.defaultSchemaDaoService.getWeightService().getSession().flush();
        this.defaultSchemaDaoService.getWeightService().getSession().clear();
    }    
      
    @Test
    public void getByPathVariableIdShouldLoadAndReturnObject() throws Exception {
    	mockMvc.perform(get("null/weight/"+firstWeight.getWeightId().toString()))
         .andExpect(status().isOk())
         .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(jsonPath("$.weightId", is(firstWeight.getWeightId())))
        ;
    }
  
    @Test
    public void getByPathVariableIdShouldReturn404ForBogusId() throws Exception {
    	mockMvc.perform(get("null/weight/-123")).andExpect(status().isNotFound()).andExpect(jsonPath("$.message", is("null/weight/-123 could not be found.")));
    }
    
    @Test
    public void restMappingNotFoundShouldReturn404() throws Exception {
    	mockMvc.perform(get("null/weight/asdfasdf/asdfasdf"))
    	.andExpect(status().isNotFound())
    	 .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(jsonPath("$.message", is("null/weight/asdfasdf/asdfasdf could not be found.")))
    	;
    }
    
    @Test
    public void createShouldPersistAndReturnObject() throws Exception {
	   long count = defaultSchemaDaoService.getWeightService().count();	       
	   Weight weight = new Weight(); 
       
       mockMvc.perform(post("null/weight/").content(this.mapper.writeValueAsString(weight))
	   .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
	   .with(csrf()))
       .andExpect(status().isOk())
       .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
       .andExpect(jsonPath("$.weightId").value(IsNull.notNullValue()))  
       ;
       
       assertEquals("count should increase by 1", count +1 , defaultSchemaDaoService.getWeightService().count());
	}
     
    @Test
    public void updateShouldPersistExistingAndReturnObject() throws Exception {
       long count = defaultSchemaDaoService.getWeightService().count();

       mockMvc.perform(post("null/weight/"+ firstWeight.getWeightId().toString())
    		   .content(this.mapper.writeValueAsString(firstWeight))
    		   .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
    		   .with(csrf()))
       .andExpect(status().isOk())
       .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
       .andExpect(jsonPath("$.weightId", is(firstWeight.getWeightId())))
       ;
         
       assertEquals("count NOT should increase", count , defaultSchemaDaoService.getWeightService().count());
  	}  
    
    @Test
    public void updateByPathVariableIdShouldReturn404ForMismatchBetweenPathIdAndObjectId() throws Exception {	       
       String correctId =  firstWeight.getWeightId().toString();
       // this ID manipulation should be overwritten with path variable id
       firstWeight.setWeightId(-123);
       
       mockMvc.perform(post("null/weight/"+correctId)
    		   .content(this.mapper.writeValueAsString(firstWeight))
    		   .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
    		   .with(csrf()))
       .andExpect(status().isNotFound())
       .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
       .andExpect(jsonPath("$.message", is("null/weight/" +correctId +" could not be found.")))
       ;
  	} 
    
    @Test
    public void updateByPathVariableIdShouldReturn404ForBogusPathId() throws Exception {
    	mockMvc.perform(post("null/weight/-123")
    			.content(this.mapper.writeValueAsString(firstWeight))
    		   .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
    		   .with(csrf()))
    	.andExpect(status().isNotFound())
    	.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
	    .andExpect(jsonPath("$.message", is("null/weight/-123 could not be found.")));
    }
    
    @Test
    public void deleteShouldDeleteAndReturnStatusOk() throws Exception {
        long count = defaultSchemaDaoService.getWeightService().count();

        mockMvc.perform(delete("null/weight/"+ firstWeight.getWeightId().toString()).with(csrf()))
       .andExpect(status().isOk());  
       
       assertEquals("count should decrease by 1", count - 1 , defaultSchemaDaoService.getWeightService().count());
    }
    
    @Test
    public void deleteShouldFailWithBogusId() throws Exception {
        long count = defaultSchemaDaoService.getWeightService().count();

        mockMvc.perform(delete("null/weight/-123").with(csrf()))
       .andExpect(status().isNotFound())
       .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
       .andExpect(jsonPath("$.message", is("null/weight/-123 could not be found.")));  
       
       assertEquals("count should NOT decrease by 1", count , defaultSchemaDaoService.getWeightService().count());
    }

    @Test
    public void listShouldReturnAllByDefault() throws Exception {
    	mockMvc.perform(get("null/weight/"))
         .andExpect(status().isOk())
         .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
         .andExpect(jsonPath("$.", hasSize(is(20))))
        .andExpect(jsonPath("$.[0].weightId", is(firstWeight.getWeightId())))
        ;
    }
    
    @Test
    public void listShouldReturnAllByDefaultWithoutTrailUrlSlash() throws Exception {
    	mockMvc.perform(get("null/weight"))
         .andExpect(status().isOk())
         .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
         .andExpect(jsonPath("$.", hasSize(is(20))))
        .andExpect(jsonPath("$.[0].weightId", is(firstWeight.getWeightId())))
        ;
    }
}