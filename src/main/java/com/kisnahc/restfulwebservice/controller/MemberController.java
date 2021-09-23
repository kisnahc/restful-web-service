package com.kisnahc.restfulwebservice.controller;

import com.kisnahc.restfulwebservice.domain.Member;
import com.kisnahc.restfulwebservice.dto.MemberDto;
import com.kisnahc.restfulwebservice.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private T data;
        private int count;
    }

    @GetMapping("/members")
    public Result memberList() {
        List<Member> memberList = memberService.findAll();

        //엔티티 -> DTO 변환
        List<MemberDto> collect = memberList.stream()
                .map(m -> new MemberDto(m.getUsername()))
                .collect(Collectors.toList());

        return new Result(collect, memberList.size());
    }

    @GetMapping("/members/{id}")
    public Member findMember(@PathVariable Long id) {
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
