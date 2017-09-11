package com.example.materialdialogtest;

/**
 * Created by Yuki on 2017/9/7 0007.
 */

public class TestBean {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
