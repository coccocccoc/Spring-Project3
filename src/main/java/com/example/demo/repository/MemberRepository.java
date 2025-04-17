package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String> {
	
	// 아이디가 user로 시작하는 회원 검색
	@Query(value = "SELECT * FROM TBL_MEMBER WHERE USER_ID LIKE :id%", nativeQuery = true)
	List<Member> get1(@Param("id") String id);
	
	// 관리자 등급인 회원 검색
	@Query(value = "SELECT * FROM TBL_MEMBER WHERE grade = :grade", nativeQuery = true)
	List<Member> get2(@Param("grade") String grade);

}
