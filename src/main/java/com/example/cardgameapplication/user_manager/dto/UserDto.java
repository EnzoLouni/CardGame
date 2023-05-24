package com.example.cardgameapplication.user_manager.dto;

import com.example.cardgameapplication.card_manager.dto.CardDto;

import java.util.List;

public class UserDto {
    private Integer id;
    private String login;
    private String pwd;
    private String lastName;
    private String surName;
    private String email;
    private List<CardDto> cardList;
}
