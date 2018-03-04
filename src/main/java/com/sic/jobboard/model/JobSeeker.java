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
}
