package com.example.cardgameapplication.store_manager.controller;

import com.example.cardgameapplication.store_manager.dto.StoreOrder;
import com.example.cardgameapplication.store_manager.dto.StoreTransactionDto;
import com.example.cardgameapplication.store_manager.service.StoreService;
import com.example.cardgameapplication.view.Views;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/store")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @JsonView({Views.StoreView.class, Views.CardView.class, Views.UserView.class})
    @GetMapping("/transactions")
    public List<StoreTransactionDto> getTransactions() {
        return storeService.getTransactions();
    }

    @PostMapping("/sell")
    public void sell(@RequestBody @Valid StoreOrder order)
    {
        storeService.sell(order);
    }

    @PostMapping("/buy")
    public void buy(@RequestBody @Valid StoreOrder order)
    {
        storeService.buy(order);
    }
}

