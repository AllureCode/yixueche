package yixue.che.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import yixue.che.bean.User;
import yixue.che.service.IUserService;
import yixue.che.util.Resp;

/**
 * @author xianhu
 * @description
 * @date 2023年02月09日 22:36
 */

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/login")
    public Resp<User> userLogin(@RequestParam("username")String username,
                                @RequestParam("password")String password){
       return userService.login(username,password);
    }
}
