package com.skcc.tes.mypage.infrastructure.adapters.kafka.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StarRateCreatedVo extends KafkaData {
    private String status; // created
    private Long starRateId;
    private Double rate;
    private String comment;
    private Long talentId;
    private String title;   // 재능명
    private Long requestUserId; // 요청자 ID
    private Long sellerId;      // 재능인 ID
}