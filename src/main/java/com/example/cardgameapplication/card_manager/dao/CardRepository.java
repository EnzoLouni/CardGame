package com.example.cardgameapplication.card_manager.dao;

import com.example.cardgameapplication.card_manager.model.Card;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends CrudRepository<Card, Integer> {
    @Query(value = "SELECT c FROM Card c WHERE c.user IS NULL")
    List<Card> findSoldCards();
}
