package com.kamprzewoj.queststore;

import org.springframework.data.repository.config.CustomRepositoryImplementationDetector;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;


//TODO Spring Data REST
@Component
public class CustomizedRestMvcConfiguration extends RepositoryRestConfigurerAdapter {
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
//		config.setBasePath("/api");
//		config.setRepositoryDetectionStrategy();
//		config
//				.setRepositoryDetectionStrategy(CustomRepositoryImplementationDetector)
//				.setDefaultMediaType(MediaType.APPLICATION_JSON);
	}
}
