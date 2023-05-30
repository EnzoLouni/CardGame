package com.example.cardgameapplication.store_manager.dto;

import lombok.*;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StoreOrder {
    private Integer cardId;
    private Integer userId;
}
