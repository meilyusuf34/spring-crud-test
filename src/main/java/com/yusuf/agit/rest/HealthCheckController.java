package com.yusuf.agit.rest;

import com.yusuf.agit.common.BuildResponseUtil;
import com.yusuf.agit.dto.BaseResponse;
import com.yusuf.agit.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthCheckController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping(value = "/check")
    public BaseResponse<String> check() {
        return BuildResponseUtil.success("Success.");
    }

    @GetMapping(value = "/check-db")
    public BaseResponse<String> checkDb() {
        try {
            return BuildResponseUtil.success("Database Current Timestamp : " + bookRepository.dBServerTime());
        } catch (Exception e) {
            e.printStackTrace();
            return BuildResponseUtil.error("DB CHECK FAILED.");
        }
    }

}
