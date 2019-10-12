package com.sym.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Created by 沈燕明 on 2019/1/16.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UserBean {
    private int userId;
    private String userName;
    private String password;
    private String database; // 此数据存放在哪个数据库上
}
