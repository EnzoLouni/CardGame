package com.example.cardgameapplication.user_manager.dto;

import com.example.cardgameapplication.card_manager.dto.CardDto;
import com.example.cardgameapplication.view.Views;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @JsonView(Views.UserView.class)
    private Integer id;
    @JsonView(Views.UserView.class)
    private String login;
    private String pwd;
    @JsonView(Views.UserView.class)
    private String firstName;
    @JsonView(Views.UserView.class)
    private String surName;
    @JsonView(Views.UserView.class)
    private String email;
    private List<CardDto> cardDtos;
}
