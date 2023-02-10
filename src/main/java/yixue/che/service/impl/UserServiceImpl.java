package yixue.che.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yixue.che.bean.User;
import yixue.che.mapper.IUserMapper;
import yixue.che.service.IUserService;
import yixue.che.util.Resp;

/**
 * @description
 * @date 2023年02月09日 22:45
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserMapper userMapper;

    @Override
    public Resp<User> login(String username, String password) {

        try {
            User user = userMapper.login(username, password);

            if (user != null) {
                return Resp.ok(user,"");
            }
            return Resp.fail(null,null,404);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Resp.fail(null,null,500);
    }
}
