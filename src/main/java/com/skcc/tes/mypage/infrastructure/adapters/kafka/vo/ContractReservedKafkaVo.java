package com.skcc.tes.mypage.infrastructure.adapters.kafka.vo;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContractReservedKafkaVo extends KafkaData {
    private ContractDto contractDto;
}

