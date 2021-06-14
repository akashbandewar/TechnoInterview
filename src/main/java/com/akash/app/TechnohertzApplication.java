package com.akash.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.akash.app.repo.MyRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = MyRepository.class)
public class TechnohertzApplication extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {		
		return application.sources(TechnohertzApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(TechnohertzApplication.class, args);
	}

}
