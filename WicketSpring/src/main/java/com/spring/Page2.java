package com.spring;


import java.io.IOException;

import org.apache.wicket.markup.html.basic.Label;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.spring.injection.annot.SpringBean;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.spring.model.Employee;
import com.spring.service.Helloservice;

public class Page2 extends HomePage{
	
	private static final long serialVersionUID = 1L;


    @SpringBean
	private Helloservice service;
  

	
 public Page2() throws IOException,InterruptedException,MismatchedInputException{
	  
	
	// add(new Label("empid",service.getEmpById(16).getEmpname()));
	
	  
	  
	  add(new Link<AddNewEmp>("addemp") {
		private static final long serialVersionUID = 1L;
	public void onClick() {
		
   		   setResponsePage(AddNewEmp.class);   
   	   }
      });
	
	 
	DataView<Employee> view =new DataView<Employee>("empgetall",new ListDataProvider<Employee>(service.getemp())) {
  
		private static final long serialVersionUID = 1L;

	protected void populateItem(Item<Employee> item) {
    	final Employee employee=item.getModelObject();
	   item.add(new Label("data1",employee.getEmpid()));
	   item.add(new Label("data2",employee.getEmpname()));
	   item.add(new Label("data3",employee.getEmpage()));
	   item.add(new Label("data4",employee.getEmprole()));
	   item.add(new Label("data5",employee.getEmpaddress()));
 	   item.add(new Link<UpdateEmp>("update") {
		
		private static final long serialVersionUID = 1L;

		public void onClick() {
			   setResponsePage(new UpdateEmp(employee.getEmpid()));
		   }
	   });
	   item.add(new Link<DeleteEmp>("delete")
			   {
				private static final long serialVersionUID = 1L;

				public void onClick() {
					setResponsePage(new DeleteEmp(employee.getEmpid()));
				}
			   });
	 
	
	}
	
	};
	add(view);
	
	
	}}
