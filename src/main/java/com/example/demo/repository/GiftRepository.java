package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Gift;

public interface GiftRepository extends JpaRepository<Gift, Integer> {

	// 가격이 50000원 이상인 선물 검색
	@Query(value = "SELECT * FROM TBL_GIFT WHERE price >= :price", nativeQuery = true)
	List<Gift> get1(@Param("price") int price);
	
	// 이름이 세트로 끝나는 선물 검색
	@Query(value = "SELECT * FROM TBL_GIFT WHERE name LIKE %:name", nativeQuery = true)
	List<Gift> get2(@Param("name") String name);
	
	// 가격은 40000원 이하고 품목은 생활용품인 선물 검색
	@Query(value = "SELECT * FROM TBL_GIFT WHERE price <= :price AND TYPE = :type", nativeQuery = true)
	List<Gift> get3(@Param("price") int price, @Param("type") String type);
}
