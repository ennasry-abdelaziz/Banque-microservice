package com.rma.banque;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

import com.rma.banque.web.CompteRestJaxRSAPI;

@Configuration
public class MyConfig {

//	@Bean
	public ResourceConfig resourceConfig() {
		ResourceConfig jerseyServlet= new ResourceConfig();
		jerseyServlet.register(CompteRestJaxRSAPI.class);
		return jerseyServlet;
	}
	
//	@Bean
	public SimpleJaxWsServiceExporter serviceExporter() {
		SimpleJaxWsServiceExporter serviceExporter= new SimpleJaxWsServiceExporter();
		serviceExporter.setBaseAddress("http://0.0.0.0:8880/");
		return serviceExporter;
	}
	public MyConfig() {
		// TODO Auto-generated constructor stub
	}

}
