package pl.vanthus.hw2.controller;

import org.springframework.boot.context.event.ApplicationReadyEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

import pl.vanthus.hw2.service.CartService;
import pl.vanthus.hw2.service.ShopPlus;

@Controller
@Profile("plus")
public class ShopPlusController {


    private ShopPlus shopPlus;
    private CartService cartService;


    @Autowired
    public ShopPlusController(ShopPlus shopPlus, CartService cartService) {
        this.shopPlus = shopPlus;
        this.cartService = cartService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void products(){

        shopPlus.calculatePrice(cartService.getSampleCart());
    }
}
