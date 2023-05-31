package com.example.cardgameapplication.card_manager.service;

import com.example.cardgameapplication.card_manager.dao.CardRepository;
import com.example.cardgameapplication.card_manager.dto.CardDto;
import com.example.cardgameapplication.card_manager.mapper.CardMapper;
import com.example.cardgameapplication.card_manager.model.Card;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

@Validated
@Slf4j
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

    public static List<CardDto> generateCards() {
        ClassPathResource staticDataResource = new ClassPathResource("Types_of_Cards.json");
        List<CardDto> generatedCards = new ArrayList<>();
        String staticDataString;
        try {
            staticDataString = IOUtils.toString(staticDataResource.getInputStream(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        do {
            JSONObject cardJson = new JSONObject(staticDataString.substring(1,staticDataString.indexOf('}')+1));
            generatedCards.add(CardDto.builder()
                    .name(cardJson.getString("name"))
                    .description(cardJson.getString("description"))
                    .family(cardJson.getString("family"))
                    .affinity(cardJson.getString("affinity"))
                    .imgUrl(cardJson.getString("imgUrl"))
                    .smallImgUrl(cardJson.getString("smallImgUrl"))
                    .energy(cardJson.getDouble("energy"))
                    .hp(cardJson.getDouble("hp"))
                    .defense(cardJson.getDouble("defense"))
                    .attack(cardJson.getDouble("attack"))
                    .price(cardJson.getDouble("price"))
                    .build());
            staticDataString = staticDataString.substring(staticDataString.indexOf('}')+1);
        } while(staticDataString.indexOf('}') > -1);

        return generatedCards;
    }
}
