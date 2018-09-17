package com.example.yumtuous.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name="user")
public class Patient extends User {

    public Patient(){}
 
    public Patient(String fullName, Date dateOfBirth) {
       super();
    }

	@Getter
	@Setter
	private String fk_user_payor;
	
	@Getter
	@Setter	
	private String fk_user_emergency;
	
	@Getter
	@Setter
	private String fk_user_referrer;
	
	@Getter
	@Setter
	private String address_street_service;
	
	@Getter
	@Setter
	private String address_postal_service; 
	
	@Getter
	@Setter
	private String living_with;
	
	@Getter
	@Setter
	private boolean has_fdw;
	
	@Getter
	@Setter
	private String marital_status;
	
	@Getter
	@Setter
	private String lang_spoken;
	
	@Getter
	@Setter	
	private String race;

	@Getter
	@Setter	
	private String religion;
	
	@Getter
	@Setter	
	private String housing_type;
	
	@Getter
	@Setter	
	private String accomodation_details;	
}