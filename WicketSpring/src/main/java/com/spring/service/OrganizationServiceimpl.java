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
import com.spring.model.Organization;

@Service
public class OrganizationServiceimpl implements OrganizationService {
	 List<Organization> list1= new ArrayList<Organization>();
	 HttpClient hp=HttpClient.newHttpClient();
	 RestTemplate restTemplate=new RestTemplate();
     //get orgid 
	 public Organization getOrgById(int orgid)
	 {
		 String url ="http://localhost:8081/getorgid/"+orgid; 
		  ResponseEntity<Organization>response=restTemplate.getForEntity(url,Organization.class); 
		  Organization org=response.getBody();
		  System.out.println(response); 
		  return org;
	 }
     public List<Organization> getAllorg() throws IOException, InterruptedException{
	
		 String url="http://localhost:8081/getorg";
		 HttpRequest req=HttpRequest.newBuilder().uri(URI.create(url)).build();
		 HttpResponse<String> rep=hp.send(req,HttpResponse.BodyHandlers.ofString());
		 JSONArray ja = new JSONArray(rep.body());
		 System.out.println("hii"+"     "+rep.body());
			for (int i = 0; i < ja.length(); i++) {
			
				JSONObject jo = new JSONObject(ja.get(i));
				list1.add(new Organization(jo.getInt("orgid"), jo.getString("orgname"), jo.getInt("noofemp")));
		
			}
      return list1;
		 }
     public void  Addorg(Organization org)
     { String url="http://localhost:8081/add";
    	 //Organization org=new Organization();
    	// org.setOrgid(9);
    	 //org.setOrgname("HCL");
    	 //org.setNoofemp(200);
     HttpEntity<Organization> request=new HttpEntity<Organization>(org);
    	 restTemplate.postForObject(url, request,Organization.class);
    	
     }
     
     public void updateorganization(int orgid,Organization org)
	  {
		  String url="http://localhost:8081/updateorg/"+orgid;
		  org.setOrgname(org.getOrgname());
		  org.setNoofemp(org.getNoofemp());
	      HttpEntity<Organization> hp=new HttpEntity<Organization>(org);
	       restTemplate.exchange(url, HttpMethod.PUT, hp, Organization.class);
	  }
	  public void deleteorg(int orgid) { 
			
		  String url="http://localhost:8081/delete/org"+orgid;
             restTemplate.delete(url);
 
	 }
}
