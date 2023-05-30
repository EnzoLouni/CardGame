package com.example.cardgameapplication.user_manager.dto;

import lombok.*;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthDto {
    private String login;
    private String password;
}
