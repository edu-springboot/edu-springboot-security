package com.nhnacademy.edu.springboot.student.management;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class MyHealthIndicator implements HealthIndicator {
    private final AtomicBoolean health = new AtomicBoolean(true);

    public void setHealth(boolean health) {
        this.health.set(health);
    }
    @Override
    public Health health() {
        if (health.get()) {
            return Health.up().build();
        }
        return Health.down()
                .withDetails(Map.of("reason", "by user request."))
                .build();
    }
}
