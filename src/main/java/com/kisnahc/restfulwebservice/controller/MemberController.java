package com.kisnahc.restfulwebservice.controller;

import com.kisnahc.restfulwebservice.domain.Member;
import com.kisnahc.restfulwebservice.dto.MemberDto;
import com.kisnahc.restfulwebservice.exception.MemberNotFoundException;
import com.kisnahc.restfulwebservice.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
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
        Member member = memberService.findById(id);

        if (member == null) {
            throw new MemberNotFoundException("회원을 찾을 수 없습니다. " + "ID = " + id);
        }
        return member;
    }

    @PostMapping("/members")
    public ResponseEntity<Member> createMember(@Valid @RequestBody Member member) {
        Long saveMemberId = memberService.save(member);

        //Status 201 Created
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saveMemberId)
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/members/{id}")
    public void deleteMember(@PathVariable Long id) {
        Member member = memberService.deleteById(id);

        if (member == null) {
            throw new MemberNotFoundException("회원을 찾을 수 없습니다. " + "ID = " + id);
        }
    }

    @PostMapping("/members/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable Long id, @RequestBody Member member) {
        Member findMember = memberService.findById(id);

        if (findMember == null) {
            throw new MemberNotFoundException("회원을 찾을 수 없습니다. " + "ID = " + id);
        }

        memberService.update(findMember.getId(), member.getUsername());
        return ResponseEntity.ok().build();
    }
}
