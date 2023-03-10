package yixue.che.service;

import yixue.che.bean.User;
import yixue.che.util.Resp;

import java.util.List;

public interface IUserService {
    Resp<User> login(String username, String password);


    /**
     * 查询总记录数
     */
    long count() throws Exception;

    /**
     * 根据页面查询
     * @param currentPage 当前页面
     * @param pageSize  当前页面有多少数据
     * @param query   查询条件
     * @return
     * @throws Exception
     */
    List<User> findByPage(int currentPage, int pageSize, String query);

    /**
     * 根据id查询用户
     * @param id
     * @return
     * @throws Exception
     */
    User findById(Integer id)throws  Exception;

    /**
     * 根据用户名查询用户
     * @param userName
     * @return
     * @throws Exception
     */
    User findByUserName(String userName)throws Exception;

    /**
     * 保存用户
     * @param user
     * @throws Exception
     */
    void save(User user)throws Exception;

    /**
     * 更新用户
     * @param user
     * @throws Exception
     */
    void update(User user)throws Exception;

    /**
     * 根据id删除用户
     * @param id
     * @throws Exception
     */
    void deleteByid(Integer id)throws Exception;

    long state1count();

    long state2count();

    Resp<User> register(User user);
}
