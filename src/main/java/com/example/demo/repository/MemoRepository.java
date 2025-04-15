package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Memo;

// 리파지토리 만드는 방법
// "JpaRepository" 인터페아스 상속받기
// 제네릭 타입은 엔티티와 pk 타입을 작성

// JpaRepository를 상속받아 조회, 추가, 수정, 삭제 기능을 물려받음
public interface MemoRepository extends JpaRepository<Memo, Integer> {

}


/*
 *  jpa 기능을 사용하는 방법
 *  1. 엔티티 생성 (테이블 정의)
 *  2. 리파지토리 생성 (테이블 안에 있는 데이터를 조회, 수정, 추가, 삭제 처리)
 *  
 * */
