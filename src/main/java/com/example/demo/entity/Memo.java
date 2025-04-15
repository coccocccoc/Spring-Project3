package com.example.demo.entity;

import org.hibernate.annotations.Collate;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 테이블 구조를 정의하는 클래스

@Entity // JPA가 관리하는 클래스
@Table(name = "tbl_memo") // 실제 테이블 이름
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Memo {
	
	// 엔티티는 반드시 pk를 가지고 있어야 함
	// @Id: Primary key
	// @GeneratedValue: row가 추가될때 값이 자동으로 입력됨
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int no; // 컬럼의 타입과 이름
	
	// 컬럼의 크기 및 not null 여부
	@Column(length = 200, nullable = true)
	String text; // 컬럼의 타입과 이름

}


// ddl-auto=update
// 엔티티에 변화가 있으면 ddl (create, alter) sql을 자동으로 생성함
// 예를 들어, 실제 데이터베이스에 tbl_memo 라는 테이블이 없다면
// 엔티티 클래스를 읽어서 테이블을 생성함

// 해당 옵션이 없을 때는
// 데이터베이스에 tbl_memo라는 테이블이 있을때만 엔티티와 연결

