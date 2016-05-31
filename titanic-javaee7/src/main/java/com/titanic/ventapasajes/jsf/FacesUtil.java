package com.titanic.ventapasajes.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesUtil {

	public static boolean isPostback(){
		return FacesContext.getCurrentInstance().isPostback();
	}
	
	public static void adicionarMensajeError(String mensaje){
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_ERROR, mensaje, mensaje));	
	}
	
	public static void adicionarMensajeInfo(String mensaje){
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO, mensaje, mensaje));	
	}
}
