package com.example.restapihttp.mapper;

import com.example.restapihttp.dto.request.SignUpRequest;
import com.example.restapihttp.dto.response.SignUpResponse;
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
}
