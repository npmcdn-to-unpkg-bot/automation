package com.schappet.util;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class JsonDateDeserializer extends JsonDeserializer<Date> {
	
    private static final SimpleDateFormat df = new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ss" );
    
    	
	  @Override
	    public Date deserialize(JsonParser jsonparser,
	            DeserializationContext deserializationcontext) throws IOException, JsonProcessingException {

	        String date = jsonparser.getText();
	        
	
	        try {
	            return df.parse(date);
	        } catch (ParseException e) {
	            throw new RuntimeException(e);
	        }

	    }

}
