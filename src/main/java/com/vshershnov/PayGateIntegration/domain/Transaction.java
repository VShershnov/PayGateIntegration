package com.vshershnov.PayGateIntegration.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Transaction {

	private Card card;
	
	private Integer amount;
	
	private String holderName;	
	private String street;
	private String city;
	private String state;
	private String zipCode;
	
	public Transaction() {
		card = new Card();
	}

	
	public Card getCard() {
		return card;
	}
	
	public void setCard(Card card) {
		this.card = card;
	}
	
	@NotNull(message="{field.empty, type amount in cents}")
	public Integer getAmount() {
		return amount;
	}
	
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	@NotNull(message="{field.empty}")
	@Size(max=150, message="{holderName.size, should be max=150}")
	public String getHolderName() {
		return holderName;
	}
	
	public void setHolderName(String holdername) {
		this.holderName = holdername;
	}
	
	@NotNull(message="{field.empty}")
	@Size(max=128, message="{street.size, should be max=128}")
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	@NotNull(message="{field.empty}")
	@Size(max=50, message="{city.size, should be max=50}")
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	@NotNull(message="{field.empty}")
	@Size(max=2, message="{state.size, should be max=2}")
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	@NotNull(message="{field.empty}")
	@Size(max=15, message="{zipCode.size, should be max=15}")
	public String getZipCode() {
		return zipCode;
	}
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}	
	
	@Override
	public String toString() {
		return "Transaction [card=" + card + ", amount=" + amount
				+ ", holderName=" + holderName + ", street=" + street
				+ ", city=" + city + ", state=" + state + ", zipCode="
				+ zipCode + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
		result = prime * result + ((card == null) ? 0 : card.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result
				+ ((holderName == null) ? 0 : holderName.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (zipCode == null) {
			if (other.zipCode != null)
				return false;
		} else if (!zipCode.equals(other.zipCode))
			return false;
		if (card == null) {
			if (other.card != null)
				return false;
		} else if (!card.equals(other.card))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (holderName == null) {
			if (other.holderName != null)
				return false;
		} else if (!holderName.equals(other.holderName))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}	
}
