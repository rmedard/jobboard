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


}
