package com.example.cardgameapplication.store_manager.dao;

import com.example.cardgameapplication.store_manager.model.StoreTransaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends CrudRepository<StoreTransaction, Integer> {
}
