package com.sic.jobboard.model.type;

public enum CountryType {
	BELGIUM("Belgium", "BE"), FRANCE("France", "FR"), USA("United States of America", "US");

	private String fullName;
	private String abbreviation;

	CountryType(String fullName, String abbreviation) {
		this.fullName = fullName;
		this.abbreviation = abbreviation;
	}

	public String getFullName() {
		return fullName;
	}

	public String getAbbreviation() {
		return abbreviation;
	}
}
