package com.redis.crud.web.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HealthCheckDto {
    private final String status = "UP";
}
