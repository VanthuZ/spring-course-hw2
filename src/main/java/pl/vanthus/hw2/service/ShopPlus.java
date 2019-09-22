package pl.vanthus.hw2.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import pl.vanthus.hw2.model.Product;

import java.util.List;

@Controller
@Profile("plus")
public class ShopPlus {

    @Value("${shop.vat}")
    private int vat;
    double productPrice;

    public void calculatePrice(List<Product> cart){
      double totalPrice = 0;
        for(Product product : cart){
            productPrice = product.getPrice() + product.getPrice() * vat / 100;
            totalPrice += Math.round(productPrice * 100.0) / 100.0;
        }
        System.out.println(totalPrice);
    }


}
