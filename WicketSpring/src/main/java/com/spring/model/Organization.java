package com.spring.model;

import java.io.Serializable;
import java.util.List;

public class Organization implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int orgid;
	private String orgname;
	private int noofemp;
	List<Organization> org;
	public Organization()
	{
		
	}
	public int getOrgid() {
		return orgid;
	}
	public void setOrgid(int orgid) {
		this.orgid = orgid;
	}
	public String getOrgname() {
		return orgname;
	}
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	public int getNoofemp() {
		return noofemp;
	}
	public void setNoofemp(int noofemp) {
		this.noofemp = noofemp;
	}
	
	
	public Organization(int orgid, String orgname, int noofemp) {
		this.orgid = orgid;
		this.orgname = orgname;
		this.noofemp = noofemp;
	}
	public Organization(int orgid) {
		this.orgid=orgid;
	}
	public Organization(String orgname, int noofemp) {
	     this.orgname=orgname;
	     this.noofemp=noofemp;
	}
}
