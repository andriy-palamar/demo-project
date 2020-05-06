package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserListResponse {

    private List<SmallUserResponse> users;
    private Integer size;

    public static UserListResponse of(List<SmallUserResponse> smallUserResponses) {
        UserListResponse userListResponse = new UserListResponse();
        userListResponse.setUsers(smallUserResponses);
        userListResponse.setSize(smallUserResponses.size());

        return userListResponse;
    }
}
