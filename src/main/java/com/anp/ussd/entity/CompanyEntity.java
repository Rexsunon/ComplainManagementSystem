package com.anp.ussd.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="Company")
@EntityListeners(AuditingEntityListener.class)
public class CompanyEntity {

	@Id()
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="company_name")
	private String name;

	@Column(name="phone_number")
	private String phoneNumber;

	@Column(name="address")
	private String address;

	@Column(name="complains")
	private List<String> companyComplains;


	public CompanyEntity() {
		
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<String> getCompanyComplains() {
		return companyComplains;
	}

	public void setCompanyComplains(List<String> companyComplains) {
		this.companyComplains = companyComplains;
	}

	public static class Builder {
		private long id;
		private String name;
		private String phoneNumber;
		private String address;
		private List<String> complains;

		public Builder id(long id) {
			this.id = id;
			return this;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder phoneNumber(String phone) {
			this.phoneNumber = phone;
			return this;
		}

		public Builder address(String address) {
			this.address = address;
			return this;
		}

		public Builder complains(List<String> complains) {
			this.complains = complains;
			return this;
		}

		public CompanyEntity build() {
			CompanyEntity comp = new CompanyEntity();
			comp.id = id;
			comp.name = name;
			comp.phoneNumber = phoneNumber;
			comp.address = address;
			comp.companyComplains = complains;
			return comp;
		}
	}
}
