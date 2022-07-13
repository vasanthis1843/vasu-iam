package com.spring;

import java.io.IOException;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.spring.model.Employee;
import com.spring.model.Organization;
import com.spring.service.HelloServiceImpl;


public class AddNewEmp  extends WebPage{
	
	private static final long serialVersionUID = 1L;
	int empid;
	String empname;
	String empage;
	String emprole;
	String empaddress;
	private Organization org;
     int orgid;
	@SpringBean
     HelloServiceImpl empserimpl;
	public AddNewEmp()
	{
		Form<Employee> empForm=new Form<Employee>("empdetailsForm")
				{
					private static final long serialVersionUID = 1L;

			protected void onSubmit()
			{
				
			empserimpl.addemp(org.getOrgid(),new Employee(empid,empname,empage,emprole,empaddress));
			try {
		           setResponsePage(new Page2());
			}
			catch (IOException | InterruptedException e)
			{
				e.printStackTrace();
			}
				}
				};
				empForm.add(new TextField<Integer>("orgid",new PropertyModel<Integer>(this, "orgid")));
				empForm.add(new TextField<Integer>("empid", new PropertyModel<Integer>(this,"empid")));
				empForm.add(new TextField<String>("empname", new PropertyModel<String>(this,"empname")));
				empForm.add(new TextField<String>("empage", new PropertyModel<String>(this,"empage")));
				empForm.add(new TextField<String>("emprole", new PropertyModel<String>(this,"emprole")));
				empForm.add(new TextField<String>("empaddress", new PropertyModel<String>(this,"empaddress")));
				
				add(empForm);
	}
     
}
