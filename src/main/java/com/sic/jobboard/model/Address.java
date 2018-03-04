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
}
