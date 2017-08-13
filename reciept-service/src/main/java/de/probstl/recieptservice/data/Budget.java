package de.probstl.recieptservice.data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Budget")
@Access(AccessType.PROPERTY)
public class Budget {

	/** Id of the tag */
	private Long m_Id;

	/** Name of the tag */
	private String m_Name;

	/** The interval begin of this budget */
	private Date m_ValidFrom;

	/** The interval end of this budget */
	private Date m_ValidTo;

	/** The amount of this budget */
	private BigDecimal m_Amount;

	/** The date when this Budget was created */
	private Date m_Created;

	/** The accounts that are associated with this budget */
	private List<Account> m_Accounts;

	/** The receipts of this budget */
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
		Budget other = (Budget) obj;
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
	 * @return the validFrom
	 */
	public Date getValidFrom() {
		return m_ValidFrom;
	}

	/**
	 * @param validFrom
	 *            the validFrom to set
	 */
	public void setValidFrom(Date validFrom) {
		m_ValidFrom = validFrom;
	}

	/**
	 * @return the validTo
	 */
	public Date getValidTo() {
		return m_ValidTo;
	}

	/**
	 * @param validTo
	 *            the validTo to set
	 */
	public void setValidTo(Date validTo) {
		m_ValidTo = validTo;
	}

	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return m_Amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		m_Amount = amount;
	}

	/**
	 * @return the accounts
	 */
	@ManyToMany
	@JoinTable(name = "Budget_Accounts", joinColumns = {
			@JoinColumn(name = "budget_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "account_id", referencedColumnName = "id") })
	public List<Account> getAccounts() {
		return m_Accounts;
	}

	/**
	 * @param accounts
	 *            the accounts to set
	 */
	public void setAccounts(List<Account> accounts) {
		m_Accounts = accounts;
	}

	/**
	 * @return the receipts
	 */
	@OneToMany(mappedBy = "budget")
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
