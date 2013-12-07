package me.linh.placeme.user.action;

import java.util.HashMap;
import java.util.Map;

import me.linh.placeme.persistence.model.User;
import me.linh.placeme.persistence.service.UserService;
import me.linh.placeme.util.Helper;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
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
	private String responseJson;

	/**
	 * @return the responseJson
	 */
	public String getResponseJson() {
		return responseJson;
	}

	/**
	 * @param responseJson the responseJson to set
	 */
	public void setResponseJson(String responseJson) {
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
		} 
		
		if(getEmail().length() == 0) {
			addFieldError("email", "Email is required");
		} else if (!helper.checkValidEmail(getEmail())) {
			addFieldError("email", "Not a valid email");
		} else if (userService.emailExist(getEmail())) {
			addFieldError("email", "Email already exists");
		}

		if (getPassword().length() == 0) {
			addFieldError("password", getText("password.required"));
		}
	}

	/**
	 * Handle Register process
	 */
	public String execute() throws Exception {
		// New user object
		User user = new User(this.username, this.email, this.password);
		// Mapping for response object
		Map<String, Object> responseMap = new HashMap<String, Object>();
		
		if (getUsername().length() == 0) {
			addFieldError("username", "User Name is required");
		} 
		
		if(getEmail().length() == 0) {
			addFieldError("email", "Email is required");
		} else if (!helper.checkValidEmail(getEmail())) {
			addFieldError("email", "Not a valid email");
		} else if (userService.emailExist(getEmail())) {
			addFieldError("email", "Email already exists");
		}

		if (getPassword().length() == 0) {
			addFieldError("password", getText("password.required"));
		}
		// Create new user
		try {
			Long userId = userService.createUser(user);
			responseMap.put("status", 1);
			responseMap.put("userId", userId);

			// Change the map to a Json String
			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			this.responseJson = ow.writeValueAsString(responseMap);

		} catch (HibernateException exception) {
			responseMap.put("status", 0);
			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			this.responseJson = ow.writeValueAsString(responseMap);
		} 

		return SUCCESS;
		
	}
}
