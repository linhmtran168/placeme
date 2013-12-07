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
	 * Check regex
	 * @param regexStr
	 * @param str
	 * @return
	 */
	private Boolean checkRegex(String regexStr, String str) {

		Pattern pattern = Pattern.compile(regexStr);
		
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}

	/**
	 * Check if email is valid or not
	 * @param email
	 * @return
	 */
	public Boolean checkValidEmail(String email) {
		final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		return checkRegex(EMAIL_PATTERN, email);
	}
	
	/**
	 * Check if username valid or not
	 * @param username
	 * @return
	 */
	public Boolean checkValidUsername(String username) {
		final String USERNAME_PATTERN = "^[_A-Za-z0-9]{6,}$";
		return checkRegex(USERNAME_PATTERN, username);
	}
}
