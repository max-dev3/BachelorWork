package com.example.bachelorwork.auth;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
public class AuthenticationResponse {
    private String token;
}
