package com.example.restapihttp.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateRequest {
    private String firstName;
    private String lastName;
}
