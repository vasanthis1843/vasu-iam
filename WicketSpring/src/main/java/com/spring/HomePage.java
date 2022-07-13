package com.spring;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.WebPage;

public class HomePage extends WebPage {
	
	private static final long serialVersionUID = 1L;

	public HomePage() {
		super();

		//add(new BookmarkablePageLink<Page1>("page1", Page1.class));
		add(new Link<Page1>("page1") {
			private static final long serialVersionUID = 1L;

		public void onClick() {
	   		   setResponsePage(Page1.class);   
	   	   }
	      });
		
		add(new Link<Page1>("page2") {
			private static final long serialVersionUID = 1L;

		public void onClick() {
	   		   setResponsePage(Page2.class);   
	   	   }
	      });
		
	}
	
}

	
