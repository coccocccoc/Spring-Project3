package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Order2;

@SpringBootTest
public class Order2RepositoryTest {

	// 컨테이너에 있는 빈을 꺼내서 필드에 주입
	@Autowired
	Order2Repository repository;
	
	@Test
	public void 리파지토리확인() {
		System.out.println(repository);
		
		// Order2Repository는 JpaRepository로부터 save, find, delete 함수를 물려받음
		// Order2Repository는 함수를 사용하여 order 테이블에 있는 데이터를 조작할 수 있음
		repository.save(null);
		repository.findAll();
		repository.deleteAll();
	}
	
	@Test
	public void 데이터추가() {
		
		// 데이터 중에서 주문번호는 자동으로 생성됨
		// 데이터 중에서 고객명, 배송지, 주문일은 직접 입력
		
		LocalDate date1 = LocalDate.of(2023, 7, 1);
		LocalDate date2 = LocalDate.of(2023, 7, 2);
		LocalDate date3 = LocalDate.of(2023, 7, 3);
		
		// 0을 입력하면 빈값으로 처리됨
		Order2 order1 = new Order2(0, "둘리", date1, "인천 구월동");
		
		// no는 생략
		Order2 order2 = Order2.builder()
									.customerName("또치")
									.orderDate(date2)
									.shipAddress("인천 연수동")
									.build();
		
		Order2 order3 = Order2.builder()
									.customerName("도우너")
									.orderDate(date3)
									.shipAddress("부산 동래동")
									.build();
		
		Order2 order4 = Order2.builder()
									.customerName("마이콜")
									.orderDate(date1)
									.shipAddress(null)
									.build();
		
		Order2 order5 = Order2.builder()
									.customerName("고길동")
									.orderDate(date2)
									.shipAddress(null)
									.build();
		
		repository.save(order1);
		repository.save(order2);
		repository.save(order3);
		repository.save(order4);
		repository.save(order5);

	}

	@Test
	public void 데이터단건조회() {
		
		// order 테이블에서 no가 1인 데이터 조회
		// find: 조회
		// by: 조건
		// id: primary key
		Optional<Order2> optional = repository.findById(10);
		
		if(optional.isPresent()) {
			Order2 order = optional.get();
			System.out.println(order);
		}
	}
	
	@Test
	public void 데이터전체조회() {
		
		List<Order2> list = repository.findAll();
		System.out.println(list);
	}
	
	@Test
	public void 데이터수정() {
		
		// 1. 1번 데이터 조회
		Optional<Order2> optional = repository.findById(1);
		
		// 2. 데이터가 존재하는지 확인
		if(optional.isPresent()) {
			// 수정이 필요한 부분만 일부 변경
			Order2 order = optional.get();
			order.setShipAddress("서울 신림동");
			// 변경된 데이터를 테이블에 업데이트
			// save 함수 호출 시, no가 1인 데이터가 있으면 update
			// 없으면 insert
			repository.save(order);
		}
	}
	
	@Test
	public void 데이터단건삭제() {
		// 1번 데이터 삭제
		// delete: 삭제
		// by: 조건
		// id: primary key
		repository.deleteById(1);
	}
	
	@Test
	public void 데이터일괄삭제() {
		
		repository.deleteAll();
	}
	
}
