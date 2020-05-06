package com.example.demo.service;

import com.example.demo.dto.SmallUserResponse;
import com.example.demo.dto.UserListResponse;
import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UserResponse;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse create(UserRequest userRequest) {
        User user = User.of(userRequest);
        User savedUser = userRepository.save(user);

        return UserResponse.of(savedUser);
    }

    public UserListResponse getAll() {
        List<User> users = userRepository.findAll();

        List<SmallUserResponse> smallUserResponses = users.stream()
                .map(SmallUserResponse::of)
                .collect(Collectors.toList());

        return UserListResponse.of(smallUserResponses);
    }
}
