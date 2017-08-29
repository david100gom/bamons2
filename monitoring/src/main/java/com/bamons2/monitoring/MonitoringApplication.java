package com.bamons2.monitoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Created by david100gom on 2017. 8. 13.
 *
 * Github : https://github.com/david100gom
 */
@EnableResourceServer
@EnableAuthorizationServer
@SpringBootApplication
@EnableAspectJAutoProxy
@EnableCaching
@EnableAsync
public class MonitoringApplication extends SpringBootServletInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
		System.out.println("### Init Web Server Start ###");
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MonitoringApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(MonitoringApplication.class, args);
		System.out.println("### Init Embedded Server Start ###");
	}

}