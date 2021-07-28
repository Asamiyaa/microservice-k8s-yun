package com.dubbo;


import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class UserInfoSV implements UserInfoISV {
    @Override
    public String sayHello() {
        System.out.println("******demoprovider被访问******");
        return "Hello World!";
    }
}