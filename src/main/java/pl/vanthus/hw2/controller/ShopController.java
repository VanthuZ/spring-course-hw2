package pl.vanthus.hw2.controller;

import org.springframework.boot.context.event.ApplicationReadyEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

import pl.vanthus.hw2.service.CartService;
import pl.vanthus.hw2.service.Shop;


@Controller
@Profile("start")
public class ShopController {

    private Shop shop;
    private CartService cartService;


    @Autowired
    public ShopController(Shop shop, CartService cartService) {
        this.shop = shop;
        this.cartService = cartService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void products(){

        shop.calculatePrice(cartService.getSampleCart());
    }
}
