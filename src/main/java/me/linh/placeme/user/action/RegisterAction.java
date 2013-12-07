package me.linh.placeme.user.action;

import java.util.HashMap;
import java.util.Map;

import me.linh.placeme.persistence.model.User;
import me.linh.placeme.persistence.service.UserService;
import me.linh.placeme.util.Helper;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Action to handle display register form and process register
 * @author linhtran
 *
 */

public class RegisterAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1868857825210676332L;
	private String username;
	private String password;
	private String email;

	@Autowired
	private UserService userService;
	@Autowired
	private Helper helper;
	
	/**
	 * Response for Ajax Request;
	 */
	private Map<String, Object> responseJson = new HashMap<String, Object>();

	/**
	 * @return the responseJson
	 */
	public Map<String, Object> getResponseJson() {
		return responseJson;
	}

	/**
	 * @param responseJson the responseJson to set
	 */
	public void setResponseJson(Map<String, Object> responseJson) {
		this.responseJson = responseJson;
	}

	

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Validation
	 */
	public void validate() {
		if (getUsername().length() == 0) {
			addFieldError("username", "User Name is required");
		} else if (!helper.checkValidUsername(getUsername())) {
			addFieldError("username", "User Name is not valid");
		} else if (userService.userExist(getUsername())) {
			addFieldError("username", "User Name existed");
		}
		
		
		if(getEmail().length() == 0) {
			addFieldError("email", "Email is required");
		} else if (!helper.checkValidEmail(getEmail())) {
			addFieldError("email", "Not a valid email");
		} else if (userService.emailExist(getEmail())) {
			addFieldError("email", "Email already exists");
		}

		if (getPassword().length() == 0 || getPassword().length() < 6) {
			addFieldError("password", getText("Password is required"));
		}
	}

	/**
	 * Handle Register process
	 */
	public String execute() throws Exception {
		// New user object
		User user = new User(this.username, this.email, this.password);
		// Mapping for response object
		
		// Create new user
		try {
			Long userId = userService.createUser(user);
			responseJson.put("status", 1);
			responseJson.put("userId", userId);

		} catch (HibernateException exception) {
			responseJson.put("status", 0);
		} 

		return SUCCESS;
		
	}
}
