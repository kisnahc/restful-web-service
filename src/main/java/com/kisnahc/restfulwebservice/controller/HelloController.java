package com.kisnahc.restfulwebservice.controller;

import com.kisnahc.restfulwebservice.bean.HelloBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    //Path Variable
    @GetMapping("/hello-world/{id}")
    public HelloBean helloPathVariable(@PathVariable String id) {
        return new HelloBean("hello ! " + id);
    }
}
