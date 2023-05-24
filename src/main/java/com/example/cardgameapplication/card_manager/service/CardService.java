package com.example.cardgameapplication.card_manager.service;

import com.example.cardgameapplication.card_manager.dto.CardDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Validated
@RequiredArgsConstructor
@Service
public class CardService {

    private CardDto cardDto = CardDto.builder()
            .id(1)
            .name("name1")
            .description("description1")
            .family("family1")
            .affinity("affinity1")
            .imgUrl("https://www.google.com/")
            .smallImgUrl("https://www.google.com/")
            .energy(10.0)
            .hp(100.0)
            .defense(10.0)
            .attack(5.0)
            .price(2.0)
            .build(),
            cardDto2 = CardDto.builder()
                    .id(2)
                    .name("name2")
                    .description("description2")
                    .family("family2")
                    .affinity("affinity2")
                    .imgUrl("https://www.google.com/")
                    .smallImgUrl("https://www.google.com/")
                    .energy(1.0)
                    .hp(100.0)
                    .defense(1.0)
                    .attack(1.0)
                    .price(0.0)
                    .build();

    public List<CardDto> list = new ArrayList<>(Arrays.asList(cardDto, cardDto2));

    public CardDto getCard(Integer cardId) {
        Optional<CardDto> cardDtoById = list.stream().filter(card -> cardId.equals(card.getId())).findFirst();
        if(cardDtoById.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return cardDtoById.get();
    }

    public void setCard(Integer id, CardDto newCardDto) {
        Integer index = list.indexOf(getCard(id));
        list.set(index, newCardDto);
    }

    public void deleteCard(Integer cardId) {
        list.remove(getCard(cardId));
    }

    public void addCard(CardDto card) {
        list.add(card);
    }

    public List<CardDto> getCardsToSell() {
        return list.stream().filter(card -> card.getPrice() > 0).collect(Collectors.toList());
    }

    public List<CardDto> getCards() {
        return list;
    }
}
