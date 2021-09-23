package com.kisnahc.restfulwebservice.service;

import com.kisnahc.restfulwebservice.domain.Member;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    private static List<Member> members = new ArrayList<>();


    public List<Member> findAll() {
        return members;
    }

    public Long save(Member member) {
        if (member.getId() == null) {
            members.add(member);
        }
        return member.getId();
    }

    public Member findById(Long id) {
        for (Member member : members) {
            if (member.getId().equals(id)) {
                return member;
            }
        }
        return null;
    }

}
