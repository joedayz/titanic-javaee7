package com.titanic.ventapasajes.util.mail;

import java.io.IOException;
import java.util.Properties;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

//import com.outjected.email.api.SessionConfig;
//import com.outjected.email.impl.SimpleMailConfig;

public class MailConfigProducer {

//	@Produces @ApplicationScoped
//	public SessionConfig getMailConfig() throws IOException{
//		Properties propiedades = new Properties();
//		propiedades.load(getClass().getResourceAsStream("/mail.properties"));
//		
//		SimpleMailConfig config = new SimpleMailConfig();
//		config.setServerHost(propiedades.getProperty("mail.server.host"));
//		config.setServerPort(Integer.parseInt(propiedades.getProperty("mail.server.port")));
//		config.setEnableSsl(Boolean.parseBoolean(propiedades.getProperty("mail.enable.ssl")));
//		config.setAuth(Boolean.parseBoolean(propiedades.getProperty("mail.auth")));
//		config.setUsername(propiedades.getProperty("mail.username"));
//		config.setPassword(propiedades.getProperty("mail.password"));
//		return config;
//	}
	
}
