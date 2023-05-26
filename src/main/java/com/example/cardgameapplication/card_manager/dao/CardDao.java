package com.example.cardgameapplication.card_manager.dao;

import com.example.cardgameapplication.card_manager.model.Card;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardDao extends CrudRepository<Card, Integer> {
    @Query(value = "SELECT c FROM Card c WHERE c.price > 0")
    List<Card> findSoldCards();
}
