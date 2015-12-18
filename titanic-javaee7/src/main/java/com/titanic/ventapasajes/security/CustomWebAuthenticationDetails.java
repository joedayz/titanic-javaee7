package com.titanic.ventapasajes.security;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Celeritech Peru on 18/08/2015.
 */
public class CustomWebAuthenticationDetails extends WebAuthenticationDetails {

    private final String localVenta;

    public CustomWebAuthenticationDetails(HttpServletRequest request) {
        super(request);
        localVenta = request.getParameter("localVenta_input");
        
    }

    public String getyourParameter() {
        return localVenta;
    }
    
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CustomWebAuthenticationDetails that = (CustomWebAuthenticationDetails) o;

        return !(localVenta != null ? !localVenta.equals(that.localVenta) : that.localVenta != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (localVenta != null ? localVenta.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CustomWebAuthenticationDetails{" +
                "yourParameter='" + localVenta + '\'' +
                '}';
    }
}
