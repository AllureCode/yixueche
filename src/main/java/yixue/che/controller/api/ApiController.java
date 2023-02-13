package yixue.che.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import yixue.che.bean.User;
import yixue.che.service.BannerService;
import yixue.che.service.IUserService;
import yixue.che.util.Resp;

/**
 * @author xianhu
 * @description
 * @date 2023年02月09日 22:36
 */

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private IUserService userService;
    @Autowired
    private BannerService bannerService;

    @RequestMapping("/banner")
    public Resp bannerManage(){
        return bannerService.queryBannerList();
    }
    /**
     * 登陆
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/login")
    public Resp<User> userLogin(@RequestParam("username") String username,
                                @RequestParam("password") String password) {
        return userService.login(username, password);
    }

    /**
     * 注册
     * @param username
     * @param password
     * @param province
     * @param birthday
     * @param nickName
     * @param iphone
     * @return
     */
    @RequestMapping("/register")
    public Resp<User> register(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               @RequestParam("index") String province,
                               @RequestParam("date") String birthday,
                               @RequestParam("nickname") String nickName,
                               @RequestParam("iphone") String iphone) {
        User user = new User();
        user.setBirthday(birthday);
        user.setIphone(iphone);
        user.setUsername(username);
        user.setNickName(nickName);
        user.setProvince(Integer.parseInt(province)+1);
        user.setPassword(password);
        return userService.register(user);
    }
}
