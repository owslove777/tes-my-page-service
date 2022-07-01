package com.skcc.tes.mypage.infrastructure.repository;

import com.skcc.tes.mypage.infrastructure.entity.MyStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MyStatusRepository extends JpaRepository<MyStatus, Long>{

    Optional<MyStatus> findByUserId(Long userId);
}
