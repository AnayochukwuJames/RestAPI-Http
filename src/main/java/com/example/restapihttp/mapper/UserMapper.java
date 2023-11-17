package com.example.restapihttp.mapper;

import com.example.restapihttp.dto.request.SignUpRequest;
import com.example.restapihttp.dto.request.UpdateRequest;
import com.example.restapihttp.dto.response.SignUpResponse;
import com.example.restapihttp.dto.response.UserResponse;
import com.example.restapihttp.model.Users;

public class UserMapper {
    public static Users mapSignUpRequestToUsers(SignUpRequest request){
        return Users.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .password(request.getPassword())
                .build();
    }
    public static SignUpResponse mapSignUpResponse(Users response){
        return SignUpResponse.builder()
                .email(response.getEmail())
                .phoneNumber(response.getPhoneNumber())
                .message(response.getEmail())
                .build();
    }
    public static UserResponse mapUserResponse(Users response){
        return UserResponse.builder()
                .id(response.getId())
                .firstName(response.getFirstName())
                .lastName(response.getLastName())
                .email(response.getEmail())
                .phoneNumber(response.getPhoneNumber())
                .password(response.getPassword())
                .build();
    }

    public static Users mapUpdateRequestToUser(Users users, UpdateRequest request){
        users.setFirstName(request.getFirstName());
        users.setLastName(request.getLastName());
        return users;
    }


}
