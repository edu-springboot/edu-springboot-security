package com.nhnacademy.edu.springboot.student.management;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.boot.actuate.endpoint.web.WebEndpointResponse;
import org.springframework.boot.actuate.endpoint.web.annotation.EndpointWebExtension;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
@EndpointWebExtension(endpoint = CounterEndpoint.class)
public class CounterWebEndpoint {

    private final CounterEndpoint target;


    public CounterWebEndpoint(CounterEndpoint target) {
        this.target = target;
    }
    @WriteOperation
    public WebEndpointResponse<Long> increment(Long delta) {
        return new WebEndpointResponse<>(target.increment(delta));
    }
}
