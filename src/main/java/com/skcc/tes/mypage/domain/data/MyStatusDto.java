package com.skcc.tes.mypage.domain.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MyStatusDto {

    Long id;
    String userId;		// 사용자 ID
    String name;		// 사용자 이름
    Integer cntComment;	// 코멘트 개수
    Double serviceRate;	// 나의 별점
    Boolean isDormantAccount; 	// 휴면 계정인지 아닌지 여부

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    LocalDateTime lastLogin;			// 마지막 로그인

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    LocalDateTime lastServiceDate;	// 마지막 서비스 제공일
}
