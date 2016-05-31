package com.titanic.ventapasajes.util.mail;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

//import com.outjected.email.api.MailMessage;
//import com.outjected.email.api.SessionConfig;
//import com.outjected.email.impl.MailMessageImpl;

@RequestScoped
public class Mailer implements Serializable{

	private static final long serialVersionUID = 1L;

//	@Inject
//	private SessionConfig sessionConfig;
//	
//	public MailMessage nuevoEmail(){
//		return new MailMessageImpl(this.sessionConfig);
//	}
	
}
