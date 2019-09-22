package pl.vanthus.hw2.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import pl.vanthus.hw2.model.Product;

import java.util.List;


@Component
@Profile("start")
public class Shop  {

    public void calculatePrice(List<Product> cart){
      double totalPrice = cart.stream()
              .mapToDouble(Product::getPrice)
              .sum();

      System.out.println(totalPrice);
    }

}
