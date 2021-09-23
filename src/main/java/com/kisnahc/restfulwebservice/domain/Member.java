package com.kisnahc.restfulwebservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Member {

    private Long id;

    private String username;

    private LocalDateTime createAt;
}
