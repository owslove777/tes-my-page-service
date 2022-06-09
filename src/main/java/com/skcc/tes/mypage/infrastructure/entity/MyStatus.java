package com.skcc.tes.mypage.infrastructure.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.skcc.tes.mypage.domain.data.MyStatusDto;
import com.skcc.tes.mypage.vo.Address;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "my_status")
@Table(name = "my_status")
@Setter
@Getter
public class MyStatus {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String userId;		// 사용자 ID
	String name;		// 사용자 이름
	Integer cntComment;	// 코멘트 개수
	Double serviceRate;	// 나의 별점
	Boolean isDormantAccount; 	// 휴면 계정인지 아닌지 여부

	@Embedded
	Address address;


	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	LocalDateTime lastLogin;			// 마지막 로그인

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	LocalDateTime lastServiceDate;	// 마지막 서비스 제공일

	public MyStatusDto toDto() {
		return MyStatusDto.builder()
				.id(id)
				.userId(userId)
				.name(name)
				.cntComment(cntComment)
				.serviceRate(serviceRate)
				.isDormantAccount(isDormantAccount)
				.lastLogin(lastLogin)
				.lastServiceDate(lastServiceDate)
				.build();

	}
}
