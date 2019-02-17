package sym.impl;

import com.sym.entity.UserBean;
import com.sym.service.UserServiceI;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 沈燕明 on 2019/1/16.
 */
@Service
public class UserServiceImpl implements UserServiceI {

    private Map<Integer, UserBean> dataMap = new HashMap<>();

    public UserServiceImpl() {
        dataMap.put(1, new UserBean(1, "张三", "542569","database-8003"));
        dataMap.put(2, new UserBean(2, "李四", "542569","database-8003"));
        dataMap.put(3, new UserBean(3, "王五", "542569","database-8003"));
        dataMap.put(4, new UserBean(4, "赵六", "542569","database-8003"));
        dataMap.put(5, new UserBean(5, "孙七", "542569","database-8003"));
    }

    @Override
    public UserBean getUserById(int UserId) {
        return dataMap.get(UserId);
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
