package com.skcc.tes.mypage.infrastructure.adapters.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.skcc.tes.mypage.domain.ports.api.MypageServicePort;
import com.skcc.tes.mypage.infrastructure.adapters.kafka.vo.ContractReservedKafkaVo;
import com.skcc.tes.mypage.infrastructure.adapters.kafka.vo.ContractUpdatedVo;
import com.skcc.tes.mypage.infrastructure.adapters.kafka.vo.StarRateCreatedVo;
import com.skcc.tes.mypage.infrastructure.adapters.kafka.vo.UserCreatedVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class PolicyHandler{

    private final MypageServicePort mypageService;
    private ObjectMapper mapper = new ObjectMapper();

    // 카프카 이슈 해결 완료
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){
        Map<String, String> map = parseToMap(eventString);
        if (map == null) {
            return;
        }

        switch (map.get("eventType")) {
            case "UserCreated": // 신규 사용자 생성 시
                log.info("## 신규 사용자 생성 이벤트 발생");
                UserCreatedVo userCreatedVo = parseToClass(eventString, UserCreatedVo.class);
                mypageService.createUserFromMessage(userCreatedVo);
                break;
            case "ContractReservedKafka": // 신규 계약 요청 시
                log.info("## 신규 계약 요청 이벤트 발생");
                ContractReservedKafkaVo contractReservedKafkaVo = parseToClass(eventString, ContractReservedKafkaVo.class);
                mypageService.processNewContract(contractReservedKafkaVo);
                // 재능인 정보에 신규 계약건 추가 (userRequestCntTotal++)
                // 요청자 정보에 신규 계약건 추가 (myRequestCntTotal++)
                break;
            case "ContractUpdated": // 계약 상태 업데이트 시
                log.info("## 계약 상태 업데이트 발생");
                ContractUpdatedVo contractUpdatedVo = parseToClass(eventString, ContractUpdatedVo.class);
                mypageService.updateContract(contractUpdatedVo);
                break;
            case "SettlementCreated":
                log.info("## 신규 정산 대상 발생");
                break;
            case "SettlementUpdated":
                log.info("## 정산 상태 업데이트 발생");
                break;
            case "StarRateCreated": // 별점 등록 시
                log.info("## 신규 별점 등록 발생");
                StarRateCreatedVo starRateCreatedVo = parseToClass(eventString, StarRateCreatedVo.class);
                mypageService.newRatingAdded(starRateCreatedVo);
                break;
            default:
                break;
        }
    }

    private <T> T parseToClass(String eventString, Class<T> clazz) {
        try {
            return mapper.readValue(eventString, clazz);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Map<String, String> parseToMap(String eventString) {
        Map<String, String> map = null;
        try {
            map = mapper.readValue(eventString, Map.class);
        } catch (JsonProcessingException e) {
            log.error(e.toString());
        }
        return map;
    }
}