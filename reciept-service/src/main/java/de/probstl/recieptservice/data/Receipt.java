package de.probstl.recieptservice.data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The receipt of a fuel action
 * 
 * @author Florian
 */
@Entity
@Table(name = "Receipt", indexes = { @Index(columnList = "account_id"), @Index(columnList = "shop_id"),
		@Index(columnList = "budget_id") })
@Access(AccessType.PROPERTY)
public class Receipt {

	/** The unique Id of this receipt */
	private Long m_Id;

	/** A annotation describing the receipt (what was bought) */
	private String m_Annotation;

	/** The amount of the receipt */
	private BigDecimal m_Amount;

	/** A quantity how much was bought (eg. fuel, apples etc.) */
	private BigDecimal m_Quantity;

	/** The quantity unit (eg. Gramm, Kilo, Liter etc.) */
	private QuantityUnit m_QuantityUnit;

	/** Timestamp when the receipt was created */
	private Date m_Created;

	/** Timestamp of the receipt */
	private Date m_ReceiptDate;

	/** Was this receipt paid with cash of credit card */
	private boolean m_CashYn;

	/** If <code>true</code> the amount of this receipt is not shown */
	private boolean m_PrivateYn;

	/** The user who got the receipt */
	private Account m_Account;

	/** The shop where the receipt is from */
	private Shop m_Shop;

	/** The tags of this receipt */
	private Set<Tag> m_Tags;

	/** The Budget where this receipt is associated */
	private Budget m_Budget;

	/** The attachments of this receipt */
	private List<Attachment> m_Attachments;

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
		Receipt other = (Receipt) obj;
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
	 * @return the user
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id", nullable = false)
	public Account getAccount() {
		return m_Account;
	}

	/**
	 * @param account
	 *            the user to set
	 */
	public void setAccount(Account account) {
		m_Account = account;
	}

	/**
	 * @return the shop
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "shop_id")
	public Shop getShop() {
		return m_Shop;
	}

	/**
	 * @param shop
	 *            the shop to set
	 */
	public void setShop(Shop shop) {
		m_Shop = shop;
	}

	/**
	 * @return the amount
	 */
	@Column(nullable = false)
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
	 * @return the receiptDate
	 */
	@Column(nullable = false)
	public Date getReceiptDate() {
		return m_ReceiptDate;
	}

	/**
	 * @param receiptDate
	 *            the receiptDate to set
	 */
	public void setReceiptDate(Date receiptDate) {
		m_ReceiptDate = receiptDate;
	}

	/**
	 * @return the tags
	 */
	@ManyToMany
	@JoinTable(name = "Receipt_Tags", joinColumns = {
			@JoinColumn(name = "receipt_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "tag_id", referencedColumnName = "id") }, indexes = {
							@Index(columnList = "tag_id,receipt_id") })
	public Set<Tag> getTags() {
		return m_Tags;
	}

	/**
	 * @param tags
	 *            the tags to set
	 */
	public void setTags(Set<Tag> tags) {
		m_Tags = tags;
	}

	/**
	 * @return the cashYn
	 */
	@Column(columnDefinition = "boolean default true")
	public boolean isCashYn() {
		return m_CashYn;
	}

	/**
	 * @param cashYn
	 *            the cashYn to set
	 */
	public void setCashYn(boolean cashYn) {
		m_CashYn = cashYn;
	}

	/**
	 * @return the privateYn
	 */
	@Column(columnDefinition = "boolean default false")
	public boolean isPrivateYn() {
		return m_PrivateYn;
	}

	/**
	 * @param privateYn
	 *            the privateYn to set
	 */
	public void setPrivateYn(boolean privateYn) {
		m_PrivateYn = privateYn;
	}

	/**
	 * @return the budget
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "budget_id")
	public Budget getBudget() {
		return m_Budget;
	}

	/**
	 * @param budget
	 *            the budget to set
	 */
	public void setBudget(Budget budget) {
		m_Budget = budget;
	}

	/**
	 * @return the annotation
	 */
	public String getAnnotation() {
		return m_Annotation;
	}

	/**
	 * @param annotation
	 *            the annotation to set
	 */
	public void setAnnotation(String annotation) {
		m_Annotation = annotation;
	}

	/**
	 * @return the quantity
	 */
	public BigDecimal getQuantity() {
		return m_Quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(BigDecimal quantity) {
		m_Quantity = quantity;
	}

	/**
	 * @return the quantityUnit
	 */
	@Enumerated(EnumType.STRING)
	public QuantityUnit getQuantityUnit() {
		return m_QuantityUnit;
	}

	/**
	 * @param quantityUnit
	 *            the quantityUnit to set
	 */
	public void setQuantityUnit(QuantityUnit quantityUnit) {
		m_QuantityUnit = quantityUnit;
	}

	/**
	 * @return the attachments
	 */
	@OneToMany(mappedBy = "receipt", cascade=CascadeType.REMOVE)
	public List<Attachment> getAttachments() {
		return m_Attachments;
	}

	/**
	 * @param attachments
	 *            the attachments to set
	 */
	public void setAttachments(List<Attachment> attachments) {
		m_Attachments = attachments;
	}
}
