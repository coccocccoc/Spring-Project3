package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Gift;
import com.example.demo.entity.Memo;

import lombok.val;

@SpringBootTest
public class GiftRepositoryTest {

	@Autowired
	GiftRepository repository;
	
	@Test
	private void 리파지토리_확인() {
		System.out.println(repository);
	}
	
	@Test
	public void 데이터_추가() {
		
		Gift gift1 = Gift.builder()
								.name("참치세트")
								.price(10000)
								.type("식품")
								.build();
		Gift gift2 = Gift.builder()
								.name("햄세트")
								.price(20000)
								.type("식품")
								.build();
		Gift gift3 = Gift.builder()
								.name("샴푸세트")
								.price(30000)
								.type("생활용품")
								.build();
		Gift gift4 = Gift.builder()
								.name("세차용품")
								.price(40000)
								.type("생활용품")
								.build();
		Gift gift5 = Gift.builder()
								.name("주방용품")
								.price(50000)
								.type("생활용품")
								.build();
		Gift gift6 = Gift.builder()
								.name("노트북")
								.price(60000)
								.type("가전제품")
								.build();
		Gift gift7 = Gift.builder()
								.name("벽걸이TV")
								.price(70000)
								.type("가전제품")
								.build();
		repository.save(gift1);
		repository.save(gift2);
		repository.save(gift3);
		repository.save(gift4);
		repository.save(gift5);
		repository.save(gift6);
		repository.save(gift7);
	}
	
	@Test
	public void 데이터_단건_조회() {
		
		Optional<Gift> optional = repository.findById(1);
		
		if(optional.isPresent()) {
			Gift gift = optional.get();
			System.out.println(gift);
		}
	}
	
	@Test
	public void 데이터_전체_조회() {
		
		List<Gift> list = repository.findAll();
		System.out.println(list);
	}
	
	@Test
	public void 데이터_수정() {
		
		Optional<Gift> optional = repository.findById(1);
		
		if(optional.isPresent()) {
			Gift gift = optional.get();
			gift.setName("한우세트");
			repository.save(gift);
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
	
	// 가격이 50000원 이상인 선물 검색
	@Test
	public void Q61() {
		
		List<Gift> list = repository.get1(50000);
		for(Gift gift : list) {
			System.out.println(gift);
		}
	}
	
	// 이름이 세트로 끝나는 선물 검색
	@Test
	public void Q62() {
		
		List<Gift> list = repository.get2("세트");
		for(Gift gift : list) {
			System.out.println(gift);
		}
	}
	
	// 가격은 40000원 이하고 품목은 생활용품인 선물 검색
	@Test
	public void Q63() {
		
		List<Gift> list = repository.get3(40000, "생활용품");
		for(Gift gift : list) {
			System.out.println(gift);
		}
	}
	
}
