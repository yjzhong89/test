package com.zyj.aop.test;

/**
 * @author zhongyj
 * @since 2021-05-17 16:11
 */
public enum TestEnum {
    MSG_STATUS(0, "未读");

    private Integer status;
    private String text;

    private TestEnum(Integer status, String text) {
        this.status = status;
        this.text = text;
    }

    public Integer getStatus() {
        return status;
    }

    public String getText() {
        return text;
    }
}
