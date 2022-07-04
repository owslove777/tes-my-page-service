package com.skcc.tes.mypage.application.controller;


import com.skcc.tes.mypage.domain.data.MyStatusDto;
import com.skcc.tes.mypage.domain.ports.api.MypageServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.OPTIONS})
public class MyPageController {
    private final MypageServicePort mypageService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World! This is My Page Service";
    }

    // Create
    @PostMapping("/mypage")
    public MyStatusDto createNewUserInfo(@RequestBody MyStatusDto src) {
        src.setId(src.getUserId());
        MyStatusDto saved = mypageService.save(src);
        return saved;
    }

    // Select All
    @GetMapping("/mypages")
    public List<MyStatusDto> getMypages() {
        List<MyStatusDto> list = mypageService.findAll();
        return list;
    }

    // Select By ID
    @GetMapping("/mypage/{id}")
    public MyStatusDto getMyPageById(@PathVariable Long id) {
        MyStatusDto myStatus = mypageService.findById(id);
        return myStatus;
    }

    // Select By User ID
    @GetMapping("/mypage/user/{id}")
    public MyStatusDto getMyPageByUserId(@PathVariable Long id) {
        MyStatusDto myStatus = mypageService.findByUserId(id);
        return myStatus;
    }
}
