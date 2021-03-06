package com.schappet.weight.controller;



import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.NonUniqueObjectException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.uiowa.icts.datatable.DataTable;
import edu.uiowa.icts.datatable.DataTableColumn;
import edu.uiowa.icts.datatable.DataTableRequest;
import com.schappet.weight.domain.*;
import edu.uiowa.icts.spring.GenericDaoListOptions;

/**
 * Generated by Protogen 
 * @see <a href="https://github.com/ui-icts/protogen">https://github.com/ui-icts/protogen</a>
 * @since 06/03/2016 06:46:13 CDT
 */
@Controller( value = "com_schappet_weight_controller_heartrate_controller" )
@RequestMapping( "/heartrate" )
public class HeartRateController extends AbstractWeightController {

    private static final Log log = LogFactory.getLog( HeartRateController.class );

    @RequestMapping( value = "list_alt", method = RequestMethod.GET )
    public String listNoScript(Model model) {
        model.addAttribute( "heartRateList", weightDaoService.getHeartRateService().list() );
        return "/weight/heartrate/list_alt";
    }

    @RequestMapping( value = { "list", "", "/" }, method = RequestMethod.GET )
    public String list(Model model) {
    	// needed for AngularJS grid/CRUD functionality
    			model.addAttribute( "personList", weightDaoService.getPersonService().list() );
 
        return "/weight/heartrate/list";
    }


	@ResponseBody
	@RequestMapping( value = "datatable" , produces = "application/json" )
	public DataTable datatable( @RequestBody DataTableRequest dataTableRequest, HttpServletRequest request,
		@RequestParam( value = "display" , required = false , defaultValue = "list" ) String display ) {
		
		String contextPath = request.getContextPath();
		GenericDaoListOptions options = dataTableRequest.getGenericDaoListOptions();

		try {

			Integer count = weightDaoService.getHeartRateService().count( options );
            List<HeartRate> heartRateList = weightDaoService.getHeartRateService().list( options );
            
			List<LinkedHashMap<String, Object>> data = new ArrayList<LinkedHashMap<String, Object>>();

			for( HeartRate heartRate : heartRateList ){

				LinkedHashMap<String, Object> tableRow = new LinkedHashMap<String, Object>();

				for ( DataTableColumn column : dataTableRequest.getColumns() ) {

					String headerName = column.getName();
					String dataName = column.getData();

					switch ( headerName ) {
						case "heartRateId" :
							tableRow.put( dataName, heartRate.getHeartRateId() );
							break;
						case "value" :
							tableRow.put( dataName, heartRate.getValue() );
							break;
						case "measureDate" :
							tableRow.put( dataName, heartRate.getMeasureDate() );
							break;
						case "person" :
							if( heartRate.getPerson() != null ){
								tableRow.put( dataName, heartRate.getPerson().toString() );
							}
							break;
						case "urls" :
							String urls = "";
							if( StringUtils.equals( "list", display ) ){
								urls += "<a href=\"" + contextPath + "/heartrate/show?"+"heartRateId="+heartRate.getHeartRateId()+"\"><span class=\"glyphicon glyphicon-eye-open\"></a>";
								urls += "<a href=\"" + contextPath + "/heartrate/edit?"+"heartRateId="+heartRate.getHeartRateId()+"\"><span class=\"glyphicon glyphicon-pencil\"></a>";
								urls += "<a href=\"" + contextPath + "/heartrate/delete?"+"heartRateId="+heartRate.getHeartRateId()+"\"><span class=\"glyphicon glyphicon-trash\"></a>";
							} else {

							}
							tableRow.put( dataName, urls );
							break;
						default :
							tableRow.put( dataName, "[error: column " + headerName + " not supported]" );
							break;
					}
				}
				data.add( tableRow );
			}

			DataTable dataTable = new DataTable();
			dataTable.setDraw( dataTableRequest.getDraw() );
			dataTable.setRecordsFiltered( count );
			dataTable.setRecordsTotal( count );
			dataTable.setData( data );
			return dataTable;
			
		} catch ( Exception e ) {
			log.error( "error builing datatable json object for HeartRate", e );
			return datatableError( e, dataTableRequest.getDraw() );
		}
		
	}

    @RequestMapping( value = "add", method = RequestMethod.GET )
    public String add( Model model ) {
        model.addAttribute( "heartRate", new HeartRate() );
		model.addAttribute( "personList", weightDaoService.getPersonService().list() );

        return "/weight/heartrate/edit";
    }

    @RequestMapping( value = "edit", method = RequestMethod.GET )
    public String edit( ModelMap model, @RequestParam( value = "heartRateId" ) Integer heartRateId ) {
		model.addAttribute( "personList", weightDaoService.getPersonService().list() );


        model.addAttribute( "heartRate", weightDaoService.getHeartRateService().findById( heartRateId ) );
        return "/weight/heartrate/edit";
    }

    @RequestMapping( value = "show", method = RequestMethod.GET )
    public String show( ModelMap model, @RequestParam( value = "heartRateId" ) Integer heartRateId ) {

        model.addAttribute( "heartRate", weightDaoService.getHeartRateService().findById( heartRateId ) );
        return "/weight/heartrate/show";
    }

    @RequestMapping( value = "save", method = RequestMethod.POST )
    public String save(@Valid @ModelAttribute( "heartRate" ) HeartRate heartRate, BindingResult result, Model model ) {


		if (result.hasErrors()) { 
					model.addAttribute( "personList", weightDaoService.getPersonService().list() );

			return "/weight/heartrate/edit"; 
		} else {
			try {
				weightDaoService.getHeartRateService().saveOrUpdate( heartRate );
			} catch (NonUniqueObjectException e) {
				log.debug("Merging Results");
				weightDaoService.getHeartRateService().merge( heartRate );
			}
		}
		return "redirect:/heartrate/list";
    }

    @RequestMapping( value = "delete", method = RequestMethod.GET )
    public String confirmDelete( ModelMap model, @RequestParam( value = "heartRateId" ) Integer heartRateId ) {

        model.addAttribute( "heartRate", weightDaoService.getHeartRateService().findById( heartRateId ) );
        return "/weight/heartrate/delete";
    }

    @RequestMapping( value = "delete", method = RequestMethod.POST )
    public String doDelete( ModelMap model, @RequestParam( value = "submit" ) String submitButtonValue, @RequestParam( value = "heartRateId" ) Integer heartRateId ) {

        if ( StringUtils.equalsIgnoreCase( submitButtonValue, "yes" ) ) {
            weightDaoService.getHeartRateService().delete( weightDaoService.getHeartRateService().findById( heartRateId ) );
        }
        return "redirect:/heartrate/list";
    }
}