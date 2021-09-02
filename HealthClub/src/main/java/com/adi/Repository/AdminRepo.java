package com.adi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adi.Models.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer> {

	public Admin findByEmail(String email);
	public Admin findByPassword(Long password);
}
