package com.schappet.weight.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.NonUniqueObjectException;
import org.json.JSONException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.schappet.spring.DataTableHeader;
import com.schappet.spring.GenericDaoListOptions;
import com.schappet.spring.SortColumn;
import com.schappet.util.DataTable;
import com.schappet.web.C3;
import com.schappet.web.C3Vitals;
import com.schappet.web.WeightView;
import com.schappet.weight.domain.Activity;
import com.schappet.weight.domain.Vitals;
import com.schappet.weight.domain.Weight;

/**
 * Generated by Protogen 
 * @since 04/11/2015 07:34:51 CDT
 */
@Controller
@RequestMapping( "/vitals" )
public class VitalsController extends AbstractWeightController {

    private static final Log log = LogFactory.getLog( VitalsController.class );

    @RequestMapping( value = "list_alt", method = RequestMethod.GET )
    public String listNoScript(Model model) {
        model.addAttribute( "vitalsList", weightDaoService.getVitalsService().list() );
        return "/weight/vitals/list_alt";
    }

    @RequestMapping(value = {"list", "", "/"}, method = RequestMethod.GET)
    public String list() {
        return "/weight/vitals/list";
    }

    private static final int DEFAULT_PERSON = 1;

    
    

    @RequestMapping(value = {"c3/last30/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public C3Vitals last30C3()
    {
    	
    	List<Vitals> list = weightDaoService.getVitalsService().latest(DEFAULT_PERSON,30);
    	
    	Map<String,Integer[]> tempMap = new HashMap<String, Integer[]>();
    	String date = "";
    	
    	if (list.size() > 0) {
    		for (Vitals w: list) {
    			
    			date = shortDate.format(w.getVitalsDate());
    			
    			Integer[] values = tempMap.get(date);
    			if (values == null)
    				values = new Integer[3];
    			
    			values[0] = w.getDiatolic();
    			values[1] = w.getSystolic();
    			values[2] = w.getPulse();
    			
    			//log.debug("date: " + date + " values: " + values);
    			tempMap.put(date, values);
    		}
//    		for (Activity a : aList) {
//    			date = shortDate.format(a.getActivityDate());
//    			Float[] values = tempMap.get(date);
//    			if (values == null)
//    				values = new Float[2];
//    			values[1] = Float.parseFloat(a.getValue())  ;
//    			tempMap.put(date, values);
//    		}
        	//return c3;
    	} else {
    		//log.debug("Start Date: " + startDate);
    		//log.debug("End Date: " + endDate);
    		//return null;
    	}
    	
    	// tempMap to C3 List
    	List<String> dates = new ArrayList<String>();
    	List<Integer> diastolic = new ArrayList<Integer>();
		List<Integer> systolic = new ArrayList<Integer>();
		List<Integer> pulse = new ArrayList<Integer>();
		C3Vitals c3 = new C3Vitals();
    	for (String key : tempMap.keySet()) {
            		
       		dates.add(key);
           	diastolic.add(tempMap.get(key)[0]);
           	systolic.add(tempMap.get(key)[1]);
           	pulse.add(tempMap.get(key)[2]);
            	
    	}
    	c3.setX(dates);
    	c3.setDiastolic(diastolic);
    	c3.setSystolic(systolic);
    	c3.setPulse(pulse);
	
    	return c3;
    	
    }
    

	@ResponseBody
	@RequestMapping( value = "datatable" , produces = "application/json" )
	public DataTable datatable( HttpServletRequest request, 
		@RequestParam( value = "length" , required = false ) Integer limit,
		@RequestParam( value = "start" , required = false ) Integer start,
		@RequestParam( value = "draw" , required = false ) String draw,
		@RequestParam( value = "search[regex]" , required = false , defaultValue = "false" ) Boolean searchRegularExpression,
		@RequestParam( value = "search[value]" , required = false ) String search,
		@RequestParam( value = "columnCount" , required = false , defaultValue = "0" ) Integer columnCount,
		@RequestParam( value = "individualSearch" , required = false , defaultValue = "false" ) Boolean individualSearch,
		@RequestParam( value = "display" , required = false , defaultValue = "list" ) String display ) {
		
		List<DataTableHeader> headers = new ArrayList<DataTableHeader>();
		for ( int i = 0; i < columnCount; i++ ) {
			DataTableHeader dth = new DataTableHeader();
			dth.setData( request.getParameter( "columns[" + i + "][data]" ) );
			dth.setName( request.getParameter( "columns[" + i + "][name]" ) );
			dth.setOrderable( Boolean.valueOf( request.getParameter( "columns[" + i + "][orderable]" ) ) );
			dth.setSearchable( Boolean.valueOf( request.getParameter( "columns[" + i + "][searchable]" ) ) );
			dth.setSearchValue( request.getParameter( "columns[" + i + "][search][value]" ) );
			dth.setSearchRegex( Boolean.valueOf( request.getParameter( "columns[" + i + "][search][regex]" ) ) );
			headers.add( dth );
		}

		ArrayList<SortColumn> sorts = new ArrayList<SortColumn>();
		
		//JSONObject ob = new JSONObject();
		DataTable dt = new DataTable();

		try {

			for ( int i = 0; i < columnCount; i++ ) {
				Integer columnIndex = null;
				String columnIndexString = request.getParameter( "order[" + i + "][column]" );
				if ( columnIndexString != null ) {
					try {
						columnIndex = Integer.parseInt( columnIndexString );
					} catch ( NumberFormatException e ) {
						continue;
					}
					if ( columnIndex != null ) {
						sorts.add( new SortColumn( headers.get( columnIndex ).getName(), request.getParameter( "order[" + i + "][dir]" ) ) );
					}
				}
			}

			GenericDaoListOptions options = new GenericDaoListOptions();

			if ( !individualSearch ) {
				ArrayList<String> searchColumns = new ArrayList<String>();
				for ( int i = 0; i < columnCount; i++ ) {
					if ( headers.get( i ).getSearchable() ) {
						searchColumns.add( headers.get( i ).getName() );
					}
				}
				options.setSearch( search );
				options.setSearchColumns( searchColumns );
			} else {
				Map<String, List<Object>> likes = new HashMap<String, List<Object>>();
				for ( DataTableHeader header : headers ) {
					if ( header.getSearchable() && header.getSearchValue() != null ) {
						List<Object> values = new ArrayList<Object>();
						for ( String splitColumnValue : StringUtils.split( header.getSearchValue().trim(), ' ' ) ) {
							values.add( splitColumnValue.trim() );
						}
						likes.put( header.getName(), values );
					}
				}
				options.setLikes( likes );
			}

			Integer count = weightDaoService.getVitalsService().count( options );

            options.setLimit( limit );
            options.setStart( start );
            options.setSorts( sorts );

            List<Vitals> vitalsList = weightDaoService.getVitalsService().list( options );

			//ob.put( "draw", draw );
            dt.setDraw(draw);
			//ob.put( "recordsFiltered", count );
            dt.setRecordsFiltered(count);
			//ob.put( "recordsTotal", count );
            dt.setRecordsTotal(count);
            List<LinkedHashMap<String, String>> data = new ArrayList<LinkedHashMap<String, String>>();
  
			for( Vitals vitals : vitalsList ){
				LinkedHashMap<String, String> row = new LinkedHashMap<String, String>();
				for ( DataTableHeader header : headers ) {
					String headerName = header.getName();
					String dataName = header.getData();

					if( StringUtils.equals( "vitalsId", headerName ) ){
						row.put(dataName,""+ vitals.getVitalsId() );
					} else if( StringUtils.equals( "personId", headerName ) ){
						row.put(dataName,""+ vitals.getPersonId() );
					} else if( StringUtils.equals( "vitalsDate", headerName ) ){
						row.put(dataName,""+ vitals.getVitalsDate() );
					} else if( StringUtils.equals( "systolic", headerName ) ){
						row.put(dataName,""+ vitals.getSystolic() );
					} else if( StringUtils.equals( "diatolic", headerName ) ){
						row.put(dataName,""+ vitals.getDiatolic() );
					} else if( StringUtils.equals( "pulse", headerName ) ){
						row.put(dataName,""+ vitals.getPulse() );
					} else if( StringUtils.equals( "comment", headerName ) ){
						row.put(dataName,""+ vitals.getComment() );
					} else if( StringUtils.equals( "urls", headerName ) ) {
						String urls = "";
						if( StringUtils.equals( "list", display ) ){
							urls += "<a href=\"show?"+"vitalsId="+vitals.getVitalsId()+"\"><span class=\"glyphicon glyphicon-eye-open\"></a>";
							urls += "<a href=\"edit?"+"vitalsId="+vitals.getVitalsId()+"\"><span class=\"glyphicon glyphicon-pencil\"></a>";
							urls += "<a href=\"delete?"+"vitalsId="+vitals.getVitalsId()+"\"><span class=\"glyphicon glyphicon-trash\"></a>";
						} else {

						}
						row.put(dataName,""+ urls );
					} else {
						row.put(dataName,""+ "[error: column " + headerName + " not supported]" );
					}
				}
								data.add(row);
			}
			//ob.put( "data", jsonArray );
			dt.setData(data);


		} catch ( Exception e ) {
			log.error( "error builing datatable json object for Vitals", e );
			try {
				String stackTrace = e.getMessage() + String.valueOf( '\n' );
				for ( StackTraceElement ste : e.getStackTrace() ) {
					stackTrace += ste.toString() + String.valueOf( '\n' );
				}
				DataTable error = new DataTable();
				error.setDraw( draw );
				error.setRecordsFiltered( 0 );
				error.setRecordsTotal( 0 );
				error.setError( stackTrace );
				return error;
			} catch ( JSONException je ) {
				log.error( "error building json error object for Vitals", je );
			}
		}
		
		return dt;
	}

    @RequestMapping( value = "add", method = RequestMethod.GET )
    public String add( Model model ) {
        model.addAttribute( "vitals", new Vitals() );

        return "/weight/vitals/edit";
    }

    @RequestMapping( value = "edit", method = RequestMethod.GET )
    public String edit( ModelMap model, @RequestParam( value = "vitalsId" ) Integer vitalsId ) {


        model.addAttribute( "vitals", weightDaoService.getVitalsService().findById( vitalsId ) );
        return "/weight/vitals/edit";
    }

    @RequestMapping( value = "show", method = RequestMethod.GET )
    public String show( ModelMap model, @RequestParam( value = "vitalsId" ) Integer vitalsId ) {

        model.addAttribute( "vitals", weightDaoService.getVitalsService().findById( vitalsId ) );
        return "/weight/vitals/show";
    }

    @RequestMapping( value = "save", method = RequestMethod.POST )
    public String save( @Valid @ModelAttribute( "vitals" ) Vitals vitals, BindingResult result, Model model ) {



		if (result.hasErrors()) { 
			
			return "/weight/vitals/edit"; 
		} else {
			try {
				weightDaoService.getVitalsService().saveOrUpdate( vitals );
			} catch (NonUniqueObjectException e) {
				log.debug("Merging Results");
				weightDaoService.getVitalsService().merge( vitals );
			}
	        return "redirect:/vitals/list";
		}
    }

    @RequestMapping( value = "delete", method = RequestMethod.GET )
    public String confirmDelete( ModelMap model, @RequestParam( value = "vitalsId" ) Integer vitalsId ) {

        model.addAttribute( "vitals", weightDaoService.getVitalsService().findById( vitalsId ) );
        return "/weight/vitals/delete";
    }

    @RequestMapping( value = "delete", method = RequestMethod.POST )
    public String doDelete( ModelMap model, @RequestParam( value = "submit" ) String submitButtonValue, @RequestParam( value = "vitalsId" ) Integer vitalsId ) {

        if ( StringUtils.equalsIgnoreCase( submitButtonValue, "yes" ) ) {
            weightDaoService.getVitalsService().delete( weightDaoService.getVitalsService().findById( vitalsId ) );
        }
        return "redirect:/vitals/list";
    }
}