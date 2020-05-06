package com.example.demo.dto;

import com.example.demo.model.User;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SmallUserResponse {

    private Long id;
    private String name;
    private Integer age;

    public static SmallUserResponse of(User user) {
        SmallUserResponse smallUserResponse = new SmallUserResponse();
        smallUserResponse.setId(user.getId());
        smallUserResponse.setName(user.getName());
        smallUserResponse.setAge(user.getAge());

        return smallUserResponse;
    }
}
