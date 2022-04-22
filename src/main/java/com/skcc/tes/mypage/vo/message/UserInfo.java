package com.skcc.tes.mypage.vo.message;

import com.skcc.tes.mypage.vo.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 사용자 정보가 Update 되었을 때, Message를 통해 my-page 서비스로 들어오는 정보
 * @userId
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {

    private String userId;
    private String name;
    private Address address;

}
