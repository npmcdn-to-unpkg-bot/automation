package com.schappet.weight.resource;



import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.ExceptionHandler;

import edu.uiowa.icts.exception.EntityNotFoundException;
import com.schappet.weight.web.AbstractWeightResource;

/**
 * Generated by Protogen 
 * @see <a href="https://github.com/ui-icts/protogen">https://github.com/ui-icts/protogen</a>
 * @since 02/14/2016 12:33:31 CST
 */
public abstract class AbstractWeightApiResource extends AbstractWeightResource {
	private static final Log log = LogFactory.getLog( AbstractWeightApiResource.class );
    
	@ExceptionHandler( value = EntityNotFoundException.class )	
	public ResponseEntity<Map<String, Object>> mappingNotFound( HttpServletRequest request ) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put( "message", request.getRequestURI() + " could not be found." );
		log.error("Error: could not be found: " + request.getRequestURI());

		return new ResponseEntity<Map<String, Object>>( map, HttpStatus.NOT_FOUND );
	}
	
	@ExceptionHandler( value = Exception.class )
	public ResponseEntity<Map<String, Object>> handleException( Exception exception ) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put( "message", exception.getMessage() );
		log.error("Error", exception);
		return new ResponseEntity<Map<String, Object>>( map, HttpStatus.INTERNAL_SERVER_ERROR );
	}

	
}