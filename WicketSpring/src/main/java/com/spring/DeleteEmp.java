
 package com.spring;
 import java.io.IOException;
 
  import org.apache.wicket.markup.html.WebPage; import
  org.apache.wicket.markup.html.form.Form; import
  org.apache.wicket.markup.html.form.TextField; import
  org.apache.wicket.model.PropertyModel; import
  org.apache.wicket.spring.injection.annot.SpringBean;
  
  import com.fasterxml.jackson.databind.exc.MismatchedInputException; import
  com.spring.model.Employee; import com.spring.model.Organization; import
  com.spring.service.HelloServiceImpl;
  
  public class DeleteEmp extends WebPage{
  
  private static final long serialVersionUID = 1L; int orgid;
  
  @SpringBean private HelloServiceImpl helloser; public DeleteEmp(int empid) {
  Form<Employee> deleteform=new Form<Employee>("empdetailsdeleted") { private
  static final long serialVersionUID = 1L;
  
  protected void onSubmit() { helloser.deleteemployee(empid,orgid);
  
  try {
		setResponsePage(new Page2());
	} catch (IOException | InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} } }; 
  deleteform.add(new TextField<String>("deleteemp",
  new PropertyModel<String>(this,"orgid"))); add(deleteform);
  
 }
  
  }
 