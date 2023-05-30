package com.example.cardgameapplication.user_manager.model;

import com.example.cardgameapplication.card_manager.model.Card;
import com.example.cardgameapplication.store_manager.model.StoreTransaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USER", schema = "public")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String login;
    @NotNull
    private String pwd;
    @NotNull
    private String firstName;
    @NotNull
    private String surName;
    @NotNull
    private String email;
    @OneToMany(targetEntity = StoreTransaction.class, mappedBy = "user")
    private List<StoreTransaction> storeTransactions;
    @OneToMany(targetEntity = Card.class, mappedBy = "user")
    private List<Card> cards;
}
