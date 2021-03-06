package com.sym.feign.config;

import com.sym.entity.UserBean;
import com.sym.feign.service.FeignService;
import feign.hystrix.FallbackFactory;

import java.util.List;

/**
 * Feign + Hystrix, 降级处理
 *
 * @author shenyanming
 * @date 2019/10/12
 */
public class FeignFallbackFactory implements FallbackFactory<FeignService> {

    @Override
    public FeignService create(Throwable cause) {

        return new FeignService() {
            @Override
            public UserBean getUserById(int userId) {
                return new UserBean(1, "error", "error", "出错了~");
            }

            @Override
            public List<UserBean> getUserList() {
                return null;
            }

            @Override
            public UserBean error() {
                return new UserBean(1, "error", "error", "出错了~");
            }
        };
    }
}
