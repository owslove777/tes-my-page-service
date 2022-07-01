package com.skcc.tes.mypage.domain.ports.spi;


import com.skcc.tes.mypage.domain.data.MyStatusDto;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface MyStatusPersistencePort {
    MyStatusDto findById(Long id);

    MyStatusDto findByUserId(Long userId);

    MyStatusDto save(MyStatusDto src);

    List<MyStatusDto> findAll(Sort userId);
}
