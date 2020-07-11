package com.sym.config.feign;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Feign支持通过指定spring配置类来更改它默认的配置
 *
 * @author shenyanming
 * Created on 2020/7/11 17:12
 */
@Configuration
public class FeignLogConfig {
    /**
     * 日志级别
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
