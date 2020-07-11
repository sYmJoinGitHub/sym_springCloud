package com.sym;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Sentinel的官方文档：https://github.com/alibaba/Sentinel/wiki/%E4%BB%8B%E7%BB%8D,
 * Sentinel注解支持: https://github.com/alibaba/Sentinel/wiki/%E6%B3%A8%E8%A7%A3%E6%94%AF%E6%8C%81
 *
 * @author shenyanming
 * @date 2020/5/24 22:44.
 */
@SpringBootApplication
@Slf4j
public class SentinelApplication {
    public static void main(String[] args) {
        SpringApplication.run(SentinelApplication.class, args);
        log.info("服务启动成功");
    }
}
