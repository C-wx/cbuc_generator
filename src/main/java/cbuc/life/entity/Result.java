package cbuc.life.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: Caiwx
 * @Date: Create in 10:36 2020-06-18
 * @Description:
 */
public class Result<T> implements Serializable {

    public static final String SUCCESS = "SUCCESS";

    public static final String FAIL = "FAIL";

    public static final String LOGOUT = "LOGOUT";

    public static final String ERROR_MSG = "服务器异常请稍后再试.";

    /**
     * 数据
     */
    private T data;
    /**
     * 信息
     */
    private String message;
    /**
     * 返回结果
     */
    private String code = "SUCCESS";


    /**
     * 返回成功结果
     *
     * @param data 返回数据
     */
    public Result sendOk(T data) {
        Result result = new Result();
        result.setData(data);
        result.setMessage("操作成功");
        return result;
    }

    /**
     * 返回成功消息
     */
    public Result sendOk() {
        Result result = new Result();
        result.setMessage("操作成功");
        return result;
    }


    /**
     * 返回错误结果
     */
    public Result sendError() {
        Result result = new Result();
        result.setMessage("操作失败");
        return result;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}

