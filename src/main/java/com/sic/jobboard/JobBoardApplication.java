package com.sic.jobboard;

import com.sic.jobboard.model.Role;
import com.sic.jobboard.repository.RolesRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JobBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobBoardApplication.class, args);
	}

	@Autowired
	private RolesRepository rolesRepository;

	@Bean
	InitializingBean createInitData(){
		Role adminRole = new Role();
		adminRole.setName("ADMIN");
		Role userRole = new Role();
		userRole.setName("USER");
		return () -> {
			rolesRepository.save(adminRole);
			rolesRepository.save(userRole);
		};
	}
}
