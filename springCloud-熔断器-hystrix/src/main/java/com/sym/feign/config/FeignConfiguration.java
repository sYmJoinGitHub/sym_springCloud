package com.sym.feign.config;

import feign.Request;
import feign.Retryer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * feign配置
 *
 * @author shenyanming
 * Created on 2020/5/16 17:07
 */
@Configuration
public class FeignConfiguration {
    @Value("${feign.never-retry.connectTimeoutMillis:1000}")
    private Integer connectTimeoutMillis;
    @Value("${feign.never-retry.readTimeoutMillis:1000}")
    private Integer readTimeoutMillis;

    public FeignConfiguration() {
    }

    @Bean
    public Retryer feignNeverRetryer() {
        return Retryer.NEVER_RETRY;
    }

    @Bean
    Request.Options feignNeverRetryOptions() {
        return new Request.Options(this.connectTimeoutMillis, this.readTimeoutMillis);
    }
}