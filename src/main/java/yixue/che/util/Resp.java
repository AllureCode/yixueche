package yixue.che.util;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class Resp<T> implements Serializable {

    private Integer code;
    private String message;
    private Boolean success;
    private T data;

    public Resp(T data, String message) {
        this.code = 200;
        this.message = message;
        this.data = data;
        this.success = true;
    }

    public Resp() {
        this.code = 200;
        this.success = true;
    }

    public Resp(T data, String message, Boolean success, Integer code) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.success = success;
    }

    /**
     * 成功结果集
     *
     * @param data
     * @param message
     * @param <T>
     * @return
     */
    public static <T> Resp<T> ok(T data, String message) {
        return new Resp<>(data, message);
    }
    public static <T> Resp<T> ok() {
        return new Resp<>();
    }
    public static <T> Resp<T> fail(T data, String message) {
        return new Resp<>(data, message, false, 502);
    }

    public static <T> Resp<T> fail(T data, String message, Integer code) {
        return new Resp<>(data, message, false, code);
    }
    public static <T> Resp<T> result(T data, String message,Boolean success, Integer code) {
        return new Resp<>(data, message, success, code);
    }
}
