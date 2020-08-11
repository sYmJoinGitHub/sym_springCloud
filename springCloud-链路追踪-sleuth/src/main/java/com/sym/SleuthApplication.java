package com.sym;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 服务追踪的追踪单元是从客户发起请求（request）抵达被追踪系统的边界开始, 到被追踪系统向客户返回响应（response）为止的过程, 称为一个 trace;
 * 在一个 trace 中, 会调用多个服务, 在每次调用服务时, 埋入一个调用记录, 称为一个 span.
 * springCloud sleuth提供了链路追踪的功能:
 * - 耗时分析: 通过Sleuth可以很方便的了解到每个采样请求的耗时, 从而分析出哪些服务调用比较耗时;
 * - 可视化错误: 对于程序未捕捉的异常, 可以通过集成Zipkin服务界面上看到;
 * - 链路优化: 对于调用比较频繁的服务, 可以针对这些服务实施一些优化措施.
 *
 * @author shenyanming
 * Created on 2020/5/16 17:58
 */
@Slf4j
@SpringBootApplication
public class SleuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(SleuthApplication.class, args);
        log.info("服务启动~");
    }
}
