package me.linh.placeme.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Helper class provide methods ffor validation
 * @author linhtran
 *
 */
public class Helper {

	/**
	 * Check if email is valid or not
	 * @param email
	 * @return
	 */
	public Boolean checkValidEmail(String email) {
		final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
}
