package com.skcc.tes.mypage.infrastructure.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.skcc.tes.mypage.domain.data.MyStatusDto;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "my_page_status")
@Table(name = "my_page_status", uniqueConstraints={@UniqueConstraint(name = "userIdUnique", columnNames = {"userId"})})
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MyStatus {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@Column(name = "userId")
	Long userId;		// 사용자 ID
	String name;		// 사용자 이름
	Double myServiceRate;	// 내가 받은 총 별점 합
	Double myServiceCnt;	// 내가 받은 총 별점 개수
	Long myRequestCntTotal;	// 내가 요청한 총 의뢰 개수
	Long myRequestCntDone;	// 내가 요청한 의뢰 중, 끝난 의뢰 개수
	Long userRequestCntTotal;	// 내가 요청 받은 총 의뢰 개수
	Long userRequestCntDone;	// 내가 요청 받은 의뢰 중, 끝난 의뢰 개수

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	LocalDateTime lastServiceDate;	// 마지막 서비스 제공일

	public static MyStatus parseFrom(MyStatusDto src) {
		return builder()
				.id(src.getId())
				.userId(src.getUserId())
				.name(src.getName())
				.myServiceRate(src.getMyServiceRate())
				.myServiceCnt(src.getMyServiceCnt())
				.myRequestCntTotal(src.getMyRequestCntTotal())
				.myRequestCntDone(src.getMyRequestCntDone())
				.userRequestCntTotal(src.getUserRequestCntTotal())
				.userRequestCntDone(src.getUserRequestCntDone())
				.lastServiceDate(src.getLastServiceDate())
				.build();
	}

	public MyStatusDto toDto() {
		return MyStatusDto.builder()
				.id(id)
				.userId(userId)
				.name(name)
				.myServiceRate(myServiceRate)
				.myServiceCnt(myServiceCnt)
				.myRequestCntTotal(myRequestCntTotal)
				.myRequestCntDone(myRequestCntDone)
				.userRequestCntTotal(userRequestCntTotal)
				.userRequestCntDone(userRequestCntDone)
				.lastServiceDate(lastServiceDate)
				.build();

	}
}
