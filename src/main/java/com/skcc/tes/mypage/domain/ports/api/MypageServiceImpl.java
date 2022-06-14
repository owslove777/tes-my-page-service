package com.skcc.tes.mypage.domain.ports.api;

import com.skcc.tes.mypage.domain.data.MyStatusDto;
import com.skcc.tes.mypage.domain.ports.spi.MyStatusPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;

import java.util.List;

@RequiredArgsConstructor
public class MypageServiceImpl implements MypageServicePort{

    private final MyStatusPersistencePort mypagePersistence;

    @Override
    public MyStatusDto findById(Long id) {
        return mypagePersistence.findById(id);
    }

    @Override
    public MyStatusDto save(MyStatusDto src) {
        return mypagePersistence.save(src);
    }

    @Override
    public List<MyStatusDto> findAll() {
        return mypagePersistence.findAll(Sort.by(Sort.Direction.ASC, "userId"));
    }
}
