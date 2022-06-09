package com.skcc.tes.mypage.infrastructure.adapters.kafka;

import com.skcc.tes.mypage.infrastructure.adapters.kafka.KafkaProcessor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    // 카프카 이슈 해결 완료
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){
        System.out.println("eventString = " + eventString);
    }
}