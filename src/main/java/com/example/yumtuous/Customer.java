package com.example.yumtuous;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

@Entity(name="app_customer")
public class Customer{

    public Customer(){}
 
    public Customer(String firstName, String lastName, Date dateOfBirth) {
       super();
       this.firstName = firstName;
       this.lastName = lastName;
       this.dateOfBirth = dateOfBirth;
    }

    @Id
    @Getter
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
 
    @Setter
    @Getter
    @Column(nullable = false, length = 30)
    private String firstName;
 
    @Setter
    @Getter
    @Column(nullable = false, length = 30)
    private String lastName;
 
    @Setter 
    @Getter
    @Column(nullable = false)
    private Date dateOfBirth;
    
    @Setter 
    @Getter
    @Column(nullable = false)
    @Email
    private String email;
    
    @Setter 
    @Getter
    @Column(nullable = false)
    @Pattern(regexp="([0-9]{10})")
    private String mobile;
}