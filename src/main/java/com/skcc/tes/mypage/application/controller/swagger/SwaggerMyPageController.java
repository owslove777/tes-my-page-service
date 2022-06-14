package com.skcc.tes.mypage.application.controller.swagger;

import com.skcc.tes.mypage.application.controller.MyPageController;
import com.skcc.tes.mypage.domain.ports.api.MypageServicePort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mypage")
public class SwaggerMyPageController extends MyPageController {
    public SwaggerMyPageController(MypageServicePort mypageService) {
        super(mypageService);
    }
}
