package com.weasley.demo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@NamedQueries({
		@NamedQuery(name=Customer.FIND_ALL, 
			query="SELECT c from Customer c"),
		@NamedQuery(name=Customer.FIND_BY_LASTNAME, 
			query="SELECT c from Customer c WHERE c.lastName = :lastName"),
		@NamedQuery(name=Customer.FIND_BY_PHONENUMBER, 
			query="SELECT c from Customer c WHERE c.phoneNumber = :phoneNumber")
})
public class Customer implements Serializable {
	public static final String FIND_ALL = "FIND_ALL";
	public static final String FIND_BY_LASTNAME = "FIND_BY_LASTNAME";
	public static final String FIND_BY_PHONENUMBER = "FIND_BY_PHONENUMBER";
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long customerId = -1L;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	
	public Customer() {
	}
	
	public Customer(String firstName, String lastName, String phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}

	public Customer(Long customerId, String firstName, String lastName,
			String phoneNumber) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}

	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result
				+ ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
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
		Customer other = (Customer) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", phoneNumber="
				+ phoneNumber + "]";
	}

	
	
	
}
