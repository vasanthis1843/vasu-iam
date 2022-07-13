package com.spring.service;

import java.io.IOException;

import java.util.List;

import com.spring.model.Employee;

public interface Helloservice {
	public Employee getEmpById(int empid);
	 public List<Employee> getemp() throws IOException, InterruptedException;
	 public Employee addemp(int orgid,Employee newemp);
	public void deleteemployee(int empid,int orgid);
	 public void updateemp(int empid,Employee emp);
}
