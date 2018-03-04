package com.sic.jobboard.model;

import javax.persistence.*;

@Entity
public class JobApplication extends Auditable<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne(cascade = CascadeType.ALL)
	private Job job;

	@ManyToOne(cascade = CascadeType.ALL)
	private JobSeeker jobSeeker;
}
