package com.kisnahc.restfulwebservice.controller;

import com.kisnahc.restfulwebservice.domain.Member;
import com.kisnahc.restfulwebservice.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members")
    public List<Member> findAll() {
        return memberService.findAll();
    }

    @GetMapping("/members/{id}")
    public Member findById(@PathVariable Long id) {
        return memberService.findById(id);
    }

}
