package com.kisnahc.restfulwebservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    private Long id;

    @Length(min = 2, max = 30, message = "최소 2자 이상 30자 이하로 입력해주세요.")
    private String username;

    private LocalDateTime createdAt;

    public void updateUsername(String username) {
        this.username = username;
    }
}
