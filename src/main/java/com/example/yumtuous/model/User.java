package com.example.yumtuous.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
public class User {
	
	public User(){}
	  
	@Id
	@Getter
	@Setter
	private String uuid;
	
	@Getter
	@Setter
	@Column(name = "full_name", nullable = false)
	private String fullName;
	
	@Getter
	@Setter
	private String govt_id_type;
	
	@Getter
	@Setter
	private String govt_id;
	
	@Getter
	@Setter	
	private String nric_color;
	
	@Getter
	@Setter	
	private Date dob;
	
	@Getter
	@Setter	
	@Pattern(regexp="([0-9]{10})")
	private String mobile_phone;
	
	@Getter
	@Setter
	@Pattern(regexp="([0-9]{10})")
	private String home_phone;
	
	@Getter
	@Setter	
	private String email;
	
	@Getter
	@Setter
	private String address_street_nric;
	
	@Getter
	@Setter
	private String address_postal_nric;

	@Getter
	@Setter
	private String user_type;
}