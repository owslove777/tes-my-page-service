package com.skcc.tes.mypage.infrastructure.adapters.jpa;

import com.skcc.tes.mypage.domain.data.MyStatusDto;
import com.skcc.tes.mypage.domain.ports.spi.MyStatusPersistencePort;
import com.skcc.tes.mypage.infrastructure.entity.MyStatus;
import com.skcc.tes.mypage.infrastructure.repository.MyStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MyStatusJpaAdapter implements MyStatusPersistencePort {

    @Autowired
    private MyStatusRepository myStatusRepository;

    @Override
    public MyStatusDto findById(Long id) {
        Optional<MyStatus> byId = myStatusRepository.findById(id);
        return byId.map(MyStatus::toDto).orElse(null);
    }

    @Override
    public MyStatusDto save(MyStatusDto src) {
        MyStatus saved = myStatusRepository.save(MyStatus.parseFrom(src));
        return saved.toDto();
    }

    @Override
    public List<MyStatusDto> findAll(Sort userIdSort) {
        List<MyStatus> all = myStatusRepository.findAll(userIdSort);
        return all.stream().map(MyStatus::toDto).collect(Collectors.toList());
    }
}
