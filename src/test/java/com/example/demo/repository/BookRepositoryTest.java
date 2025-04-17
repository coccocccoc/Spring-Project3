package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Book;
import com.example.demo.entity.Memo;

@SpringBootTest
public class BookRepositoryTest {

	@Autowired
	BookRepository repository;
	
	@Test
	private void 리파지토리_확인() {
		System.out.println(repository);
	}
	
	@Test
	public void 데이터_등록(){
		
		Book book1 = Book.builder()
								.price(20000)
								.publisher("한빛출판사")
								.title("자바프로그래밍입문")
								.build();
		Book book2 = Book.builder()
								.price(25000)
								.publisher("남가람북스")
								.title("스프링부트프로젝트")
								.build();
		Book book3 = Book.builder()
								.price(40000)
								.publisher("남가람북스")
								.title("실무로 끝내는 PHP")
								.build();
		Book book4 = Book.builder()
								.price(35000)
								.publisher("이지스퍼블리싱")
								.title("알고리즘코딩테스트")
								.build();
		repository.save(book1);
		repository.save(book2);
		repository.save(book3);
		repository.save(book4);
		
	}
	
	@Test
	public void 데이터_단건_조회() {
		
		Optional<Book> optional = repository.findById(1);
		
		if(optional.isPresent()) {
			Book book = optional.get();
			System.out.println(book);
		}
	}
	
	@Test
	public void 데이터_전체_조회() {
		
		List<Book> list = repository.findAll();
		System.out.println(list);
	}
	
	@Test
	public void 데이터_수정() {
		
		Optional<Book> optional = repository.findById(1);
		
		if(optional.isPresent()) {
			Book book = optional.get();
			book.setPrice(10000);
			repository.save(book);
		}
	}
	
	@Test
	public void 데이터_단건_삭제() {
		repository.deleteById(1);
	}
	
	@Test
	public void 데이터_전체_삭제() {
		repository.deleteAll();
	}
	
	@Test
	public void Q51() {
		List<Book> list = repository.get("자바프로그래밍입문");
		System.out.println(list);
	}
	
	@Test
	public void Q52() {
		List<Book> list = repository.get2(30000, "남가람북스");
		System.out.println(list);
	}
	
	@Test
	public void Q53() {
		List<Book> list = repository.get3("한빛출판사", "이지스퍼블리싱");
		System.out.println(list);
	}
	
	
	
}
