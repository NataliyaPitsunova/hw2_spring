package ru.geekbrains.spring;

import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1, "Хлеб", 30),
                new Product(2, "Молоко", 80),
                new Product(3, "Манго", 150),
                new Product(4, "Авокадо", 150),
                new Product(5, "Оливки", 200)
        ));

    }

    public Product findProductById(int id) {
        for (Product p:products
             ) {
            if (p.getId()==id){
                return p;
            }
        }
        return null;
    }

    public List<Product> addAllProducts(){
        return Collections.unmodifiableList(products);
    }

}
