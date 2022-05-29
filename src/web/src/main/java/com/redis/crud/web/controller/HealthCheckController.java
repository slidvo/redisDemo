package com.redis.crud.web.controller;

import com.redis.crud.web.dto.HealthCheckDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HealthCheckController {

    @GetMapping("health")
    public HealthCheckDto healthCheck() {
        return new HealthCheckDto();
    }
}
