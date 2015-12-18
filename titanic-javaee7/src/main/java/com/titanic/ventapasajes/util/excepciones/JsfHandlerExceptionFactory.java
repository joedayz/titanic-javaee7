package com.titanic.ventapasajes.util.excepciones;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

public class JsfHandlerExceptionFactory extends ExceptionHandlerFactory {

	private ExceptionHandlerFactory factory;
	
	public JsfHandlerExceptionFactory(ExceptionHandlerFactory factory){
		this.factory = factory;
	}
	
	@Override
	public ExceptionHandler getExceptionHandler() {
		return new JsfHandlerException(factory.getExceptionHandler());
	}

}
