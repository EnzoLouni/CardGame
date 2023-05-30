package com.example.cardgameapplication.card_manager.model;

import com.example.cardgameapplication.user_manager.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CARD", schema = "public")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private String family;
    @NotNull
    private String affinity;
    @NotNull
    private String imgUrl;
    @NotNull
    private String smallImgUrl;
    @NotNull
    private Double energy;
    @NotNull
    private Double hp;
    @NotNull
    private Double defense;
    @NotNull
    private Double attack;
    @NotNull
    private Double price;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
