package com.spring.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.github.openjson.JSONArray;
import com.github.openjson.JSONObject;
import com.spring.model.Employee;


@Service
public class HelloServiceImpl implements Helloservice{
	final static List<Employee> list=new ArrayList<Employee>();
	HttpClient hp=HttpClient.newHttpClient();
	 RestTemplate restTemplate = new RestTemplate();
	 
	 public Employee getEmpById(int empid) {
	  
	  String url ="http://localhost:8081/getEmp/"+empid; 
	 
	  ResponseEntity<Employee>response=restTemplate.getForEntity(url,Employee.class); 
	  Employee employee=response.getBody();
	  System.out.println(response); 
	  return employee;
	  }
	
	 public List<Employee> getemp() throws IOException, InterruptedException{
		 
		 String url="http://localhost:8081/getallemp";
		 HttpRequest req=HttpRequest.newBuilder().uri(URI.create(url)).build();
		 HttpResponse<String> rep=hp.send(req,HttpResponse.BodyHandlers.ofString());
		 System.out.println("hello"+"    "+rep.body());
		 JSONArray ja = new JSONArray(rep.body());
			for (int i = 0; i < ja.length(); i++) {
			
				JSONObject jo = new JSONObject(ja.get(i));
				list.add(new Employee(jo.getInt("empid"), jo.getString("empname"), jo.getString("empage"),jo.getString("emprole"),jo.getString("empaddress")));
		}
      return list;
		 }
		 public Employee addemp(int orgid,Employee newemp) {
	        
				/*
				 * newemp.setEmpid(newemp.getEmpid()); newemp.setEmpname(newemp.getEmpname());
				 * newemp.setEmpage(newemp.getEmpage()); newemp.setEmprole(newemp.getEmprole());
				 * newemp.setEmpaddress(newemp.getEmpaddress());
				 */
			 HttpEntity<Employee> request=new HttpEntity<Employee>(newemp);
			 restTemplate.postForObject("http://localhost:8081/addemp/"+orgid, request, Employee.class); 
			  return newemp; 
	   
		  }
		 
		  public void deleteemployee(int empid,int orgid) { 
		
			  String url="http://localhost:8081/deleteemp/"+orgid+"/"+empid;
	             restTemplate.delete(url);
	 
		 }
		
		  
		  public void updateemp(int empid,Employee emp)
		  {
			  String url="http://localhost:8081/updateemp/"+empid;
			  
		      // ResponseEntity<Employee> rep=restTemplate.getForEntity(url,Employee.class);
			  emp.setEmpname(emp.getEmpname());
		    	emp.setEmprole(emp.getEmprole());
		    	emp.setEmpage(emp.getEmpage());
		    	emp.setEmpaddress(emp.getEmpaddress());
		      org.springframework.http.HttpEntity<Employee> hp=new org.springframework.http.HttpEntity<Employee>(emp);
		       restTemplate.exchange(url, HttpMethod.PUT, hp, Employee.class);
		  }
	
}

	
	
	

