package com.schappet.weight.web;



import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.schappet.weight.dao.WeightDaoService;
import edu.uiowa.icts.spring.Security;

/**
 * Generated by Protogen
 * @see <a href="https://github.com/ui-icts/protogen">https://github.com/ui-icts/protogen</a>
 * @since 02/14/2016 12:33:31 CST
 */
public abstract class AbstractWeightResource {

	@Autowired
	protected WeightDaoService weightDaoService;

	@ModelAttribute( value = "username" )
	public String getUsername() {
		if ( Security.isAuthenticated() ) {
			return SecurityContextHolder.getContext().getAuthentication().getName();
		}
		return null;
	}

}