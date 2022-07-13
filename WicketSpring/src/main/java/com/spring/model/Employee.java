package com.spring.model;

import java.io.Serializable;
import java.util.List;

public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	private int empid;
	private String empname;
	private String empage;
	private String emprole;
	private String empaddress;
	private List<Employee> employees;
	public Employee()
	{
	
	}
	public Employee(String empname, String empage, String emprole, String empaddress)
	{
		this.empname=empname;
		this.empage=empage;
		this.emprole=emprole;
		this.empaddress=empaddress;
	}
    
    public Employee(int empid2, Employee emp)
    { 
    	
    	emp=new Employee(empid2,empname,empage,emprole,empaddress);
    }
    
	public List<Employee> getEmployees() {
		return employees;
	}
	
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	

	public Employee(int empid, String empname, String empage, String emprole, String empaddress) {
		
		this.empid = empid;
		this.empname = empname;
		this.empage = empage;
		this.emprole = emprole;
		this.empaddress = empaddress;

	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getEmpage() {
		return empage;
	}
	public void setEmpage(String empage) {
		this.empage = empage;
	}
	public String getEmprole() {
		return emprole;
	}
	public void setEmprole(String emprole) {
		this.emprole = emprole;
	}
	public String getEmpaddress() {
		return empaddress;
	}
	public void setEmpaddress(String empaddress) {
		this.empaddress = empaddress;
	}
	/*public String getJsonStr()
	{
		return jsonStr;
	}
	
	 * public Employee(int empid, String empname, String empage, String emprole,
	 * String empaddress,String jsonStr ) { super(); // Organization jsonStr =
	 * JSONArray.toJSONString(organization); this.empid = empid; this.empname =
	 * empname; this.empage = empage; this.emprole = emprole; this.empaddress =
	 * empaddress; this.jsonStr=jsonStr; }
	 */
	
	
	
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", empage=" + empage + ", emprole=" + emprole
				+ ", empaddress=" + empaddress + "]";
	}
	
	

}
