package com.schappet.util;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

public class JsonDateDeserializer extends JsonDeserializer<Date> {
	
    //private static final SimpleDateFormat df = new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ss" );
	
    private static final DateFormat df = new ISO8601DateFormat();

    
    	
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
