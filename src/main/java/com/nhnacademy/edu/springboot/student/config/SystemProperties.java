package com.nhnacademy.edu.springboot.student.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;


@Getter
@Setter
@NoArgsConstructor
@ConfigurationProperties("com.nhn.account.system")
public class SystemProperties {
    private String version;
}
