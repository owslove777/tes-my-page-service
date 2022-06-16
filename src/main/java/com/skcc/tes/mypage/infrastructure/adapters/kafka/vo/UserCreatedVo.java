package com.skcc.tes.mypage.infrastructure.adapters.kafka.vo;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreatedVo extends KafkaData {
    private String userId;
    private String userNm;
    private String status;
}
