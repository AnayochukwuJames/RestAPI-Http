package com.example.restapihttp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class LoginResponse {
    private String email;
    private String message;
    private String phoneNumber;
}
