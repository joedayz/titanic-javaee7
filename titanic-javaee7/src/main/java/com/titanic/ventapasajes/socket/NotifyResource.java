package com.titanic.ventapasajes.socket;

import org.primefaces.push.annotation.OnMessage;
import org.primefaces.push.annotation.PushEndpoint;
import org.primefaces.push.impl.JSONEncoder;

import javax.faces.application.FacesMessage;

/**
 * Created by Celeritech Peru on 02/03/2015.
 */
@PushEndpoint("/notify")
public class NotifyResource {

    @OnMessage(encoders = {JSONEncoder.class})
    public FacesMessage onMessage(FacesMessage message){
        return message;
    }

}
