package com.wq.share.enums;

import com.wq.share.common.exception.BaseReturnType;
import lombok.Getter;

@Getter
public enum ReturnCode implements BaseReturnType {

    SUCCESS("100", "接口返回正常"),
    ILLEGAL_ARG_EXCEPTION("400", "请求参数异常"),
    NOT_FOUND_EXCEPTION("404", "请求接口不存在"),


    REMOTE_USER_EXCEPTION("601", "用户异常：{0}"),
    REMOTE_ITEM_EXCEPTION("610", "商品异常：{0}"),

    REMOTE_EXCEPTION("998", "远程调用系统异常"),
    SYSTEM_EXCEPTION("999", "系统异常");
    private String code;
    private String message;

    ReturnCode(String code, String message) {
        this.code = code;
        this.message = message;
    }



}
