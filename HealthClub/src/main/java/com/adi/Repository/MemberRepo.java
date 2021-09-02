package com.adi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adi.Models.Member;

@Repository
public interface MemberRepo extends JpaRepository<Member, Integer> {

	public Member findByEmail(String email);
	public Member findByPassword(Long password);
}
