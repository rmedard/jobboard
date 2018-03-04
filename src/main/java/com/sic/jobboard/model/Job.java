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
}
