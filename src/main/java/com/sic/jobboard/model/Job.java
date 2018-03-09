package com.sic.jobboard.model;

import com.sic.jobboard.util.Coordinate;
import com.sic.jobboard.util.CoordinateConverter;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Audited
@Entity
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(nullable = false)
	private Employer employer;

	@OneToMany(mappedBy = "job")
	@NotAudited
	private Set<JobApplication> jobApplications;

	@Temporal(TemporalType.TIMESTAMP)
	private Date expirationDate;

	@Lob
	private String description;

	@Convert(converter = CoordinateConverter.class)
	private Coordinate creatorLocation;

	private boolean published;

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

	public Coordinate getCreatorLocation() {
		return creatorLocation;
	}

	public void setCreatorLocation(Coordinate creatorLocation) {
		this.creatorLocation = creatorLocation;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}
}
