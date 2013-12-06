package me.linh.placeme.user.action;

import java.util.HashMap;
import java.util.Map;

import me.linh.placeme.persistence.dao.UserDao;
import me.linh.placeme.persistence.model.User;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.hibernate.HibernateException;

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
	 * Main
	 */
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	/**
	 * Handle Register process
	 */
	public String postRegister() throws Exception {
		UserDao userDao = new UserDao();
		// New user object
		User user = new User(this.username, this.email, this.password);
		// Mapping for response object
		Map<String, Object> responseMap = new HashMap<String, Object>();
		
		// Create new user
		try {
			userDao.create(user);
			responseMap.put("status", 1);
			responseMap.put("user", user);

			// Change the map to a Json String
			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			this.responseJson = ow.writeValueAsString(responseMap);

		} catch (HibernateException exception) {
			responseMap.put("status", 0);
			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			this.responseJson = ow.writeValueAsString(responseMap);

			return ERROR;
		}
		
		return SUCCESS;
	}

}
