package pl.vanthus.hw2.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import pl.vanthus.hw2.model.Product;

import java.util.List;

@Component
@Profile("pro")
public class ShopPro {

    @Value("${shop.vat}")
    private int vat;
    @Value("${shop.discount}")
    private int discount;
    double productPrice;

    public void calculatePrice(List<Product> cart){
        double totalPrice = 0;
        for(Product product : cart){
            productPrice = (product.getPrice() + product.getPrice() * vat / 100) - (product.getPrice() * discount / 100);
            totalPrice += Math.round(productPrice * 100.0) / 100.0;
        }
        System.out.println(totalPrice);
    }
}
