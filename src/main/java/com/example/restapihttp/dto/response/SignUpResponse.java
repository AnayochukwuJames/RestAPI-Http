package com.example.restapihttp.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpResponse {
    private String email;
    private String phoneNumber;
    private String message;
}
