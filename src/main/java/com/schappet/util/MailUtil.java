package com.schappet.util;

import java.util.regex.Pattern;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author rrlorent
 * @since August 12, 2014
 */
public class MailUtil {
	
	private static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final Pattern EMAIL_PATTERN = Pattern.compile( EMAIL_REGEX );
	
	private static final Log log = LogFactory.getLog( MailUtil.class );

	/**
	 * Validate email using javax.mail.internet.InternetAddress.validate and regular expressions.
	 * Does not guarantee email address actually exists.
	 * @param email
	 * @return boolean
	 */
	public static boolean isValidEmailAddress( String email ) {
		try {
			InternetAddress emailAddr = new InternetAddress( email );
			emailAddr.validate();
		} catch ( AddressException e ) {
			log.debug( "invalid email address [ " + email + " ]", e );
			return false;
		}
		return EMAIL_PATTERN.matcher( email ).matches();
	}
	
}
