package com.example.demo.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
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

// jpa 기능 구현하는 방법
// 1. entity (테이블 구조 정의)
// 2. repository (데이터 작업 처리)

// 게시물 데이터: 게시물 번호, 제목, 내용, 등록일, 수정일
// 사용자가 입력해야 하는 값: 제목과 내용
// 시스템이 입력해야 하는 값: 번호, 등록일, 수정일

// 이벤트 리스너 등록
// insert, update 이벤트를 감지
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "tbl_board") // 실제 테이블 이름
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Board {
	
	// @Id: 해당 컬럼을 pk로 설정
	// @GeneratedValue: 키 자동 생성 (pk + int 일 때 사용)
	// 왜? pk는 중복되면 안되는 값
	// 자료구조 / 데이터베이스의 식별자? index key
	// 식별자는 사용자에게는 의미가 없는 데이터
	// 데이터베이스 안에서 row를 구분하기 위한 용도
	
	// 게시물 번호
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int boardNo;
	
	// 제목
	// 컬럼의 길이와 not null 여부
	@Column(length = 30, nullable = false)
	String title; // 컬럼의 자료형과 이름
	
	// 내용
	@Column(length = 200)
	String content;
	
	// 게시물 등록일
	// insert 작업을 감지하여 자동으로 현재 시간을 입력
	@CreatedDate
	@DateTimeFormat(pattern = "YYYY-MM-dd HH:mm:ss")
	LocalDateTime createDate;
	
	// 게시물 수정일
	// 최초에 등록 후에 update 작업을 감지하여 자동으로 현재 시간을 입력
	@LastModifiedDate
	@DateTimeFormat(pattern = "YYYY-MM-dd HH:mm:ss")
	LocalDateTime modiDate;
}









