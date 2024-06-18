package com.example.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.CustomerEntity;

public interface CustomerRepo extends JpaRepository<CustomerEntity, Long> {
	List<CustomerEntity> findByEmail(String email);
}
