package yixue.che.constant;

public enum YiXueCheConstant {


    REGISTER_FAIL_EXIT(400,"注册失败,用户存在");

    private int code;
    private String message;

    YiXueCheConstant(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
