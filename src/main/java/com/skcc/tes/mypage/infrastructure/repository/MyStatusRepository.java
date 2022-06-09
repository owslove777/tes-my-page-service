package com.skcc.tes.mypage.infrastructure.repository;

import com.skcc.tes.mypage.infrastructure.entity.MyStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyStatusRepository extends JpaRepository<MyStatus, Long>{
    
}
