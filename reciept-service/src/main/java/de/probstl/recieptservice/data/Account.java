package de.probstl.recieptservice.data;

import java.util.Date;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * User account of the fuel service
 * 
 * @author Florian
 */
@Entity
@Table(name = "Account", indexes = { @Index(unique = true, columnList = "email") })
@Access(AccessType.PROPERTY)
public class Account {

	/** The unique Id of the user */
	private Long m_Id;

	/** The users first name */
	private String m_Firstname;

	/** The users last name */
	private String m_Lastname;

	/** The users email address */
	private String m_Email;

	/** The users password for login */
	private String m_Password;

	/** The last time when password was changed */
	private Date m_PasswordChanged;

	/** The date when the user was created */
	private Date m_Created;

	/** The last login of the user */
	private Date m_LastLogin;

	/** The receipts done of this user */
	private List<Receipt> m_Receipts;

	/** The budgets where this is account is mapped */
	private List<Budget> m_Budgets;

	/** The shops of this account */
	private List<Shop> m_Shops;

	/** The tags of this account */
	private List<Tag> m_Tags;

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((m_Id == null) ? 0 : m_Id.hashCode());
		return result;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (m_Id == null) {
			if (other.m_Id != null)
				return false;
		} else if (!m_Id.equals(other.m_Id))
			return false;
		return true;
	}

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return m_Id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		m_Id = id;
	}

	/**
	 * @return the first name
	 */
	public String getFirstname() {
		return m_Firstname;
	}

	/**
	 * @param firstname
	 *            the first name to set
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
	 * @param lastname
	 */
	public void setLastname(String lastname) {
		m_Lastname = lastname;
	}

	/**
	 * @return the email
	 */
	@Column(nullable = false, updatable = false)
	public String getEmail() {
		return m_Email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		m_Email = email;
	}

	/**
	 * @return the password
	 */
//	@Column(columnDefinition = "varchar(255) default gen_salt('bf', 8)", insertable = false, updatable = false)
	@Column(columnDefinition = "varchar(255)")
	public String getPassword() {
		return m_Password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		m_Password = password;
	}

	/**
	 * @return the created
	 */
	@Column(name = "created", columnDefinition = "timestamp default current_timestamp", insertable = false, updatable = false)
	public Date getCreated() {
		return m_Created;
	}

	/**
	 * @param created
	 *            the created to set
	 */
	public void setCreated(Date created) {
		m_Created = created;
	}

	/**
	 * @return the lastLogin
	 */
	@Column(insertable = false, updatable = false)
	public Date getLastLogin() {
		return m_LastLogin;
	}

	/**
	 * @param lastLogin
	 *            the lastLogin to set
	 */
	public void setLastLogin(Date lastLogin) {
		m_LastLogin = lastLogin;
	}

	/**
	 * @return the receipts
	 */
	@OneToMany(mappedBy = "account")
	public List<Receipt> getReceipts() {
		return m_Receipts;
	}

	/**
	 * @param receipts
	 *            the receipts to set
	 */
	public void setReceipts(List<Receipt> receipts) {
		m_Receipts = receipts;
	}

	/**
	 * @return the budgets
	 */
	@ManyToMany(mappedBy = "accounts")
	public List<Budget> getBudgets() {
		return m_Budgets;
	}

	/**
	 * @param budgets
	 *            the budgets to set
	 */
	public void setBudgets(List<Budget> budgets) {
		m_Budgets = budgets;
	}

	/**
	 * @return the shops
	 */
	@OneToMany(mappedBy = "account")
	public List<Shop> getShops() {
		return m_Shops;
	}

	/**
	 * @param shops
	 *            the shops to set
	 */
	public void setShops(List<Shop> shops) {
		m_Shops = shops;
	}

	/**
	 * @return the tags
	 */
	@OneToMany(mappedBy = "account")
	public List<Tag> getTags() {
		return m_Tags;
	}

	/**
	 * @param tags
	 *            the tags to set
	 */
	public void setTags(List<Tag> tags) {
		m_Tags = tags;
	}

	/**
	 * @return the passwordChanged
	 */
	@Column(insertable = false, updatable = false)
	public Date getPasswordChanged() {
		return m_PasswordChanged;
	}

	/**
	 * @param passwordChanged
	 *            the passwordChanged to set
	 */
	public void setPasswordChanged(Date passwordChanged) {
		m_PasswordChanged = passwordChanged;
	}
}
