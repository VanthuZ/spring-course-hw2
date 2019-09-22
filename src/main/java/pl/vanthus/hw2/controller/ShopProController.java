package pl.vanthus.hw2.controller;

import org.springframework.boot.context.event.ApplicationReadyEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

import pl.vanthus.hw2.service.CartService;
import pl.vanthus.hw2.service.ShopPro;

@Controller
@Profile("pro")
public class ShopProController {

    private ShopPro shopPro;
    private CartService cartService;


    @Autowired
    public ShopProController(ShopPro shopPro, CartService cartService) {
        this.shopPro = shopPro;
        this.cartService = cartService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void products(){
        shopPro.calculatePrice(cartService.getSampleCart());
    }

}
