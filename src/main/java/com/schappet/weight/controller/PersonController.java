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
import com.schappet.util.PasswordTools;
import com.schappet.weight.domain.Person;

/**
 * Generated by Protogen 
 * @since 04/07/2015 09:42:54 CDT
 */
@Controller
@RequestMapping( "/person" )
public class PersonController extends AbstractWeightController {

    private static final Log log = LogFactory.getLog( PersonController.class );

    @RequestMapping( value = "list_alt", method = RequestMethod.GET )
    public String listNoScript(Model model) {
        model.addAttribute( "personList", weightDaoService.getPersonService().list() );
        return "/weight/person/list_alt";
    }

    @RequestMapping(value = {"list", "", "/"}, method = RequestMethod.GET)
    public String list() {
        return "/weight/person/list";
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

			Integer count = weightDaoService.getPersonService().count( options );

            options.setLimit( limit );
            options.setStart( start );
            options.setSorts( sorts );

            List<Person> personList = weightDaoService.getPersonService().list( options );

			//ob.put( "draw", draw );
            dt.setDraw(draw);
			//ob.put( "recordsFiltered", count );
            dt.setRecordsFiltered(count);
			//ob.put( "recordsTotal", count );
            dt.setRecordsTotal(count);
            List<LinkedHashMap<String, String>> data = new ArrayList<LinkedHashMap<String, String>>();
  
			for( Person person : personList ){
				LinkedHashMap<String, String> row = new LinkedHashMap<String, String>();
				for ( DataTableHeader header : headers ) {
					String headerName = header.getName();
					String dataName = header.getData();

					if( StringUtils.equals( "personId", headerName ) ){
						row.put(dataName,""+ person.getPersonId() );
					} else if( StringUtils.equals( "emailId", headerName ) ){
						row.put(dataName,""+ person.getEmailId() );
					} else if( StringUtils.equals( "password", headerName ) ){
						row.put(dataName,""+ person.getPassword() );
					} else if( StringUtils.equals( "firstName", headerName ) ){
						row.put(dataName,""+ person.getFirstName() );
					} else if( StringUtils.equals( "lastName", headerName ) ){
						row.put(dataName,""+ person.getLastName() );
					} else if( StringUtils.equals( "middleName", headerName ) ){
						row.put(dataName,""+ person.getMiddleName() );
					} else if( StringUtils.equals( "urls", headerName ) ) {
						String urls = "";
						if( StringUtils.equals( "list", display ) ){
							urls += "<a href=\"show?"+"personId="+person.getPersonId()+"\"><span class=\"glyphicon glyphicon-eye-open\"></a>";
							urls += "<a href=\"edit?"+"personId="+person.getPersonId()+"\"><span class=\"glyphicon glyphicon-pencil\"></a>";
							urls += "<a href=\"delete?"+"personId="+person.getPersonId()+"\"><span class=\"glyphicon glyphicon-trash\"></a>";
						} else {

						}
						row.put(dataName, urls );
					} else {
						row.put(dataName, "[error: column " + headerName + " not supported]" );
					}
				}
								data.add(row);
			}
			//ob.put( "data", jsonArray );
			dt.setData(data);


		} catch ( Exception e ) {
			log.error( "error builing datatable json object for Person", e );
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
				log.error( "error building json error object for Person", je );
			}
		}
		
		return dt;
	}

    @RequestMapping( value = "add", method = RequestMethod.GET )
    public String add( Model model ) {
        model.addAttribute( "person", new Person() );

        return "/weight/person/edit";
    }

    @RequestMapping( value = "edit", method = RequestMethod.GET )
    public String edit( ModelMap model, @RequestParam( value = "personId" ) Integer personId ) {


        model.addAttribute( "person", weightDaoService.getPersonService().findById( personId ) );
        return "/weight/person/edit";
    }

    @RequestMapping( value = "show", method = RequestMethod.GET )
    public String show( ModelMap model, @RequestParam( value = "personId" ) Integer personId ) {

        model.addAttribute( "person", weightDaoService.getPersonService().findById( personId ) );
        return "/weight/person/show";
    }

    @RequestMapping( value = "save", method = RequestMethod.POST )
    public String save( @Valid @ModelAttribute( "person" ) Person person, BindingResult result, Model model ) {


		if (result.hasErrors()) { 
			
			return "/weight/person/edit"; 
		} else {
			try {
				weightDaoService.getPersonService().saveOrUpdate( person );
			} catch (NonUniqueObjectException e) {
				log.debug("Merging Results");
				weightDaoService.getPersonService().merge( person );
			}
	        return "redirect:/person/list";
		}
    }

    @RequestMapping( value = "delete", method = RequestMethod.GET )
    public String confirmDelete( ModelMap model, @RequestParam( value = "personId" ) Integer personId ) {

        model.addAttribute( "person", weightDaoService.getPersonService().findById( personId ) );
        return "/weight/person/delete";
    }

    @RequestMapping( value = "delete", method = RequestMethod.POST )
    public String doDelete( ModelMap model, @RequestParam( value = "submit" ) String submitButtonValue, @RequestParam( value = "personId" ) Integer personId ) {

        if ( StringUtils.equalsIgnoreCase( submitButtonValue, "yes" ) ) {
            weightDaoService.getPersonService().delete( weightDaoService.getPersonService().findById( personId ) );
        }
        return "redirect:/person/list";
    }
}