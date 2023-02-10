package yixue.che.service;

import yixue.che.bean.User;
import yixue.che.util.Resp;

public interface IUserService {
    Resp<User> login(String username, String password);
}
