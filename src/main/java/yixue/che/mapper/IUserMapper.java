package yixue.che.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import yixue.che.bean.User;

@Mapper
public interface IUserMapper {
    User login(@Param("username") String username, @Param("password") String password);
}
