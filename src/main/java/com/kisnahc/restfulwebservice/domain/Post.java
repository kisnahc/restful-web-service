package com.kisnahc.restfulwebservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "post_id")
    private Long id;

    private String author;

    private String title;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;


    //== 연관관계 편의 메서드 ==//
    public void setMember(Member member) {
        this.member = member;

        //무한루프 검증 로직.
        if (!member.getPostList().contains(this)) {
            member.getPostList().add(this);
        }
    }
}


