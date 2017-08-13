package de.probstl.recieptservice.data;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

public class Registration {

	/** First name of the user that wants to register */
	private String m_Firstname;
	
	/** Last name of the user that wants to register */
	private String m_Lastname;
	
	/** The E-Mail address of the user */
	private String m_Email;
	
	/** A custom password protecting the user */
	private String m_Password;

	/**
	 * @return the first name
	 */
	public String getFirstname() {
		return m_Firstname;
	}

	/**
	 * @param firstname the first name to set
	 */
	public void setFirstname(String firstname) {
		m_Firstname = firstname;
	}

	/**
	 * @return the last name
	 */
	public String getLastname() {
		return m_Lastname;
	}

	/**
	 * @param lastname the last name to set
	 */
	public void setLastname(String lastname) {
		m_Lastname = lastname;
	}

	/**
	 * @return the email
	 */
	@Email
	@NotNull
	public String getEmail() {
		return m_Email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		m_Email = email;
	}

	/**
	 * @return the password
	 */
	@NotNull
	public String getPassword() {
		return m_Password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		m_Password = password;
	}
}
