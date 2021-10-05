package com.kisnahc.restfulwebservice.service;

import com.kisnahc.restfulwebservice.domain.Member;
import com.kisnahc.restfulwebservice.exception.MemberNotFoundException;
import com.kisnahc.restfulwebservice.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ValidationException;
import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Transactional
    public Long save(Member member) {
        validateDuplicateMember(member); //중복 검증 메서드.
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMember = memberRepository.findByUsername(member.getUsername());

        if (!findMember.isEmpty()) {
            throw new ValidationException("중복되는 회원입니다.");
        }
    }

    public Member findById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException("회원을 찾을 수 없습니다."));
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

    @Transactional
    public void update(Long id, String username) {
        Member findMember = memberRepository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException("회원을 찾을 수 없습니다."));
        findMember.updateUsername(username);
    }
}
