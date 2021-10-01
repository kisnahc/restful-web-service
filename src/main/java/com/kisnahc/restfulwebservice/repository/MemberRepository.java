package com.kisnahc.restfulwebservice.repository;

import com.kisnahc.restfulwebservice.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByUsername(String username);

}
