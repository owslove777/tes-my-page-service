package com.skcc.tes.mypage.infrastructure.adapters.kafka.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContractDto {

    private Long id;
    private Long talentId;
    private Long talentItemId;
    private Long talentUserId;
    private String talentUserNm;
    private Long userId;
    private String userNm;
    private String title;
    private Long price;
    private String contractStatus; // BEFORE_CONTRACT, ACCEPT_REQUESTED, ACCEPTED, REJECTED, PERFORMED, NOT_PERFORMED
    private String address;
}