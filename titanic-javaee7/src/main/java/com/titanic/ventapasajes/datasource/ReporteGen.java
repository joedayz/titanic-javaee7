/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.titanic.ventapasajes.datasource;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;


/**
 * @author Jhon
 */

public class ReporteGen implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6894823156794184869L;

	public void  exportByFormato(JRDataSource dt,String path, String type,  String outputFileName) {     
        try {
          FacesContext context = FacesContext.getCurrentInstance();
          HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();               
          ServletContext scontext = (ServletContext) context.getExternalContext().getContext();
   
          byte[] bytes = null;
          
            try {
           
                JasperPrint jasperPrint = JasperFillManager.fillReport(scontext.getRealPath(path), null, dt);
                ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();             
                         
                JRExporter  exporter =  null ;   
                
                   exporter  = new JRPdfExporter();
                   response.setContentType("application/pdf");
                   response.setHeader("Content-disposition", "attachment;filename=" + outputFileName + ".pdf");
                   exporter.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint);                                                                 
                   exporter.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, arrayOutputStream);
                   exporter.setParameter(JRPdfExporterParameter.PDF_JAVASCRIPT, "this.print({bUI: true, bSilent: false, bShrinkToFit: true});");
                   exporter.exportReport();                                                                                                      

                  if (exporter != null) {
                      try{
                            bytes = arrayOutputStream.toByteArray();

                            if (bytes != null && bytes.length > 0) {                      

                            response.setHeader("Expires", "0");
                            response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
                              response.setHeader("Pragma", "public");
                               bytes = arrayOutputStream.toByteArray();                                
                               response.setContentLength(bytes.length);
                               response.getOutputStream().write(bytes, 0, bytes.length);

                            }
                      } catch (Exception e) {
                                   
                      }                            
                  }                 
            }  catch (JRException e) {
                StringWriter stringWriter = new StringWriter();
                PrintWriter printWriter = new PrintWriter(stringWriter);
                e.printStackTrace(printWriter);        
                
            }  finally {
                  response.getOutputStream().flush();
                  response.getOutputStream().close();                      
                context.responseComplete();
            }
        } catch (Exception j) {
            
        }       
    }
    

}
