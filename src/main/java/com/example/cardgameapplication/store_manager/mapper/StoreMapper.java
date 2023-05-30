package com.example.cardgameapplication.store_manager.mapper;

import com.example.cardgameapplication.card_manager.mapper.CardMapper;
import com.example.cardgameapplication.store_manager.dto.StoreTransactionDto;
import com.example.cardgameapplication.store_manager.model.StoreAction;
import com.example.cardgameapplication.store_manager.model.StoreTransaction;
import com.example.cardgameapplication.user_manager.mapper.UserMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mapstruct.InjectionStrategy.FIELD;

@Mapper(injectionStrategy = FIELD, componentModel = "spring", imports = StoreAction.class)
public abstract class StoreMapper {

    @Autowired
    protected UserMapper userMapper;

    @Autowired
    protected CardMapper cardMapper;

    @Mapping(target = "id", source = "transaction.id")
    @Mapping(target = "userDto", expression = "java(userMapper.toUserDto(transaction.getUser()))")
    @Mapping(target = "cardDto", expression = "java(cardMapper.toCardDto(transaction.getCard()))")
    @Mapping(target = "action", expression = "java(StoreAction.valueOf(transaction.getAction()))")
    @Mapping(target = "timestamp", source = "transaction.timestamp")
    public abstract StoreTransactionDto toStoreTransactionDto(StoreTransaction transaction);

    @Mapping(target = "id", source = "transactionDto.id")
    @Mapping(target = "user", expression = "java(userMapper.toUser(transactionDto.getUserDto()))")
    @Mapping(target = "card", expression = "java(cardMapper.toCard(transactionDto.getCardDto()))")
    @Mapping(target = "action", expression = "java(transactionDto.getAction().toString())")
    @Mapping(target = "timestamp", source = "transactionDto.timestamp")
    public abstract StoreTransaction toStoreTransaction(StoreTransactionDto transactionDto);
}
