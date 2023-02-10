package yixue.che.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@Setter
@Getter
public class Admin implements Serializable {
    private Integer id;
    private String userName;

    private String password;

    private String name;

    private String linkTel;

    private Integer state;
}
