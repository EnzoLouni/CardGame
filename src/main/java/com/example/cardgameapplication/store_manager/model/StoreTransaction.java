package com.example.cardgameapplication.store_manager.model;

import com.example.cardgameapplication.card_manager.model.Card;
import com.example.cardgameapplication.user_manager.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "STORE_TRANSACTION", schema = "public")
public class StoreTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;
    @NotNull
    private String action;
    @Column
    private Date timestamp;
}
