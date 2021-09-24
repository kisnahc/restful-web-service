package com.kisnahc.restfulwebservice.controller;

import com.kisnahc.restfulwebservice.bean.HelloBean;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final MessageSource messageSource;

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

    @GetMapping("/hello-internationalized")
    public String helloInternationalized(
            @RequestHeader(value = "Accept-Language", required = false) Locale locale) {
        return messageSource.getMessage("hello", null, locale);
    }
}
