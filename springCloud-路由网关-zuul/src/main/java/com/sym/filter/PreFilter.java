package com.sym.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.util.RequestUtils;
import org.springframework.stereotype.Component;

/**
 * 继承 ZuulFilter抽象类 来实现zuul的过滤功能。在Zuul中有4种filter类型可以选：
 * 1.pre，此过滤器在请求被路由之前被调用
 * 2.routing，此过滤器将请求路由到微服务
 * 3.post，此过滤器在路由到微服务之后被调用
 * 4.error，前3个过滤器发生错误时执行此过滤器
 * <p>
 * Created by 沈燕明 on 2019/3/12.
 */
@Component
@Slf4j
public class PreFilter extends ZuulFilter {

    /**
     * filterType()返回的值表示此过滤器是什么类型的过滤器
     * zuul在将请求转发到微服务之前会调用pre类型的过滤器。
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 定义过滤器的执行顺序，数值越小优先级越高，越快执行
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断此过滤器是否要执行，若返回true则过滤器会执行(意味着执行run()方法)
     * 否则过滤器不执行，就不会执行run()方法
     */
    @Override
    public boolean shouldFilter() {
        // 默认这边都是返回true，都执行
        return true;
    }

    /**
     * 过滤器执行的逻辑
     */
    @Override
    public Object run() throws ZuulException {
        // RequestContext是一次完整的zuul请求的上下文
        RequestContext ctx = RequestContext.getCurrentContext();
        // RequestUtils获取当前request几个状态的工具类
        RequestUtils.isDispatcherServletRequest();
        log.info("pre过滤器在此执行了....");
        return null;
    }
}
