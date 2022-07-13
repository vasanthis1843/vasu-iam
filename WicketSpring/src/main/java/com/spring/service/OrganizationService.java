package com.spring.service;

import java.io.IOException;
import java.util.List;

import com.spring.model.Organization;

public interface OrganizationService {
	
	public Organization getOrgById(int orgid);
	 public List<Organization> getAllorg() throws IOException, InterruptedException;
	  public void  Addorg(Organization org);
	  public void updateorganization(int orgid,Organization org);
	  public void deleteorg(int orgid);
}
