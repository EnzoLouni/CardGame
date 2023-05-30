package com.example.cardgameapplication.store_manager.service;

import com.example.cardgameapplication.card_manager.dto.CardDto;
import com.example.cardgameapplication.card_manager.service.CardService;
import com.example.cardgameapplication.store_manager.dao.StoreRepository;
import com.example.cardgameapplication.store_manager.dto.StoreOrder;
import com.example.cardgameapplication.store_manager.dto.StoreTransactionDto;
import com.example.cardgameapplication.store_manager.mapper.StoreMapper;
import com.example.cardgameapplication.store_manager.model.StoreAction;
import com.example.cardgameapplication.user_manager.dto.UserDto;
import com.example.cardgameapplication.user_manager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
import java.util.List;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

@Validated
@RequiredArgsConstructor
@Service
public class StoreService {

    private final StoreRepository storeRepository;
    private final StoreMapper storeMapper;
    private final CardService cardService;
    private final UserService userService;

    public List<StoreTransactionDto> getTransactions() {
        return StreamSupport.stream(storeRepository.findAll().spliterator(),false).map(storeMapper::toStoreTransactionDto).collect(toList());
    }

    public void sell(StoreOrder order) {
        CardDto cardSold = cardService.getCard(order.getCardId());
        cardSold.setUserDto(null);
        cardService.updateCard(cardSold.getId(), cardSold);
        StoreTransactionDto newStoreTransactionDto = StoreTransactionDto.builder()
            .cardDto(cardSold)
            .userDto(userService.getUser(order.getUserId()))
            .action(StoreAction.SELL)
            .timestamp(new Date())
            .build();
        storeRepository.save(storeMapper.toStoreTransaction(newStoreTransactionDto));
    }

    public void buy(StoreOrder order) {
        CardDto cardBought = cardService.getCard(order.getCardId());
        UserDto newOwner = userService.getUser(order.getUserId());
        cardBought.setUserDto(newOwner);
        cardService.updateCard(cardBought.getId(), cardBought);
        StoreTransactionDto newStoreTransactionDto = StoreTransactionDto.builder()
                .cardDto(cardBought)
                .userDto(newOwner)
                .action(StoreAction.BUY)
                .timestamp(new Date())
                .build();
        storeRepository.save(storeMapper.toStoreTransaction(newStoreTransactionDto));
    }
}
