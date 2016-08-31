package com.schappet.weight.resource;




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
import com.schappet.weight.dao.*;
import com.schappet.weight.domain.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.schappet.weight.controller.AbstractControllerMVCTests;

/**
 * Generated by Protogen
 * @see <a href="https://github.com/ui-icts/protogen">https://github.com/ui-icts/protogen</a>
 * @since Wed Jun 08 09:07:58 CDT 2016
 */
public class StepCountResourceMvcTest extends AbstractControllerMVCTests {
	
    private StepCount firstStepCount;
    private ObjectMapper mapper;
    
    @Before
    public void before() { 
        // add 20 records to test database
        for(int x=1; x<21; x++){
        	StepCount stepCount = new StepCount();
        	weightDaoService.getStepCountService().save(stepCount);
	        if (x == 1){
	        	// use this ID for update, show, and delete assertions
	        	firstStepCount = stepCount;
	        }
        }   
        this.mapper = new ObjectMapper();
        // fix NonUniqueObjectException
        this.weightDaoService.getStepCountService().getSession().flush();
        this.weightDaoService.getStepCountService().getSession().clear();
    }    
      
    @Test
    public void getByPathVariableIdShouldLoadAndReturnObject() throws Exception {
    	mockMvc.perform(get("null/stepcount/"+firstStepCount.getId().toString()))
         .andExpect(status().isOk())
         .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(jsonPath("$.id", is(firstStepCount.getId())))
        ;
    }
  
    @Test
    public void getByPathVariableIdShouldReturn404ForBogusId() throws Exception {
    	mockMvc.perform(get("null/stepcount/-123")).andExpect(status().isNotFound()).andExpect(jsonPath("$.message", is("null/stepcount/-123 could not be found.")));
    }
    
    @Test
    public void restMappingNotFoundShouldReturn404() throws Exception {
    	mockMvc.perform(get("null/stepcount/asdfasdf/asdfasdf"))
    	.andExpect(status().isNotFound())
    	 .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(jsonPath("$.message", is("null/stepcount/asdfasdf/asdfasdf could not be found.")))
    	;
    }
    
    @Test
    public void createShouldPersistAndReturnObject() throws Exception {
	   long count = weightDaoService.getStepCountService().count();	       
	   StepCount stepCount = new StepCount(); 
       
       mockMvc.perform(post("null/stepcount/").content(this.mapper.writeValueAsString(stepCount))
	   .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON))
       .andExpect(status().isOk())
       .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
       .andExpect(jsonPath("$.id").value(IsNull.notNullValue()))  
       ;
       
       assertEquals("count should increase by 1", count +1 , weightDaoService.getStepCountService().count());
	}
     
    @Test
    public void updateShouldPersistExistingAndReturnObject() throws Exception {
       long count = weightDaoService.getStepCountService().count();

       mockMvc.perform(post("null/stepcount/"+ firstStepCount.getId().toString())
    		   .content(this.mapper.writeValueAsString(firstStepCount))
    		   .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON))
       .andExpect(status().isOk())
       .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
       .andExpect(jsonPath("$.id", is(firstStepCount.getId())))
       ;
         
       assertEquals("count NOT should increase", count , weightDaoService.getStepCountService().count());
  	}  
    
    @Test
    public void updateByPathVariableIdShouldReturn404ForMismatchBetweenPathIdAndObjectId() throws Exception {	       
       String correctId =  firstStepCount.getId().toString();
       // this ID manipulation should be overwritten with path variable id
       firstStepCount.setId(-123);
       
       mockMvc.perform(post("null/stepcount/"+correctId)
    		   .content(this.mapper.writeValueAsString(firstStepCount))
    		   .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON))
       .andExpect(status().isNotFound())
       .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
       .andExpect(jsonPath("$.message", is("null/stepcount/" +correctId +" could not be found.")))
       ;
  	} 
    
    @Test
    public void updateByPathVariableIdShouldReturn404ForBogusPathId() throws Exception {
    	mockMvc.perform(post("null/stepcount/-123")
    			.content(this.mapper.writeValueAsString(firstStepCount))
    		   .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON))
    	.andExpect(status().isNotFound())
    	.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
	    .andExpect(jsonPath("$.message", is("null/stepcount/-123 could not be found.")));
    }
    
    @Test
    public void deleteShouldDeleteAndReturnStatusOk() throws Exception {
        long count = weightDaoService.getStepCountService().count();

        mockMvc.perform(delete("null/stepcount/"+ firstStepCount.getId().toString()))
       .andExpect(status().isOk());  
       
       assertEquals("count should decrease by 1", count - 1 , weightDaoService.getStepCountService().count());
    }
    
    @Test
    public void deleteShouldFailWithBogusId() throws Exception {
        long count = weightDaoService.getStepCountService().count();

        mockMvc.perform(delete("null/stepcount/-123"))
       .andExpect(status().isNotFound())
       .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
       .andExpect(jsonPath("$.message", is("null/stepcount/-123 could not be found.")));  
       
       assertEquals("count should NOT decrease by 1", count , weightDaoService.getStepCountService().count());
    }

    @Test
    public void listShouldReturnAllByDefault() throws Exception {
    	mockMvc.perform(get("null/stepcount/"))
         .andExpect(status().isOk())
         .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
         .andExpect(jsonPath("$.", hasSize(is(20))))
        .andExpect(jsonPath("$.[0].id", is(firstStepCount.getId())))
        ;
    }
    
    @Test
    public void listShouldReturnAllByDefaultWithoutTrailUrlSlash() throws Exception {
    	mockMvc.perform(get("null/stepcount"))
         .andExpect(status().isOk())
         .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
         .andExpect(jsonPath("$.", hasSize(is(20))))
        .andExpect(jsonPath("$.[0].id", is(firstStepCount.getId())))
        ;
    }
}