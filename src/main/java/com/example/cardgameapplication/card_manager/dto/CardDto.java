package com.example.cardgameapplication.card_manager.dto;

import com.example.cardgameapplication.card_manager.view.Views;
import com.example.cardgameapplication.user_manager.dto.UserDto;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CardDto {
    private Integer id;
    @JsonView(Views.CardView.class)
    @NotNull
    private String name;
    @JsonView(Views.CardView.class)
    private String description;
    @JsonView(Views.CardView.class)
    @NotNull
    private String family;
    @JsonView(Views.CardView.class)
    @NotNull
    private String affinity;
    @JsonView(Views.CardView.class)
    private String imgUrl;
    @JsonView(Views.CardView.class)
    private String smallImgUrl;
    @JsonView(Views.CardView.class)
    @NotNull
    private Double energy;
    @JsonView(Views.CardView.class)
    @NotNull
    private Double hp;
    @JsonView(Views.CardView.class)
    @NotNull
    private Double defense;
    @JsonView(Views.CardView.class)
    @NotNull
    private Double attack;
    @JsonView(Views.CardView.class)
    @NotNull
    private Double price;
    @JsonView(Views.UserView.class)
    @NotNull
    private UserDto userDto;
}
