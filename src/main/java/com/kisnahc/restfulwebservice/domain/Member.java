package com.kisnahc.restfulwebservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    private Long id;

    private String username;

    private LocalDateTime createdAt;

    public void updateUsername(String username) {
        this.username = username;
    }
}
