package ru.geekbrains.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {
    ProductService productService;
    List<Product> cart;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @PostConstruct
    public void init() {
        System.out.println("У вас пустая корзина");
        cart = new ArrayList<>();
    }

    public void addproductById(int id) {
        Product p = productService.findProductById(id);
        if (!(p == null)){
        cart.add(p);
        System.out.println("В вашу корзину добавлен товар " + p.getTitle());}
    }

    public void showProductToCart() {
        for (Product p : cart
        ) {
            System.out.println(p.getTitle());
        }
    }

    public void deleteFromCart(int id) {
        Iterator<Product> cartIter = cart.iterator();
        while (cartIter.hasNext()) {
            Product p = cartIter.next();
            if (p.getId() == id) {
                cartIter.remove();
                break;
            }
        }
    }
}


