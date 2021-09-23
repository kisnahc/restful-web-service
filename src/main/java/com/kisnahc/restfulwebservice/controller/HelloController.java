package com.kisnahc.restfulwebservice.controller;

import com.kisnahc.restfulwebservice.bean.HelloBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello-world")
    public String hello() {
        return "hello !";
    }

    //Java Bean 호출
    @GetMapping("/hello-bean")
    public HelloBean helloBean() {
        return new HelloBean("helloBean !");
    }
}
