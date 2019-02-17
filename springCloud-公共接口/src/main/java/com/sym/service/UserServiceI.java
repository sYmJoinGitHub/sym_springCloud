package com.sym.service;

import com.sym.entity.UserBean;

import java.util.List;

/**
 * Created by 沈燕明 on 2019/1/16.
 */
public interface UserServiceI {

    UserBean getUserById(int UserId);

    List<UserBean> getUserList();
}
