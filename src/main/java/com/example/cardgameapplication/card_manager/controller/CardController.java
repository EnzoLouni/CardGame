package com.example.cardgameapplication.card_manager.controller;

import com.example.cardgameapplication.card_manager.dto.CardDto;
import com.example.cardgameapplication.card_manager.service.CardService;
import com.example.cardgameapplication.card_manager.view.Views;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/card")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @JsonView(Views.CardView.class)
    @GetMapping("/{id}")
    public CardDto getCard(@PathVariable("id") Integer id) {
        return cardService.getCard(id);
    }

    @PutMapping("/{id}")
    public void setCard(@PathVariable("id") Integer id, @RequestBody @Valid CardDto newCardDto) {
        cardService.updateCard(id, newCardDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCard(@PathVariable("id") Integer id) {
        cardService.deleteCard(id);
    }

    @PostMapping
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
