package com.example.yumtuous.model;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity(name="user")
public class Payer extends User {
	@Getter
	@Setter
	private String relationship_with_customer;
}
