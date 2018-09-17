package com.example.yumtuous.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.yumtuous.model.User;

public interface PersonRepository extends CrudRepository<User, Long> {

}
