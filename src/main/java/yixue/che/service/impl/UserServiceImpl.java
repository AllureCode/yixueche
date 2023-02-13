package yixue.che.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yixue.che.bean.User;
import yixue.che.constant.YiXueCheConstant;
import yixue.che.mapper.IUserMapper;
import yixue.che.service.IUserService;
import yixue.che.util.Resp;
import yixue.che.util.Tools;

import java.util.ArrayList;
import java.util.List;

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
            User userName = userMapper.findByUserName(username);
            if (userName == null) {
                return Resp.fail(null, null, 404);
            }
            User user = userMapper.login(username, password);
            if (user != null) {
                return Resp.ok(user, "");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Resp.fail(null, null, 500);
    }

    @Override
    public long count() throws Exception {
        return userMapper.count();
    }

    @Override
    public List<User> findByPage(int currentPage, int pageSize, String query) {
        List<User> list = new ArrayList<User>();
        PageHelper.startPage(currentPage, pageSize);
        if (!Tools.isEmpty(query)) {
            list = userMapper.findListByQuery("%" + query + "%");
        } else {
            list = userMapper.findList();
        }
        PageInfo<User> pageInfo = new PageInfo<User>(list);
        return pageInfo.getList();
    }

    @Override
    public User findById(Integer id) throws Exception {
        return userMapper.findById(id);
    }

    @Override
    public User findByUserName(String userName) throws Exception {
        return null;
    }

    @Override
    public void save(User user) throws Exception {

    }

    @Override
    public void update(User user) throws Exception {

    }

    @Override
    public void deleteByid(Integer id) throws Exception {

    }

    @Override
    public long state1count() {
        return 0;
    }

    @Override
    public long state2count() {
        return 0;
    }

    @Override
    public Resp<User> register(User user) {
        User object = userMapper.findByUserName(user.getUsername());
        if (object != null) {
            return Resp.fail(null, YiXueCheConstant.REGISTER_FAIL_EXIT.getMessage(), YiXueCheConstant.REGISTER_FAIL_EXIT.getCode());
        }
        userMapper.save(user);
        return Resp.ok();
    }
}
