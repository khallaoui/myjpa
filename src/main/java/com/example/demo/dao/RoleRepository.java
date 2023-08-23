package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.AppRole;

public interface RoleRepository extends JpaRepository<AppRole, Integer>{
	AppRole findByNomRole(String role);
}
