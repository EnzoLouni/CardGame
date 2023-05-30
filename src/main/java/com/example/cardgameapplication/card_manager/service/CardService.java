package com.example.cardgameapplication.card_manager.service;

import com.example.cardgameapplication.card_manager.dao.CardRepository;
import com.example.cardgameapplication.card_manager.dto.CardDto;
import com.example.cardgameapplication.card_manager.mapper.CardMapper;
import com.example.cardgameapplication.card_manager.model.Card;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

@Validated
@RequiredArgsConstructor
@Service
public class CardService {

    private final CardRepository cardRepository;
    private final CardMapper cardMapper;

    public CardDto getCard(Integer cardId) {
        Optional<Card> card = cardRepository.findById(cardId);
        if(card.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return cardMapper.toCardDto(card.get());
    }

    public void updateCard(Integer id, CardDto newCardDto) {
        try {
            getCard(id);
            newCardDto.setId(id);
            cardRepository.save(cardMapper.toCard(newCardDto));
        } catch(Exception e) {
            throw new ResourceNotFoundException();
        }
    }

    public void deleteCard(Integer cardId) {
        try {
            cardRepository.deleteById(cardId);
        } catch(Exception e) {
            throw new ResourceNotFoundException();
        }
    }

    public void createCard(CardDto card) {
        cardRepository.save(cardMapper.toCard(card));
    }

    public List<CardDto> getCardsToSell() {
        return cardRepository.findSoldCards().stream().map(cardMapper::toCardDto).collect(toList());
    }

    public List<CardDto> getCards() {
        return StreamSupport.stream(cardRepository.findAll().spliterator(),false).map(cardMapper::toCardDto).collect(toList());
    }
}
