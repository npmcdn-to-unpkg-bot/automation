package com.schappet.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.schappet.weight.domain.EmailAddress;

public class PasswordTools {

	private static final Log log =LogFactory.getLog(PasswordTools.class);
	public String hashPassword(String plainText)
	{
		MessageDigest mdAlgorithm ;
		try {
			mdAlgorithm = MessageDigest.getInstance("MD5");
			mdAlgorithm.update(plainText.getBytes());

			byte[] digest = mdAlgorithm.digest();
			StringBuffer hexString = new StringBuffer();

			for (int i = 0; i < digest.length; i++) {
			    plainText = Integer.toHexString(0xFF & digest[i]);

			    if (plainText.length() < 2) {
			        plainText = "0" + plainText;
			    }

			    hexString.append(plainText);
			}

			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		

	}
	
	public boolean changePassword(
			String current_password,
			String password1,
			String password2,
			EmailAddress person,
			int length
			) 
	{
		if(!validPassword(password1,password2,length) )
			return false;
			
		
		if(!person.getPassword().equals(hashPassword(current_password)))
			return false;
		

		person.setPassword(hashPassword(password1));
		
		
		return true;
		
	}
	public boolean validPassword(
			String password1,
			String password2,
			int length
			) 
	{
		if(password1.equals(password2)==false || password1.length()<length )
			return false;
			
		
		return true;
		
	}
}