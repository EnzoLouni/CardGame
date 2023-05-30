package com.example.cardgameapplication.store_manager.dto;

import com.example.cardgameapplication.card_manager.dto.CardDto;
import com.example.cardgameapplication.store_manager.model.StoreAction;
import com.example.cardgameapplication.user_manager.dto.UserDto;
import com.example.cardgameapplication.view.Views;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StoreTransactionDto {
    @JsonView(Views.StoreView.class)
    private Integer id;
    @JsonView({Views.StoreView.class, Views.UserView.class})
    private UserDto userDto;
    @JsonView({Views.StoreView.class, Views.CardView.class})
    private CardDto cardDto;
    @JsonView(Views.StoreView.class)
    private StoreAction action;
    @JsonView(Views.StoreView.class)
    private Date timestamp;
}
