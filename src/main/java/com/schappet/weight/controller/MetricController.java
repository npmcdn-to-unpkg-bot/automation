package com.schappet.weight.controller;



import java.util.ArrayList;
import java.util.Date;
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

import com.schappet.weight.domain.Metric;

import edu.uiowa.icts.datatable.DataTable;
import edu.uiowa.icts.datatable.DataTableColumn;
import edu.uiowa.icts.datatable.DataTableRequest;
import edu.uiowa.icts.spring.GenericDaoListOptions;

/**
 * Generated by Protogen 
 * @see <a href="https://github.com/ui-icts/protogen">https://github.com/ui-icts/protogen</a>
 * @since 02/14/2016 12:33:31 CST
 */
@Controller( value = "com_schappet_weight_controller_metric_controller" )
@RequestMapping( "/metric" )
public class MetricController extends AbstractWeightController {

    private static final Log log = LogFactory.getLog( MetricController.class );

    @RequestMapping( value = "list_alt", method = RequestMethod.GET )
    public String listNoScript(Model model) {
        model.addAttribute( "metricList", weightDaoService.getMetricService().list() );
        return "/weight/metric/list_alt";
    }

    @RequestMapping( value = { "list", "", "/" }, method = RequestMethod.GET )
    public String list(Model model) {
    	// needed for AngularJS grid/CRUD functionality
    	 
        return "/weight/metric/list";
    }


	@ResponseBody
	@RequestMapping( value = "datatable" , produces = "application/json" )
	public DataTable datatable( @RequestBody DataTableRequest dataTableRequest, HttpServletRequest request,
		@RequestParam( value = "display" , required = false , defaultValue = "list" ) String display ) {
		
		String contextPath = request.getContextPath();
		GenericDaoListOptions options = dataTableRequest.getGenericDaoListOptions();

		try {

			Integer count = weightDaoService.getMetricService().count( options );
            List<Metric> metricList = weightDaoService.getMetricService().list( options );
            
			List<LinkedHashMap<String, Object>> data = new ArrayList<LinkedHashMap<String, Object>>();

			for( Metric metric : metricList ){

				LinkedHashMap<String, Object> tableRow = new LinkedHashMap<String, Object>();

				for ( DataTableColumn column : dataTableRequest.getColumns() ) {

					String headerName = column.getName();
					String dataName = column.getData();

					switch ( headerName ) {
						case "metricId" :
							tableRow.put( dataName, metric.getMetricId() );
							break;
						case "name" :
							tableRow.put( dataName, metric.getName() );
							break;
						case "textValue" :
							tableRow.put( dataName, metric.getTextValue() );
							break;
						case "numericValue" :
							tableRow.put( dataName, metric.getNumericValue() );
							break;
						case "dateAdded" :
							tableRow.put( dataName, metric.getDateAdded() );
							break;
						case "source" :
							tableRow.put( dataName, metric.getSource() );
							break;
						case "urls" :
							String urls = "";
							if( StringUtils.equals( "list", display ) ){
								urls += "<a href=\"" + contextPath + "/metric/show?"+"metricId="+metric.getMetricId()+"\"><span class=\"glyphicon glyphicon-eye-open\"></a>";
								urls += "<a href=\"" + contextPath + "/metric/edit?"+"metricId="+metric.getMetricId()+"\"><span class=\"glyphicon glyphicon-pencil\"></a>";
								urls += "<a href=\"" + contextPath + "/metric/delete?"+"metricId="+metric.getMetricId()+"\"><span class=\"glyphicon glyphicon-trash\"></a>";
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
			log.error( "error builing datatable json object for Metric", e );
			return datatableError( e, dataTableRequest.getDraw() );
		}
		
	}

	@ResponseBody
    @RequestMapping( value = "homeip", method = RequestMethod.GET )
    public String add( HttpServletRequest request ) {
    	Metric metric = new Metric();
    	metric.setDateAdded( new Date());
    	metric.setName("HOME_IP");
    	
    	String ipAddress = request.getHeader("X-FORWARDED-FOR");  
    	if (ipAddress == null) {  
    	   ipAddress = request.getRemoteAddr();  
    	}
    	metric.setTextValue(ipAddress);
    	weightDaoService.getMetricService().saveOrUpdate( metric );
        return "SAVED";
    }


    
    @RequestMapping( value = "add", method = RequestMethod.GET )
    public String latestHomeIp( Model model ) {
        model.addAttribute( "metric", new Metric() );

        return "/weight/metric/edit";
    }

    
    @RequestMapping( value = "edit", method = RequestMethod.GET )
    public String edit( ModelMap model, @RequestParam( value = "metricId" ) Integer metricId ) {


        model.addAttribute( "metric", weightDaoService.getMetricService().findById( metricId ) );
        return "/weight/metric/edit";
    }

    @RequestMapping( value = "show", method = RequestMethod.GET )
    public String show( ModelMap model, @RequestParam( value = "metricId" ) Integer metricId ) {

        model.addAttribute( "metric", weightDaoService.getMetricService().findById( metricId ) );
        return "/weight/metric/show";
    }

    @RequestMapping( value = "save", method = RequestMethod.POST )
    public String save(@Valid @ModelAttribute( "metric" ) Metric metric, BindingResult result, Model model ) {


		if (result.hasErrors()) { 
			
			return "/weight/metric/edit"; 
		} else {
			try {
				weightDaoService.getMetricService().saveOrUpdate( metric );
			} catch (NonUniqueObjectException e) {
				log.debug("Merging Results");
				weightDaoService.getMetricService().merge( metric );
			}
		}
		return "redirect:/metric/list";
    }

    @RequestMapping( value = "delete", method = RequestMethod.GET )
    public String confirmDelete( ModelMap model, @RequestParam( value = "metricId" ) Integer metricId ) {

        model.addAttribute( "metric", weightDaoService.getMetricService().findById( metricId ) );
        return "/weight/metric/delete";
    }

    @RequestMapping( value = "delete", method = RequestMethod.POST )
    public String doDelete( ModelMap model, @RequestParam( value = "submit" ) String submitButtonValue, @RequestParam( value = "metricId" ) Integer metricId ) {

        if ( StringUtils.equalsIgnoreCase( submitButtonValue, "yes" ) ) {
            weightDaoService.getMetricService().delete( weightDaoService.getMetricService().findById( metricId ) );
        }
        return "redirect:/metric/list";
    }
}