package com.pms.projectcontributor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.pms.*"})
@EnableJpaRepositories(basePackages = {"com.pms.*"})
@SpringBootApplication(scanBasePackages = "com.pms.*")
@ComponentScan(basePackages = {"com.pms.*"})
public class ProjectContributorMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectContributorMicroserviceApplication.class, args);
	}

}
