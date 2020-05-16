package com.sym.service;

import com.sym.entity.UserBean;

import java.util.List;

/**
 * @author shenyanming
 * Created on 2020/5/16 17:31
 */
public interface IUserService {

    UserBean getUserById(int userId);

    List<UserBean> getUserList();
}
