package com.example.demo.repository;

import java.nio.channels.Pipe;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Order;

@SpringBootTest
public class OrderRepositoryTest {

	@Autowired
	OrderRepository repository;
	
	@Test
	private void 리파지토리_확인() {
		System.out.println(repository);
	}
	
	@Test
	public void 데이터_추가() {
		
		LocalDate localDate1 = LocalDate.of(2023, 7, 1);
		LocalDate localDate2 = LocalDate.of(2023, 7, 2);
		LocalDate localDate3 = LocalDate.of(2023, 7, 3);

		
		Order order1 = Order.builder()
									.customer_name("둘리")
									.order_date(localDate1)
									.ship_address("인천 구월동")
									.build();
		Order order2 = Order.builder()
								.customer_name("또치")
								.order_date(localDate2)
								.ship_address("인천 연수동")
								.build();
		Order order3 = Order.builder()
								.customer_name("도우너")
								.order_date(localDate3)
								.ship_address("부산 동래동")
								.build();
		Order order4 = Order.builder()
								.customer_name("마이콜")
								.order_date(localDate1)
								.ship_address(null)
								.build();
		Order order5 = Order.builder()
								.customer_name("고길동")
								.order_date(localDate2)
								.ship_address(null)
								.build();
		
		repository.save(order1);
		repository.save(order2);
		repository.save(order3);
		repository.save(order4);
		repository.save(order5);
	}
	
	@Test
	public void 데이터_단건_조회() {
		
		Optional<Order> optional = repository.findById(4);
		
		if(optional.isPresent()) {
			
			Order order = optional.get();
			System.out.println(order);
		}
	}
	
	@Test
	public void 데이터_전체_조회() {
		
		List<Order> list = repository.findAll();
		System.out.println(list);
	}
	
	@Test
	public void 데이터_수정() {
		
		Optional<Order> optional = repository.findById(2);
		
		if(optional.isPresent()) {
			
			Order order = optional.get();
			order.setShip_address("인천 갈산동");
			repository.save(order);
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
	public void Q71 () {
		List<Order> list = repository.get1("인천");
		for(Order order : list) {
			System.out.println(order);
		}
	}
	
	@Test
	public void Q72() {
		List<Order> list = repository.get2("07-03");
		for(Order order : list ) {
			System.out.println(order);
		}
	}
	
	@Test
	public void 주문일로검색() {
		
		// of 함수로 LocalDate 인스턴스 생성
		LocalDate date = LocalDate.of(2023, 7, 3);
		
		// 7월 3일에 들어온 주문이력을 검색
		List<Order> list = repository.get3(date);
		
		for(Order order : list) {
			System.out.println(order);
		}
		
	}
	
	
}

