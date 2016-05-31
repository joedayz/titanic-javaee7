package com.titanic.ventapasajes.util.cdi;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterBeanDiscovery;
import javax.enterprise.inject.spi.BeforeBeanDiscovery;
import javax.enterprise.inject.spi.Extension;
import javax.faces.bean.ViewScoped;


public class ViewContextExtension implements Extension
{
	public void addScope(@Observes final BeforeBeanDiscovery event)
	{
		event.addScope(ViewScoped.class, true, true);
	}

	public void registerContext(@Observes final AfterBeanDiscovery event)
	{
		event.addContext(new ViewScopedContext());
	}
}