package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
	
	// 제목이 자바프로그래밍입문인 책을 검색
	@Query(value = "SELECT * FROM TBL_BOOK WHERE title = :title", nativeQuery = true)
	List<Book> get(@Param("title") String title);

	// 가격이 3만원 이상이고 출판사가 남가람북스인 책 검색
	@Query(value = "SELECT * FROM TBL_BOOK WHERE price >= :price AND publisher = :publisher", nativeQuery = true)
	List<Book> get2(@Param("price") int price, @Param("publisher") String publisher);
	
	// 출판사가 한빛출판사 또는 이지스퍼블리싱인 책 검색
	@Query(value = "SELECT * FROM TBL_BOOK WHERE publisher = :publisher1 OR publisher = :publisher2", nativeQuery = true)
	List<Book> get3(@Param("publisher1") String publisher1, @Param("publisher2") String publisher2);
	
}
