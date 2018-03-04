package com.sic.jobboard.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role extends Auditable<String> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
	private Set<User> users;
}
