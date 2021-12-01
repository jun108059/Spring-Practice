package com.saramin.communication.controller.sample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    /**
     * API ping 테스트
     * @return 단순 String
     */
    @GetMapping("/ping")
    public String pingPong() {
        return "pong";
    }

}
