package de.probstl.recieptservice.data;

import java.util.Date;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * POJO that represents a shop where a receipt is from.
 * 
 * @author Florian
 */
@Entity
@Table(name = "Shop", indexes = { @Index(unique = true, columnList = "name,street,city"),
		@Index(columnList = "account_id") })
@Access(AccessType.PROPERTY)
public class Shop {

	/** Id of the shop */
	private Long m_Id;

	/** Name of the shop (e.g. Walmart, Killerman, Shell, Rewe, ...) */
	private String m_Name;

	/** Street of the shop */
	private String m_Street;

	/** Postal code of the shop */
	private int m_Plz;

	/** City of the shop */
	private String m_City;

	/** The country code of the shop */
	private String m_CountryCode;

	/** When this shop was created */
	private Date m_Created;

	/** The account this shop belongs */
	private Account m_Account;

	/** The receipts of this shop */
	private List<Receipt> m_Receipts;

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
		Shop other = (Shop) obj;
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
	 * @return the name
	 */
	public String getName() {
		return m_Name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		m_Name = name;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return m_Street;
	}

	/**
	 * @param street
	 *            the street to set
	 */
	public void setStreet(String street) {
		m_Street = street;
	}

	/**
	 * @return the postal code
	 */
	public int getPlz() {
		return m_Plz;
	}

	/**
	 * @param plz
	 *            the postal code to set
	 */
	public void setPlz(int plz) {
		m_Plz = plz;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return m_City;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		m_City = city;
	}

	/**
	 * @return the receipts
	 */
	@OneToMany(mappedBy = "shop")
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
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return m_CountryCode;
	}

	/**
	 * @param countryCode
	 *            the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		m_CountryCode = countryCode;
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
	 * @return the account
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id", nullable = false)
	public Account getAccount() {
		return m_Account;
	}

	/**
	 * @param account
	 *            the account to set
	 */
	public void setAccount(Account account) {
		m_Account = account;
	}
}
