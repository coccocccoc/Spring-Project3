package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	
	// 주소지가 인천인 주문 검색
	@Query(value = "SELECT * FROM TBL_ORDER WHERE SHIP_ADDRESS LIKE %:address%", nativeQuery = true)
	List<Order> get1(@Param("address") String address);
	
	// 주문일이 7월 3일인 주문 검색
	@Query(value = "SELECT * FROM TBL_ORDER WHERE ORDER_DATE LIKE %:date", nativeQuery = true)
	List<Order> get2(@Param("date") String date);
	
	
	// 1. 함수 이름을 자유롭게 작성
	// 2. 파라미터는 함수의 매개변수로 처리
	// 매개변수의 타입은 엔티티를 참고
	// 3. SQL에 파라미터를 표기할 때는 ":파라미터"

	// 주문일로 주문이력을 검색
	@Query(value = "SELECT * FROM TBL_ORDER WHERE ORDER_DATE = :orderDt", nativeQuery = true)
	List<Order> get3(@Param("orderDt") LocalDate orderDt);
	
}
