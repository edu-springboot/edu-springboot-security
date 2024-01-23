package com.nhnacademy.edu.springboot.student.management;


import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
@Endpoint(id="counter")
public class CounterEndpoint {
    private final AtomicLong count = new AtomicLong(0L);

    @ReadOperation
    public Long read() {
        return count.get();
    }

    @WriteOperation
    public Long increment(Long delta) {
        if ( delta == null) {
            return count.incrementAndGet();
        }

        return count.addAndGet(delta);
    }

    @DeleteOperation
    public Long reset() {
        count.set(0L);
        return count.get();
    }

}
