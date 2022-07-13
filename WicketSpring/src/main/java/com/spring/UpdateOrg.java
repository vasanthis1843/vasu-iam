package com.spring;

import java.io.IOException;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.spring.model.Organization;
import com.spring.service.OrganizationServiceimpl;

public class UpdateOrg extends WebPage{
	private static final long serialVersionUID = 1L;
    
	int orgid;
	String orgname;
	int noofemp;
	@SpringBean
	OrganizationServiceimpl orgser;
	public UpdateOrg(int orgid)
	{
	
	Form<Organization> updateForm=new Form<Organization>("OrganizationFormupdate")
	{
		private static final long serialVersionUID = 1L;

         protected void onSubmit()
           {
	
     orgser.updateorganization(orgid, new Organization(orgname,noofemp));
       try {
	      setResponsePage(new Page1());
      }
       catch (IOException | InterruptedException e)
        {
	        e.printStackTrace();
        }
	}
	};
	
	updateForm.add(new TextField<String>("uporgname", new PropertyModel<String>(this,"orgname")));
	updateForm.add(new TextField<Integer>("uporgnoofemp", new PropertyModel<Integer>(this,"noofemp")));
	add(updateForm);
    		
}
	

}
