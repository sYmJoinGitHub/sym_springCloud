package com.sym.feign;

import com.sym.entity.UserBean;
import feign.hystrix.FallbackFactory;

import java.util.List;

/**
 * Created by shenym on 2019/10/12.
 */
public class FeignFallbackFactory implements FallbackFactory<FeignService> {

    @Override
    public FeignService create(Throwable cause) {

        return new FeignService() {
            @Override
            public UserBean getUserById(int UserId) {
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
