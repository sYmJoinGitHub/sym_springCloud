package com.sym.service.impl;

import com.sym.entity.UserBean;
import com.sym.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author shenyanming
 * @date 2019/1/16
 */
@Service
public class UserServiceImpl implements IUserService {

    private Map<Integer, UserBean> dataMap = new HashMap<>();

    public UserServiceImpl() {
        dataMap.put(1, new UserBean(1, "曹操", "520", "database-8001"));
        dataMap.put(2, new UserBean(2, "郭嘉", "520", "database-8001"));
        dataMap.put(3, new UserBean(3, "荀彧", "520", "database-8001"));
        dataMap.put(4, new UserBean(4, "许褚", "520", "database-8001"));
        dataMap.put(5, new UserBean(5, "典韦", "520", "database-8001"));
    }

    @Override
    public UserBean getUserById(int userId) {
        return dataMap.get(userId);
    }

    @Override
    public List<UserBean> getUserList() {
        List<UserBean> retList = new ArrayList<>(dataMap.size());
        for (Map.Entry<Integer, UserBean> entry : dataMap.entrySet()) {
            retList.add(entry.getValue());
        }
        return retList;
    }
}
