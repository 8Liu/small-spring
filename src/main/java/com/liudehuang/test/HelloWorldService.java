package com.liudehuang.test;

/**
 * @author liudehuang
 * @date 2019/3/24 10:50
 */
public class HelloWorldService {

    private String text;

    private Hello hello;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Hello getHello() {
        return hello;
    }

    public void setHello(Hello hello) {
        this.hello = hello;
    }


    public void helloWorld(){
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "HelloWorldService{" +
                "text='" + text + '\'' +
                ", hello=" + hello +
                '}';
    }
}
