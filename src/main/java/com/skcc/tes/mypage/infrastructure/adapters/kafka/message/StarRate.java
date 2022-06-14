package com.skcc.tes.mypage.infrastructure.adapters.kafka.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * comment가 수정/삭제 되었을 때, Message를 통해 my-page 서비스로 들어오는 정보
 * @userId
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StarRate {
    private StarRateEvent status;
    private Long starRateId;
    private Double previousRate;
    private Double updatedRate;
}
