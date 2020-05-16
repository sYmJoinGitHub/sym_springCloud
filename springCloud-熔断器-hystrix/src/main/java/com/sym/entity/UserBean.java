package com.sym.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author shenyanming
 * Created on 2020/5/16 17:07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UserBean {
    private int userId;
    private String userName;
    private String password;
    /**
     * 此数据存放在哪个数据库上
     */
    private String database;
}
