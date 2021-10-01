package com.kisnahc.restfulwebservice.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    @ApiModelProperty(notes = "이름을 입력해 주세요.")
    @Length(min = 2, max = 30, message = "최소 2자 이상 30자 이하로 입력해주세요.")
    @Column(unique = true)
    private String username;

    private LocalDateTime createdAt;

    public void updateUsername(String username) {
        this.username = username;
    }
}
