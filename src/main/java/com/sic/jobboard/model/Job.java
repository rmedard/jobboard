package com.sic.jobboard.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Job extends Auditable<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(nullable = false)
	private Employer employer;

	@OneToMany(mappedBy = "job")
	private Set<JobApplication> jobApplications;

	@Temporal(TemporalType.TIMESTAMP)
	private Date expirationDate;

	@Lob
	private String description;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public Set<JobApplication> getJobApplications() {
		return jobApplications;
	}

	public void setJobApplications(Set<JobApplication> jobApplications) {
		this.jobApplications = jobApplications;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
