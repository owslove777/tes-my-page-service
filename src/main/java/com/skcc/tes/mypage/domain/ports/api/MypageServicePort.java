package com.skcc.tes.mypage.domain.ports.api;

import com.skcc.tes.mypage.domain.data.MyStatusDto;
import com.skcc.tes.mypage.infrastructure.adapters.kafka.vo.ContractReservedKafkaVo;
import com.skcc.tes.mypage.infrastructure.adapters.kafka.vo.ContractUpdatedVo;
import com.skcc.tes.mypage.infrastructure.adapters.kafka.vo.UserCreatedVo;

import java.util.List;

public interface MypageServicePort {
    MyStatusDto findById(Long id);

    MyStatusDto findByUserId(Long id);

    MyStatusDto save(MyStatusDto src);

    List<MyStatusDto> findAll();

    MyStatusDto createUserFromMessage(UserCreatedVo src);

    MyStatusDto processNewContract(ContractReservedKafkaVo src);

    void updateContract(ContractUpdatedVo contractUpdatedVo);
}
