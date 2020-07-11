package com.sym.properties;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * Hystrix的配置参数, 官方文档：https://github.com/Netflix/Hystrix/wiki/Configuration.
 * 通过注解的{@link HystrixCommand#commandProperties()}指定
 *
 * @author shenyanming
 * Created on 2020/7/11 17:25
 */
public class HystrixCommandPropertiesConstants {
    public static final String EXECUTION_ISOLATION_STRATEGY = "execution.isolation.strategy";
    public static final String EXECUTION_ISOLATION_THREAD_TIMEOUT_IN_MILLISECONDS = "execution.isolation.thread.timeoutInMilliseconds";
    public static final String EXECUTION_TIMEOUT_ENABLED = "execution.timeout.enabled";
    public static final String EXECUTION_ISOLATION_THREAD_INTERRUPT_ON_TIME_OUT = "execution.isolation.thread.interruptOnTimeout";
    public static final String EXECUTION_ISOLATION_THREAD_INTERRUPT_ON_CANCEL = "execution.isolation.thread.interruptOnCancel";
    public static final String EXECUTION_ISOLATION_SEMAPHORE_MAX_CONCURRENT_REQUESTS = "execution.isolation.semaphore.maxConcurrentRequests";
    public static final String FALLBACK_ISOLATION_SEMAPHORE_MAX_CONCURRENT_REQUESTS = "fallback.isolation.semaphore.maxConcurrentRequests";
    public static final String FALLBACK_ENABLED = "fallback.enabled";
    public static final String CIRCUIT_BREAKER_ENABLED = "circuitBreaker.enabled";
    public static final String CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD = "circuitBreaker.requestVolumeThreshold";
    public static final String CIRCUIT_BREAKER_SLEEP_WINDOW_IN_MILLISECONDS = "circuitBreaker.sleepWindowInMilliseconds";
    public static final String CIRCUIT_BREAKER_ERROR_THRESHOLD_PERCENTAGE = "circuitBreaker.errorThresholdPercentage";
    public static final String CIRCUIT_BREAKER_FORCE_OPEN = "circuitBreaker.forceOpen";
    public static final String CIRCUIT_BREAKER_FORCE_CLOSED = "circuitBreaker.forceClosed";
    public static final String METRICS_ROLLING_STATS_TIME_IN_MILLISECONDS = "metrics.rollingStats.timeInMilliseconds";
    public static final String METRICS_ROLLING_STATS_NUM_BUCKETS = "metrics.rollingStats.numBuckets";
    public static final String METRICS_ROLLING_PERCENTILE_ENABLED = "metrics.rollingPercentile.enabled";
    public static final String METRICS_ROLLING_PERCENTILE_TIME_IN_MILLISECONDS = "metrics.rollingPercentile.timeInMilliseconds";
    public static final String METRICS_ROLLING_PERCENTILE_NUM_BUCKETS = "metrics.rollingPercentile.numBuckets";
    public static final String METRICS_ROLLING_PERCENTILE_BUCKET_SIZE = "metrics.rollingPercentile.bucketSize";
    public static final String METRICS_HEALTH_SNAPSHOT_INTERVAL_IN_MILLISECONDS = "metrics.healthSnapshot.intervalInMilliseconds";
    public static final String REQUEST_CACHE_ENABLED = "requestCache.enabled";
    public static final String REQUEST_LOG_ENABLED = "requestLog.enabled";
}
