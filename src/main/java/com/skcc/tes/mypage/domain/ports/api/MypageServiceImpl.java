package com.skcc.tes.mypage.domain.ports.api;

import com.skcc.tes.mypage.domain.data.MyStatusDto;
import com.skcc.tes.mypage.domain.ports.spi.MyStatusPersistencePort;
import com.skcc.tes.mypage.infrastructure.adapters.kafka.vo.ContractReservedKafkaVo;
import com.skcc.tes.mypage.infrastructure.adapters.kafka.vo.ContractUpdatedVo;
import com.skcc.tes.mypage.infrastructure.adapters.kafka.vo.UserCreatedVo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
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

    @Override
    public MyStatusDto createUserFromMessage(UserCreatedVo src) {
        MyStatusDto newUser = MyStatusDto.builder()
                .userId(src.getUserId())
                .name(src.getUserNm())
                .userRequestCntDone(0L)
                .userRequestCntTotal(0L)
                .lastServiceDate(LocalDateTime.now())
                .myServiceCnt(.0)
                .myServiceRate(.0)
                .myRequestCntDone(0L)
                .myRequestCntTotal(0L)
                .build();
        return save(newUser);
    }

    @Override
    @Transactional
    public MyStatusDto processNewContract(ContractReservedKafkaVo src) {
        if (src == null) {
            return null;
        }
        Long requestUserId = src.getContractDto().getUserId();
        Long talentUserID = src.getContractDto().getTalentUserId();

        MyStatusDto requestUser = findById(requestUserId);
        requestUser.setLastServiceDate(LocalDateTime.now());
        requestUser.setMyRequestCntTotal(requestUser.getMyRequestCntTotal() + 1);

        MyStatusDto talentUser = findById(talentUserID);
        talentUser.setUserRequestCntTotal(talentUser.getUserRequestCntTotal() + 1);

        save(talentUser);
        return save(requestUser);
    }

    @Override
    @Transactional
    public void updateContract(ContractUpdatedVo src) {
        if (src == null) {
            return;
        }
        Long requestUserId = src.getContractDto().getUserId();
        Long talentUserID = src.getContractDto().getTalentUserId();
        MyStatusDto requestUser = findById(requestUserId);
        MyStatusDto talentUser = findById(talentUserID);

        String status = src.getContractDto().getContractStatus(); // BEFORE_CONTRACT, ACCEPT_REQUESTED, ACCEPTED, REJECTED, PERFORMED, NOT_PERFORMED
        switch (status) {
            case "PERFORMED": // 완료 건수 카운트 ++
                requestUser.setMyRequestCntDone(requestUser.getMyRequestCntDone() + 1);
                talentUser.setUserRequestCntDone(talentUser.getUserRequestCntDone() + 1);
                save(requestUser);
                save(talentUser);
                break;
            case "REJECTED": // 진행중 건수 카운트 --
            case "NOT_PERFORMED":
                requestUser.setMyRequestCntTotal(requestUser.getMyRequestCntTotal() - 1);
                talentUser.setUserRequestCntTotal(talentUser.getUserRequestCntTotal() - 1);
                save(requestUser);
                save(talentUser);
                break;
            default:
                break;
        }
    }
}
