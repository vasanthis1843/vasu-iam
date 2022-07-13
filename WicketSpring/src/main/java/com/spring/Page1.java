package com.spring;

import java.io.IOException;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.spring.model.Organization;
import com.spring.service.OrganizationService;

public class Page1 extends HomePage{
	private static final long serialVersionUID = 1L;
	@SpringBean
    private OrganizationService orgser;
	
	public Page1() throws IOException, InterruptedException,MismatchedInputException {
		
    add(new Link<AddNewOrg> ("addorg"){
     
		private static final long serialVersionUID = 1L;
		public void onClick()
    	{
    		setResponsePage(AddNewOrg.class);;
    	}
    	
    });

  
	DataView<Organization> orgdata=new DataView<Organization>("orgall", new ListDataProvider<Organization>(orgser.getAllorg())) {
	
	private static final long serialVersionUID = 1L;
	protected void populateItem(Item<Organization> item) {
		
		final Organization org=item.getModelObject();
		item.add(new Label("d1",org.getOrgid()));
		item.add(new Label("d2",org.getOrgname()));
		item.add(new Label("d3",org.getNoofemp()));
		item.add(new Link<UpdateOrg>("updateorgnization")
				{
					private static final long serialVersionUID = 1L;

					public void onClick()
			          {
			        	  setResponsePage(new UpdateOrg(org.getOrgid()));
			          }
				});
		item.add(new Link<Organization>("deleteorgnization") {
		
			private static final long serialVersionUID = 1L;

			public void onClick() {
				orgser.deleteorg(org.getOrgid());
			try {
				setResponsePage(new Page1());
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			}
		});
			
	}
   };
   add(orgdata);
	add(new Label("getbyOrgid",orgser.getOrgById(6).getOrgname()));
}
}
