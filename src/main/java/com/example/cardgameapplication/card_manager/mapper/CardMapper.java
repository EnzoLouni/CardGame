package com.example.cardgameapplication.card_manager.mapper;

import com.example.cardgameapplication.card_manager.dto.CardDto;
import com.example.cardgameapplication.card_manager.model.Card;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.InjectionStrategy.FIELD;

@Mapper(injectionStrategy = FIELD, componentModel = "spring")
public interface CardMapper {
    @Mapping(target = "id", source = "card.id")
    @Mapping(target = "name", source = "card.name")
    @Mapping(target = "description", source = "card.description")
    @Mapping(target = "family", source = "card.family")
    @Mapping(target = "affinity", source = "card.affinity")
    @Mapping(target = "imgUrl", source = "card.imgUrl")
    @Mapping(target = "smallImgUrl", source = "card.smallImgUrl")
    @Mapping(target = "energy", source = "card.energy")
    @Mapping(target = "hp", source = "card.hp")
    @Mapping(target = "defense", source = "card.defense")
    @Mapping(target = "attack", source = "card.attack")
    @Mapping(target = "price", source = "card.price")
    @Mapping(target = "userDto", expression = "java(null)")
    CardDto toCardDto(Card card);

    @Mapping(target = "id", source = "cardDto.id")
    @Mapping(target = "name", source = "cardDto.name")
    @Mapping(target = "description", source = "cardDto.description")
    @Mapping(target = "family", source = "cardDto.family")
    @Mapping(target = "affinity", source = "cardDto.affinity")
    @Mapping(target = "imgUrl", source = "cardDto.imgUrl")
    @Mapping(target = "smallImgUrl", source = "cardDto.smallImgUrl")
    @Mapping(target = "energy", source = "cardDto.energy")
    @Mapping(target = "hp", source = "cardDto.hp")
    @Mapping(target = "defense", source = "cardDto.defense")
    @Mapping(target = "attack", source = "cardDto.attack")
    @Mapping(target = "price", source = "cardDto.price")
    @Mapping(target = "userId", expression = "java(null)")
    Card toCard(CardDto cardDto);
}