package yixue.che.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Data
@Getter
@Setter
@ToString
public class Province implements Serializable {
    private Long provice;

    private String count;
}
