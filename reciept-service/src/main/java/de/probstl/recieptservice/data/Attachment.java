package de.probstl.recieptservice.data;

import java.util.Date;

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
import javax.persistence.Table;

/**
 * An attachment of a receipt
 * 
 * @author Florian
 */
@Entity
@Table(name = "Attachment", indexes = { @Index(unique = true, columnList = "receipt_id, name") })
@Access(AccessType.PROPERTY)
public class Attachment {

	/** The id of this attachment */
	private Long m_Id;

	/** The name of this attachment */
	private String m_Name;

	/** The MIME type (e.g. jpg, png, pdf) of this attachment */
	private String m_Mimetype;

	/** The data of this attachment */
	private byte[] m_BinaryData;

	/** The date when this attachment was created */
	private Date m_Created;

	/** The receipt which this attachment belongs to */
	private Receipt m_Receipt;

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
		Attachment other = (Attachment) obj;
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
	 * @return the mimetype
	 */
	@Column(nullable = false)
	public String getMimetype() {
		return m_Mimetype;
	}

	/**
	 * @param mimetype
	 *            the mimetype to set
	 */
	public void setMimetype(String mimetype) {
		m_Mimetype = mimetype;
	}

	/**
	 * @return the binaryData
	 */
	@Column(nullable = false)
	public byte[] getBinaryData() {
		return m_BinaryData;
	}

	/**
	 * @param binaryData
	 *            the binaryData to set
	 */
	public void setBinaryData(byte[] binaryData) {
		m_BinaryData = binaryData;
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
	 * @return the receipt
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "receipt_id", nullable = false)
	public Receipt getReceipt() {
		return m_Receipt;
	}

	/**
	 * @param receipt
	 *            the receipt to set
	 */
	public void setReceipt(Receipt receipt) {
		m_Receipt = receipt;
	}
}
