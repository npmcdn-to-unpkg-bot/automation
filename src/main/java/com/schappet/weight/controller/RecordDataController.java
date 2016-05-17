package com.schappet.weight.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.input.BOMInputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.schappet.weight.domain.Activity;
import com.schappet.weight.domain.Person;
import com.schappet.weight.domain.Vitals;
import com.schappet.weight.domain.Weight;

/**
 * Generated by Protogen 
 * @since 04/07/2015 09:42:54 CDT
 */
@Controller
@RequestMapping( "/record/" )
public class RecordDataController extends AbstractWeightController {

    private static final Log log = LogFactory.getLog( RecordDataController.class );

    
    private static final int DEFAULT_PERSON = 1;
    
    
    private final SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy 'at' KK:mma");
    
    private final SimpleDateFormat activitySdf = new SimpleDateFormat("yyyy-MM-dd");
    
    

    @RequestMapping(value = {"weight"}, method = RequestMethod.POST)
    @ResponseBody
    public String debugDataLoader(@RequestBody String input ) {
    	// {date: "2015-04-16" , points: "1652.8" , personId: 1 }
        log.debug("weight input: " + input);
        
    	return "done";
    }

    

    @RequestMapping(value = {"vitals"}, method = RequestMethod.POST)
    @ResponseBody
    public String vitalsLoader(@RequestBody String input ) {
    	// {date: "2015-04-16" , points: "1652.8" , personId: 1 }
        log.debug("vitals input: " + input);
        
    	return "done";
    }

    

    @RequestMapping(value = {"activity"}, method = RequestMethod.POST)
    @ResponseBody
    public String activityLoader(@RequestBody String input ) {
    	// {date: "2015-04-16" , points: "1652.8" , personId: 1 }
        log.debug("activity input: " + input);
        
    	return "done";
    }

    
    @RequestMapping(value = {"data"}, method = RequestMethod.POST)
    @ResponseBody
    public String dataLoader(HttpServletRequest request,
    		@RequestParam(value="file", required=true) CommonsMultipartFile locationMapFileData,
    		@RequestParam(value="data") String data) {
    	//Map<String, String[]> names = request.getParameterMap();
    	InputStream in ;
    	String jsonStr;
		try {
			in = locationMapFileData.getInputStream();
			
			log.debug("fileName: " + locationMapFileData.getOriginalFilename());
			//log.debug("contents: " + jsonStr);
    		
    		
		
			if (locationMapFileData.getOriginalFilename().startsWith("weight_")) {
				jsonStr = IOUtils.toString(in, "UTF-8");
				JSONObject json = new JSONObject(jsonStr);
	    		recordWeight(json);
			}
			if (locationMapFileData.getOriginalFilename().startsWith("activity_")) {
				jsonStr = IOUtils.toString(in, "UTF-8");
				JSONObject json = new JSONObject(jsonStr);
	    		recordActivity(json);
			}
			if (locationMapFileData.getOriginalFilename().startsWith("vitals_") || locationMapFileData.getOriginalFilename().equals("Jimmy.csv") ) {
				log.debug("Recording vitals");
	    		recordVitals(in);
			}
			
 			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("error parsing json", e);
		} 
        return "done";
    }

    public void recordVitalsNonCSV(InputStream vitalsCsv) throws IOException {
    	Reader initialReader = null;
    	try {
    	    initialReader = newReader(vitalsCsv);
    	    String targetString = IOUtils.toString(initialReader);
    	    log.debug("input: " + targetString.substring(0, 100));
    	    String[] lines = targetString.split("\n");
    	    for (String line : lines) {
    	    	log.debug(line);
    	    }
    	} catch (Exception e) {
    		log.error("Exception: ", e);
    	} finally {
    		if (initialReader != null) 
    			initialReader.close();
    			
    	}
    }
    
    private static final int BATCH_SIZE=200;

    
    public void recordVitals(InputStream vitalsCsv) {
    	Person defaultPerson = weightDaoService.getPersonService().findById(DEFAULT_PERSON);
    	
    	char delimiter = '	';
    	
    	Iterable<CSVRecord> records;
		try {
			records = CSVFormat.DEFAULT
					.withHeader()//"Date","Time","SYS","DIA","Pulse","Comments","Empty")
					.withDelimiter(delimiter)
					.parse(newReader(vitalsCsv));
			//records = CSVFormat.newFormat(',').parse(newReader(vitalsCsv));
			log.debug("got records");
			List<Vitals> batch = new ArrayList<Vitals>();
			for (CSVRecord record : records) {
				Vitals v ;
				
				//Date,Time,SYS,DIA,Pulse,Comments,
	    	    String date = record.get("Date");
	    	    String time = record.get("Time");
	    	    String sys = record.get("SYS");
	    	    String dia = record.get("DIA");
	    	    
	    	    String pulse = record.get("Pulse");
	    	    
	    	    String comments = record.get("Comments");
	    	    Date dateTime = parseDate(date + " " + time);
	    	    if (dateTime != null) {
	    	    	v = weightDaoService.getVitalsService().findByPersonIdAndDate(defaultPerson, dateTime);
		    	    if (v == null) {
		    	    	v = new Vitals ();
		    	    	try {
				    	    v.setComment(comments);
				    	    v.setDiatolic(Integer.parseInt(dia));
				    	    v.setSystolic(Integer.parseInt(sys));
				    	    v.setVitalsDate(dateTime);
				    	    v.setPulse(Integer.parseInt(pulse));
				    	    v.setPerson(defaultPerson);
				    	    batch.add(v);
			    	    } catch (NumberFormatException nfe) {
			    	    	log.error("NFE: "  + dateTime, nfe);
			    	    }	
		    	    } else {
		    	    	log.debug("aready added: "  + dateTime);
		    	    }
		    	    
	
	    	    }
	    	    
	    	    if (batch.size() > BATCH_SIZE)  {
	    			weightDaoService.getVitalsService().save(batch);
    				batch.clear();
    			}
	    	    //log.debug("date: " + date + " dia: " + dia);
	    	}
			weightDaoService.getVitalsService().save(batch);
			log.debug("Done reading records");
		} catch (Exception e) {
			
			log.error("Could not parse csv", e);
			
		}
    	
    	
    	
    	
    }
    
    private Date parseDate(String date) {
    	Date vitalsDate = null;
    	 try{
             DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
             formatter.setLenient(true);
             vitalsDate = formatter.parse(date);
         } catch (ParseException e) { 
         	try {
         		//"yyyy-MM-dd hh:mm"
         		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");
                 formatter.setLenient(true);
                 vitalsDate = formatter.parse(date);
         	} catch (ParseException e1) {
         		log.error(" ParseException setting date for VitalsDate", e);
         	}
         	
             //log.error(" ParseException setting date for VitalsDate", e);
         }
    	 return vitalsDate;
    }
    
    public InputStreamReader newReader(final InputStream inputStream) {
        return new InputStreamReader(new BOMInputStream(inputStream), StandardCharsets.UTF_16);
    }
    
    public void recordWeight(JSONObject json) {
		// { "MeasuredAt": April 01, 2015 at 05:22AM, "WeightLb": 191.28 }
		String dateStr = json.getString("MeasuredAt");
		Double value = json.getDouble("WeightLb");
		Date date = new Date();
		try {
			date = sdf.parse(dateStr);
			
		} catch (Exception pe) {
			log.debug("could not parse date", pe);
		}
		log.debug("Date : " + date + " : Value: " + value);
		Weight w = new Weight();
		Person defaultPerson = weightDaoService.getPersonService().findById(DEFAULT_PERSON);
		w.setPerson(defaultPerson);
		w.setWeightInDate(date);
		w.setValue(""+value);
		weightDaoService.getWeightService().save(w);

    }
 
    public void recordActivity(JSONObject json) {
		// { "MeasuredAt": April 01, 2015 at 05:22AM, "WeightLb": 191.28 }
		String dateStr = json.getString("date");
		String points = json.getString("points");
		int personId = json.getInt("personId");
		
		Date date = new Date();
		try {
			date = activitySdf.parse(dateStr);
			
		} catch (Exception pe) {
			log.debug("could not parse date", pe);
		}
		log.debug("Date : " + dateStr + " : Value: " + points);
		Activity a = new Activity();
		a.setActivityDate(date);
		Person p = weightDaoService.getPersonService().findById(personId);
		a.setPerson(p);
		a.setValue(points);
		weightDaoService.getActivityService().save(a);

    }
 
    
}