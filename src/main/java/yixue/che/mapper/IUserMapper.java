package yixue.che.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import yixue.che.bean.User;

import java.util.List;

@Mapper
public interface IUserMapper {
    User login(@Param("username") String username, @Param("password") String password);

    long count();

    /**
     * 根据条件查询
     * @param query
     * @return
     */
    List<User> findListByQuery(@Param("query") String query);

    /**
     * 查询所有用户
     * @return
     */
    List<User> findList();

    User findByUserName(String username);

    void save(User user);

    User findById(Integer id);
}
