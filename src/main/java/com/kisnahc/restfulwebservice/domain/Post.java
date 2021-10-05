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
    private Member member;


}
