package com.schappet.util;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

@Component
public class JsonDateSerializer  extends JsonSerializer<Date> {

        //private static final SimpleDateFormat df = new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ssZ" );
     
          private static final DateFormat df = new ISO8601DateFormat();



        @Override
        public void serialize(Date date, JsonGenerator gen, SerializerProvider provider)
                        throws IOException, JsonProcessingException {

                //String formattedDate = df.format(date);

                TimeZone tz = TimeZone.getTimeZone( "UTC" );
             
             df.setTimeZone( tz );

             String output = df.format( date );
             gen.writeString(output);

             
        }


}