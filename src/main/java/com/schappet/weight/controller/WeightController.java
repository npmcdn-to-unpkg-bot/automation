package com.schappet.weight.controller;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.NonUniqueObjectException;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.schappet.util.DataTable;
import com.schappet.web.WeightView;
import com.schappet.weight.domain.Weight;

import edu.uiowa.icts.spring.GenericDaoListOptions;
import edu.uiowa.icts.util.DataTableHeader;
import edu.uiowa.icts.util.SortColumn;

/**
 * Generated by Protogen 
 * @since 04/07/2015 09:42:54 CDT
 */
@Controller
@RequestMapping( "/weight/*" )
public class WeightController extends AbstractWeightController {

    private static final Log log = LogFactory.getLog( WeightController.class );

    @RequestMapping( value = "list_alt", method = RequestMethod.GET )
    public String listNoScript(Model model) {
        model.addAttribute( "weightList", weightDaoService.getWeightService().list() );
        return "/weight/weight/list_alt";
    }

    @RequestMapping(value = {"list", "", "/"}, method = RequestMethod.GET)
    public String list() {
        return "/weight/weight/list";
    }

    private final SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy 'at' KK:mma");
    

    
    @RequestMapping(value = {"latest/"})
    @ResponseBody
    public List<WeightView> latest() {
    	//[ { "date": "2015-04-08 05:19:00", "value": "191.35" } ]
    	Weight w = weightDaoService.getWeightService().latest(1);
    	WeightView wv = new WeightView();
    	wv.setDate(w.getWeightInDate());
    	wv.setValue(w.getValue());
    	List<WeightView> list = new ArrayList<WeightView>();
    	list.add(wv);
    	return list;
    	
    }
    
    @RequestMapping(value = {"record/"}, method = RequestMethod.POST)
    @ResponseBody
    public String list(HttpServletRequest request,
    		@RequestParam(value="file", required=true) CommonsMultipartFile locationMapFileData,
    		@RequestParam(value="data") String data) {
    	//Map<String, String[]> names = request.getParameterMap();
    	InputStream in ;
    	String jsonStr;
		try {
			 in = locationMapFileData.getInputStream();
			jsonStr = IOUtils.toString(in, "UTF-8");
			log.debug("contents: " + jsonStr);
    		
    		JSONObject json = new JSONObject(jsonStr);
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
    		w.setPersonId(2);
    		w.setWeightInDate(date);
    		w.setValue(""+value);
    		weightDaoService.getWeightService().save(w);
    	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("error parsing json", e);
		} 
        return "done";
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

			Integer count = weightDaoService.getWeightService().count( options );

            options.setLimit( limit );
            options.setStart( start );
            options.setSorts( sorts );

            List<Weight> weightList = weightDaoService.getWeightService().list( options );

			//ob.put( "draw", draw );
            dt.setDraw(draw);
			//ob.put( "recordsFiltered", count );
            dt.setRecordsFiltered(count);
			//ob.put( "recordsTotal", count );
            dt.setRecordsTotal(count);
            List<LinkedHashMap<String, String>> data = new ArrayList<LinkedHashMap<String, String>>();
  
			for( Weight weight : weightList ){
				LinkedHashMap<String, String> row = new LinkedHashMap<String, String>();
				for ( DataTableHeader header : headers ) {
					String headerName = header.getName();
					String dataName = header.getData();
					if( StringUtils.equals( "weightId", headerName ) ){
						row.put(dataName,""+ weight.getWeightId() );
					} else if( StringUtils.equals( "personId", headerName ) ){
						row.put(dataName,""+ weight.getPersonId() );
					} else if( StringUtils.equals( "value", headerName ) ){
						row.put(dataName,""+ weight.getValue() );
					} else if( StringUtils.equals( "weightInDate", headerName ) ){
						row.put(dataName,""+ weight.getWeightInDate() );
					} else if( StringUtils.equals( "urls", headerName ) ) {
						String urls = "";
						if( StringUtils.equals( "list", display ) ){
							urls += "<a href=\"show?"+"weightId="+weight.getWeightId()+"\"><span class=\"glyphicon glyphicon-eye-open\"></a>";
							urls += "<a href=\"edit?"+"weightId="+weight.getWeightId()+"\"><span class=\"glyphicon glyphicon-pencil\"></a>";
							urls += "<a href=\"delete?"+"weightId="+weight.getWeightId()+"\"><span class=\"glyphicon glyphicon-trash\"></a>";
						} else {

						}
						row.put(dataName,urls );
					} else {
						row.put(dataName, "[error: column " + headerName + " not supported]" );
					}
				}
				data.add(row);
			}
			//ob.put( "data", jsonArray );
			dt.setData(data);


		} catch ( Exception e ) {
			log.error( "error builing datatable json object for Weight", e );
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
				log.error( "error building json error object for Weight", je );
			}
		}
		
		return dt;
	}

    @RequestMapping( value = "add", method = RequestMethod.GET )
    public String add( Model model ) {
        model.addAttribute( "weight", new Weight() );

        return "/weight/weight/edit";
    }

    @RequestMapping( value = "edit", method = RequestMethod.GET )
    public String edit( ModelMap model, @RequestParam( value = "weightId" ) Integer weightId ) {


        model.addAttribute( "weight", weightDaoService.getWeightService().findById( weightId ) );
        return "/weight/weight/edit";
    }

    @RequestMapping( value = "show", method = RequestMethod.GET )
    public String show( ModelMap model, @RequestParam( value = "weightId" ) Integer weightId ) {

        model.addAttribute( "weight", weightDaoService.getWeightService().findById( weightId ) );
        return "/weight/weight/show";
    }

    @RequestMapping( value = "save", method = RequestMethod.POST )
    public String save( @Valid @ModelAttribute( "weight" ) Weight weight, BindingResult result, Model model ) {



		if (result.hasErrors()) { 
			
			return "/weight/weight/edit"; 
		} else {
			try {
				weightDaoService.getWeightService().saveOrUpdate( weight );
			} catch (NonUniqueObjectException e) {
				log.debug("Merging Results");
				weightDaoService.getWeightService().merge( weight );
			}
	        return "redirect:/weight/list";
		}
    }

    @RequestMapping( value = "delete", method = RequestMethod.GET )
    public String confirmDelete( ModelMap model, @RequestParam( value = "weightId" ) Integer weightId ) {

        model.addAttribute( "weight", weightDaoService.getWeightService().findById( weightId ) );
        return "/weight/weight/delete";
    }

    @RequestMapping( value = "delete", method = RequestMethod.POST )
    public String doDelete( ModelMap model, @RequestParam( value = "submit" ) String submitButtonValue, @RequestParam( value = "weightId" ) Integer weightId ) {

        if ( StringUtils.equalsIgnoreCase( submitButtonValue, "yes" ) ) {
            weightDaoService.getWeightService().delete( weightDaoService.getWeightService().findById( weightId ) );
        }
        return "redirect:/weight/list";
    }
}