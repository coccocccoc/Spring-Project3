package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Member;

@SpringBootTest
public class MemberRepositoryTest {

	@Autowired
	MemberRepository repository;
	
	@Test
	private void 리파지토리_확인() {
		System.out.println(repository);
	}
	
	@Test
	public void 데이터_추가() {
		
		Member member1 = Member.builder()
									.user_id("admin")
									.grade("관리자")
									.password("1234")
									.build();
		Member member2 = Member.builder()
									.user_id("user1")
									.grade("사용자")
									.password("1234")
									.build();
		Member member3 = Member.builder()
									.user_id("user2")
									.grade("사용자")
									.password("1234")
									.build();
		Member member4 = Member.builder()
									.user_id("yoyt22")
									.grade("관리자")
									.password("1234")
									.build();
		repository.save(member1);
		repository.save(member2);
		repository.save(member3);
		repository.save(member4);
	}
	
	@Test
	public void 데이터_단건_조회() {
		
		Optional<Member> optional = repository.findById("admin");
		
		if (optional.isPresent()) {
			Member member = optional.get();
			System.out.println(member);
		}
	}
	
	@Test
	public void 데이터_전체_조회() {
		
		List<Member> list = repository.findAll();
		System.out.println(list);
	}
	
	@Test
	public void 데이터_수정() {
		
		Optional<Member> optional = repository.findById("admin");
		
		if(optional.isPresent()) {
			Member member = optional.get();
			member.setPassword("0000");
			repository.save(member);
		}
	}
	
	@Test 
	public void 데이터_단건_삭제() {
		repository.deleteById("user1");
	}
	
	@Test
	public void 데이터_전체_삭제() {
		repository.deleteAll();
	}
	
	@Test
	public void Q81() {
		List<Member> list = repository.get1("user");
		for(Member member : list) {
			System.out.println(member);
		}
	}
	
	@Test
	public void Q82() {
		List<Member> list = repository.get2("관리자");
		for(Member member : list) {
			System.out.println(member);
		}
	}
	
	
	
	
	
	
	
	
	
}
