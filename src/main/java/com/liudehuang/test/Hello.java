package com.liudehuang.test;

/**
 * @author liudehuang
 * @date 2019/3/24 17:41
 */
public class Hello {
    private String mesg;

    private String code;

    public String getMesg() {
        return mesg;
    }

    public void setMesg(String mesg) {
        this.mesg = mesg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "mesg='" + mesg + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
