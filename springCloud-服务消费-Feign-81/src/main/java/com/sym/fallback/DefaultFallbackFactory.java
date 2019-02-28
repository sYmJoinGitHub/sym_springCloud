package com.sym.fallback;

import com.sym.entity.UserBean;
import com.sym.service.UserServiceI;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by 沈燕明 on 2019/2/28.
 */
@Component
public class DefaultFallbackFactory  implements FallbackFactory<UserServiceI> {
    @Override
    public UserServiceI create(Throwable cause) {
        return new UserServiceI() {
            @Override
            public UserBean getUserById(int UserId) {
                return new UserBean(1,"error","error","出错了~");
            }

            @Override
            public List<UserBean> getUserList() {
                return null;
            }
        };
    }
}
