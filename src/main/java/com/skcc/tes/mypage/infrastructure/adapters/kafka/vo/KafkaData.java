package com.skcc.tes.mypage.infrastructure.adapters.kafka.vo;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class KafkaData {
    private String eventType;
    private Long timestamp;
}
