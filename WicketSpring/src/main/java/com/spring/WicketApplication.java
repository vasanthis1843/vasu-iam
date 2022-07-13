package com.spring;

import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;



public class WicketApplication extends WebApplication
{
	@Override
	public Class<HomePage> getHomePage() {

		return HomePage.class; // return default page
	}
	
	@Override
	protected void init() {
		
		super.init();
		getComponentInstantiationListeners().add(new SpringComponentInjector(this));
	}

	
	
}
