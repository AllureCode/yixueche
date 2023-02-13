package yixue.che.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * @author xianhu
 * @description
 * @date 2023年02月09日 22:36
 */
@Data
@Setter
@Getter
public class User {
    private Integer id;
    private String username;
    private String password;
    private String iphone;
    private String nickName;
    private String birthday;
    private Integer province;
    private Integer status;
    private Timestamp gmtCreate;
    private Timestamp gmtModify;
}
