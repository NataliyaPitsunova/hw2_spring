package ru.geekbrains.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product findProductById(int id) {
        if (productRepository.findProductById(id) == null) {
            System.out.println("Продукта с таким id нет");
        }
        return productRepository.findProductById(id);
    }
}
