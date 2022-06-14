package com.skcc.tes.mypage.application.config;

import com.skcc.tes.mypage.domain.ports.api.MypageServiceImpl;
import com.skcc.tes.mypage.domain.ports.api.MypageServicePort;
import com.skcc.tes.mypage.domain.ports.spi.MyStatusPersistencePort;
import com.skcc.tes.mypage.infrastructure.adapters.jpa.MyStatusJpaAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyPageConfig {
    @Bean
    public MyStatusPersistencePort myStatusPersistence(){
        return new MyStatusJpaAdapter();
    }

    @Bean
    public MypageServicePort myPageService() {
        return new MypageServiceImpl(myStatusPersistence());
    }
}
