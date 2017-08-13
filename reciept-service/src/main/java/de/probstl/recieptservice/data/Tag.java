package de.probstl.recieptservice.data;

import java.util.Date;
import java.util.List;
import java.util.Set;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * A tag describes a possible tag of a receipt
 * 
 * @author Florian
 */
@Entity
@Table(name = "Tag", indexes = { @Index(unique = true, columnList = "name,account_id") })
@Access(AccessType.PROPERTY)
public class Tag {

	/** Id of the tag */
	private Long m_Id;

	/** Name of the tag */
	private String m_Name;

	/** When this tag was created */
	private Date m_Created;

	/** The Account where the tag belongs to */
	private Account m_Account;

	/** The receipts assigned to this tag */
	private Set<Receipt> m_Receipts;

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
		Tag other = (Tag) obj;
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
	@Column(nullable = false)
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

	/**
	 * @return the receipts
	 */
	@ManyToMany(mappedBy = "tags")
	public Set<Receipt> getReceipts() {
		return m_Receipts;
	}

	/**
	 * @param receipts
	 *            the receipts to set
	 */
	public void setReceipts(Set<Receipt> receipts) {
		m_Receipts = receipts;
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
}
