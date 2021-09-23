package com.kisnahc.restfulwebservice.controller;

import com.kisnahc.restfulwebservice.domain.Member;
import com.kisnahc.restfulwebservice.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping("/members")
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        Long saveMemberId = memberService.save(member);


        //Status 201 Created
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saveMemberId)
                .toUri();

       return ResponseEntity.created(location).build();

    }

}
