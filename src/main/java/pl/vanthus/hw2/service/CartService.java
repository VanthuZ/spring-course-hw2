package pl.vanthus.hw2.service;

import org.springframework.stereotype.Service;
import pl.vanthus.hw2.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CartService {

    private List<Product> cart = new ArrayList<>();

    double low = 50;
    double high = 300;

    private double getRandomDouble(){
        double randomDouble = ThreadLocalRandom.current().nextDouble(low, high);
        return Math.round(randomDouble * 100.0) / 100.0;
    }

    public List<Product> getSampleCart(){
        for (int i = 0; i < 5; i++) {
            cart.add(new Product("Product" + i, getRandomDouble()));
            System.out.println(cart.get(i));
        }
        return cart;
    }
}
