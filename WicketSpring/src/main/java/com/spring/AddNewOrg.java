package com.spring;

import java.io.IOException;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.spring.model.Organization;
import com.spring.service.OrganizationServiceimpl;

public class AddNewOrg extends WebPage {

	private static final long serialVersionUID = 1L;
	int orgid;
	String orgname;
    int noofemp;
	@SpringBean
     OrganizationServiceimpl orgimpl;
	public AddNewOrg()
	{
		Form<Organization> orgForm=new Form<Organization>("orgdetailsform")
				{
					private static final long serialVersionUID = 1L;

			protected void onSubmit()
			{
				
			orgimpl.Addorg(new Organization(orgid,orgname,noofemp));
			try {
				setResponsePage(new Page1());
			}
			catch (IOException | InterruptedException e)
			{
				e.printStackTrace();
			}
				}
				};
				orgForm.add(new TextField<Integer>("orgid", new PropertyModel<Integer>(this,"orgid")));
				orgForm.add(new TextField<String>("orgname", new PropertyModel<String>(this,"orgname")));
				orgForm.add(new TextField<Integer>("noofemp", new PropertyModel<Integer>(this,"noofemp")));
				
				add(orgForm);
	}

}
