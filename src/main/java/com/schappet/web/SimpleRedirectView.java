package com.schappet.web;

import org.springframework.web.servlet.view.RedirectView;

/**
 * @author rrlorent
 * @since Jun 6, 2014
 */
public class SimpleRedirectView extends RedirectView {
	
	/**
	 * Extension of {@link RedirectView}  </br>
	 * true - contextRelative whether to interpret the given URL as relative to the current ServletContext </br>
	 * true - http10Compatible whether to stay compatible with HTTP 1.0 clients </br>
	 * false - exposeModelAttributes whether or not model attributes should be exposed as query parameters
	 * @param url
	 */
	public SimpleRedirectView( String url ){
		super( url, true, true, false );
	}
	
}