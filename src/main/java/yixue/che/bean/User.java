package yixue.che.bean;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author xianhu
 * @description
 * @date 2023年02月09日 22:36
 */
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer iphone;
    private String nickName;
    private String birthday;
    private Integer status;
    private Timestamp gmtCreate;
    private Timestamp gmtModify;
}
