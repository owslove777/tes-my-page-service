package com.skcc.tes.mypage.infrastructure.adapters.kafka.vo;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreatedVo extends KafkaData {
    private Long userId;
    private String userNm;
    private String status;
}
