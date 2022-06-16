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
}
