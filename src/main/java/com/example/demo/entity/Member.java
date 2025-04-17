package com.example.demo.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "tbl_member")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Member {

	@Id
	String user_id;
	
	@Column(nullable = false)
	String grade;
	
	@Column(nullable = false)
	String password;
	
	@CreatedDate
	@DateTimeFormat(pattern = "YYYY-MM-dd")
	@Column(nullable = false)
	LocalDate register_date;
}
