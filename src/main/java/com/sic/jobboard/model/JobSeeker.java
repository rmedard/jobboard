package com.sic.jobboard.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class JobSeeker extends Auditable<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@OneToOne
	private Address address;

	@OneToMany(mappedBy = "jobSeeker")
	private Set<JobApplication> jobApplications;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<JobApplication> getJobApplications() {
		return jobApplications;
	}

	public void setJobApplications(Set<JobApplication> jobApplications) {
		this.jobApplications = jobApplications;
	}
}
