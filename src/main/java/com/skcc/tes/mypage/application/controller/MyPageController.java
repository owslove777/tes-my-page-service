package com.skcc.tes.mypage.application.controller;


import com.skcc.tes.mypage.infrastructure.entity.MyStatus;
import com.skcc.tes.mypage.infrastructure.repository.MyStatusRepository;
import com.skcc.tes.mypage.domain.data.MyStatusDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.OPTIONS})
public class MyPageController {
    private final MyStatusRepository repository;

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World! This is Star Rate Service";
    }

    // Create
    @PostMapping("/mypage")
    public MyStatusDto createNewStarRate(@RequestBody MyStatus src) {
        src.setId(null);
        MyStatus saved = repository.save(src);
        return saved.toDto();
    }

    // Select All
    @GetMapping("/mypages")
    public List<MyStatusDto> getAllStarRates() {
        return repository.findAll().stream().map(MyStatus::toDto).collect(Collectors.toList());
    }

    // Select By ID
    @GetMapping("/mypage/{id}")
    public MyStatusDto getStarRateById(@PathVariable Long id) {
        Optional<MyStatus> byId = repository.findById(id);
        return byId.map(MyStatus::toDto).orElse(null);
    }
}
