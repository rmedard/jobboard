package com.sic.jobboard.model;

import com.sic.jobboard.model.type.CountryType;

import javax.persistence.*;

@Entity
public class Address extends Auditable<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, name = "country")
	private CountryType country;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public CountryType getCountry() {
		return country;
	}

	public void setCountry(CountryType country) {
		this.country = country;
	}
}
