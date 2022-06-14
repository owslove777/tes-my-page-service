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
        return "Hello, World! This is Star Rate Service";
    }

    // Create
    @PostMapping("/mypage")
    public MyStatusDto createNewStarRate(@RequestBody MyStatusDto src) {
        src.setId(null);
        MyStatusDto saved = mypageService.save(src);
        return saved;
    }

    // Select All
    @GetMapping("/mypages")
    public List<MyStatusDto> getAllStarRates() {
        List<MyStatusDto> list = mypageService.findAll();
        return null;
    }

    // Select By ID
    @GetMapping("/mypage/{id}")
    public MyStatusDto getStarRateById(@PathVariable Long id) {
        MyStatusDto myStatus = mypageService.findById(id);
        return myStatus;
    }
}
