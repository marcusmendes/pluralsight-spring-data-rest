package com.pluralsight.springdatarest.configuration;

import com.pluralsight.springdatarest.model.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

//@Configuration
public class DataRestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.getExposureConfiguration()
                .forDomainType(User.class)
                .withItemExposure((metadata, httpMethods) -> httpMethods.disable(HttpMethod.POST, HttpMethod.DELETE))
                .withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(HttpMethod.POST, HttpMethod.DELETE));
    }
}
