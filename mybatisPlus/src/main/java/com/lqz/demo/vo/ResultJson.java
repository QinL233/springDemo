package com.lqz.demo.vo;

import java.io.Serializable;

/**
 * @author LiaoQinZhou
 * @date: 2021/2/4 11:02
 */
public class ResultJson implements Serializable {

    /**
     * 状态码
     */
    private int code;
    /**
     * 消息
     */
    private String msg;
    /**
     * 数据
     */
    private Object data;

    /**
     * 执行成功
     */
    public static Object ok() {
        return new ResultJson();
    }

    /**
     * 执行成功
     *
     * @param data 返回数据
     */
    public static Object ok(Object data) {
        return new ResultJson(data);
    }

    /**
     * 执行失败
     *
     * @param code 返回码
     * @param msg  消息
     */
    public static Object err(int code, String msg) {
        return new ResultJson(code, msg);
    }

    /**
     * 执行失败
     *
     * @param RsCode 返回码（枚举）
     */
    public static Object err(ResultCode RsCode) {
        return err(RsCode.getCode(), RsCode.getMsg());
    }

    /**
     * 执行失败
     *
     * @param code 返回码
     * @param msg  消息
     * @param data 返回数据
     */
    public static Object err(int code, String msg, Object data) {
        return new ResultJson(code, msg, data);
    }

    public ResultJson() {
        this.code = ResultCode.SUCCESS.getCode();
        this.msg = ResultCode.SUCCESS.getMsg();
    }

    public ResultJson(Object data) {
        this.code = ResultCode.SUCCESS.getCode();
        this.msg = ResultCode.SUCCESS.getMsg();
        this.data = data;
    }

    public ResultJson(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultJson(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}