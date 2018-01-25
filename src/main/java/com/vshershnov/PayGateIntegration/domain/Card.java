package com.vshershnov.PayGateIntegration.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Card {
		
	private String cradNumber;
	private String expDate;
	private String cscCode;
	/**
	 * @return the expDate
	 */
	@NotNull(message="{field.empty}")
	@Size(min=4, max=10, message="{card.expDate.size, should be min=5 max=10}")
	public String getExpDate() {
		return expDate;
	}
	/**
	 * @param expDate the expDate to set
	 */
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	/**
	 * @return the cradNumber
	 */
	@NotNull(message="{field.empty}")
	@Size(min=16, max=20, message="{card.number.size, should be min=16 max=20}")
	public String getCradNumber() {
		return cradNumber;
	}
	/**
	 * @param cradNumber the cradNumber to set
	 */
	public void setCradNumber(String cradNumber) {
		this.cradNumber = cradNumber;
	}
	/**
	 * @return the cscCode
	 */
	@NotNull(message="{field.empty}")
	@Size(min=3, max=4, message="{card.cscCode.size, should be min=3 max=4}")
	public String getCscCode() {
		return cscCode;
	}
	/**
	 * @param cscCode the cscCode to set
	 */
	public void setCscCode(String cscCode) {
		this.cscCode = cscCode;
	}	
	
	@Override
	public String toString() {
		return "Card [cradNumber=" + cradNumber + ", expDate=" + expDate
				+ ", cscCode=" + cscCode + "]";
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cradNumber == null) ? 0 : cradNumber.hashCode());
		result = prime * result + ((cscCode == null) ? 0 : cscCode.hashCode());
		result = prime * result + ((expDate == null) ? 0 : expDate.hashCode());
		return result;
	}
	/* (non-Javadoc)
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
		Card other = (Card) obj;
		if (cradNumber == null) {
			if (other.cradNumber != null)
				return false;
		} else if (!cradNumber.equals(other.cradNumber))
			return false;
		if (cscCode == null) {
			if (other.cscCode != null)
				return false;
		} else if (!cscCode.equals(other.cscCode))
			return false;
		if (expDate == null) {
			if (other.expDate != null)
				return false;
		} else if (!expDate.equals(other.expDate))
			return false;
		return true;
	}	
}
