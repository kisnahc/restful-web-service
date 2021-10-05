package com.kisnahc.restfulwebservice.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Member extends BaseTimeEntity{

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @ApiModelProperty(notes = "이름을 입력해 주세요.")
    @Length(min = 2, max = 30, message = "최소 2자 이상 30자 이하로 입력해주세요.")
    @Column(unique = true)
    private String username;

    private String age;

    @OneToMany(mappedBy = "member")
    private List<Post> postList = new ArrayList<>();

    //== 연관관계 편의 메서드 ==//
    public void addPost(Post post) {
        this.postList.add(post);
        //무한루프 검증 로직.
        if (post.getMember() != this) {
            post.setMember(this);
        }
    }

    public void updateUsername(String username) {
        this.username = username;
    }
}
