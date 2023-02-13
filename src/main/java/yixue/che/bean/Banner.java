package yixue.che.bean;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author xianhu
 * @description
 * @date 2023年02月12日 12:48
 */
@Data
public class Banner {
    private Integer id;
    private String title;
    private String remark;
    private String imgUrl;
    private String realImageUrl;
    private Integer status;
    private String imageData;
    private Timestamp gmtCreate;
    private Timestamp gmtModify;
}
