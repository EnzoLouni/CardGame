package com.example.cardgameapplication.card_manager.dto;

import com.example.cardgameapplication.user_manager.dto.UserDto;
import com.example.cardgameapplication.view.Views;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CardDto {
    @JsonView(Views.CardView.class)
    private Integer id;
    @JsonView(Views.CardView.class)
    private String name;
    @JsonView(Views.CardView.class)
    private String description;
    @JsonView(Views.CardView.class)
    private String family;
    @JsonView(Views.CardView.class)
    private String affinity;
    @JsonView(Views.CardView.class)
    private String imgUrl;
    @JsonView(Views.CardView.class)
    private String smallImgUrl;
    @JsonView(Views.CardView.class)
    private Double energy;
    @JsonView(Views.CardView.class)
    private Double hp;
    @JsonView(Views.CardView.class)
    private Double defense;
    @JsonView(Views.CardView.class)
    private Double attack;
    @JsonView(Views.CardView.class)
    private Double price;
    @JsonView(Views.UserView.class)
    private UserDto userDto;
}
