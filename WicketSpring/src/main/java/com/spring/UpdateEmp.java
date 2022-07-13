package com.spring;

import java.io.IOException;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.spring.model.Employee;
import com.spring.service.HelloServiceImpl;

public class UpdateEmp extends WebPage{
	
	private static final long serialVersionUID = 1L;
	// Employee employee=new Employee(17,"varsha","34","intern","chittoor");
    //service.updateemp(17,employee);
    int empid;
	String empname;
	String empage;
	String emprole;
	String empaddress;
	@SpringBean
	private HelloServiceImpl helloser;
	public UpdateEmp(int empid)
	{
		Form<Employee> updateForm=new Form<Employee>("empdetailsFormupdate")
				{
					private static final long serialVersionUID = 1L;

			protected void onSubmit()
			{
			/*	Employee emp=new Employee();
			   emp.setEmpid(emp.getEmpid());
				emp.setEmpname(emp.getEmpname());
				emp.setEmpage(emp.getEmpage());
				emp.setEmprole(emp.getEmprole());
				emp.setEmpaddress(emp.getEmpaddress());*/
				
			helloser.updateemp(empid,new Employee(empname,empage,emprole,empaddress));
			try {
				setResponsePage(new Page2());
			}
			catch (IOException | InterruptedException e)
			{
				e.printStackTrace();
			}
				}
				};
				//empForm.add(new TextField<Integer>("empid", new PropertyModel<Integer>(this,"empid")));
				updateForm.add(new TextField<String>("upempname", new PropertyModel<String>(this,"empname")));
				updateForm.add(new TextField<String>("upempage", new PropertyModel<String>(this,"empage")));
				updateForm.add(new TextField<String>("upemprole", new PropertyModel<String>(this,"emprole")));
				updateForm.add(new TextField<String>("upempaddress", new PropertyModel<String>(this,"empaddress")));
				add(updateForm);
	            		
	}
	 	
	
}
