package com.example.cardgameapplication.card_manager.controller;

import com.example.cardgameapplication.card_manager.dto.CardDto;
import com.example.cardgameapplication.card_manager.service.CardService;
import com.example.cardgameapplication.view.Views;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @JsonView(Views.CardView.class)
    @GetMapping("/card")
    public CardDto getCard(@RequestParam(name = "id") Integer id) {
        return cardService.getCard(id);
    }

    @PutMapping("/card")
    public void updateCard(@RequestParam(name = "id") Integer id, @RequestBody @Valid CardDto newCardDto) {
        cardService.updateCard(id, newCardDto);
    }

    @DeleteMapping("/card")
    public void deleteCard(@RequestParam(name = "id") Integer id) {
        cardService.deleteCard(id);
    }

    @PostMapping("/card")
    public void createCard(@RequestBody @Valid CardDto card)
    {
        cardService.createCard(card);
    }

    @JsonView(Views.CardView.class)
    @GetMapping("/cards_to_sell")
    public List<CardDto> getCardsToSell()
    {
        return cardService.getCardsToSell();
    }

    @JsonView(Views.CardView.class)
    @GetMapping("/cards")
    public List<CardDto> getCards()
    {
        return cardService.getCards();
    }
}
