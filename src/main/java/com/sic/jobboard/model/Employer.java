package com.sic.jobboard.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Employer extends Auditable<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@OneToMany(mappedBy = "employer")
	private Set<Job> jobs;

	@OneToOne
	private Address address;

	private String primaryEmail;

	private String primaryPhoneNumber;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<Job> getJobs() {
		return jobs;
	}

	public void setJobs(Set<Job> jobs) {
		this.jobs = jobs;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPrimaryEmail() {
		return primaryEmail;
	}

	public void setPrimaryEmail(String primaryEmail) {
		this.primaryEmail = primaryEmail;
	}

	public String getPrimaryPhoneNumber() {
		return primaryPhoneNumber;
	}

	public void setPrimaryPhoneNumber(String primaryPhoneNumber) {
		this.primaryPhoneNumber = primaryPhoneNumber;
	}
}
