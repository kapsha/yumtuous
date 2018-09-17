package com.example.yumtuous.model;

import lombok.Getter;

public class BhalSubscription {
	
	@Getter
	private Patient patient;
	
	@Getter
	private EmergencyContact sosContact;
	
	@Getter
	private Payer payer;
}