package com.skcc.tes.mypage.domain.ports.api;

import com.skcc.tes.mypage.domain.data.MyStatusDto;

import java.util.List;

public interface MypageServicePort {
    MyStatusDto findById(Long id);

    MyStatusDto save(MyStatusDto src);

    List<MyStatusDto> findAll();
}
