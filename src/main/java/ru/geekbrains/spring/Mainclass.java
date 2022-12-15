package ru.geekbrains.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Mainclass {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ru.geekbrains.spring");
        Cart cart = context.getBean(Cart.class);
        boolean exit = false;
        System.out.println("У вас пустая корзина");
        while (exit == false) {
            System.out.println("Для добавления продукта введите его id в диапазоне[1..5].");
            System.out.println("Для удаления продуктов из корзины нажмите 0.");
            System.out.println("Для завершения нажмите -1");
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();

            switch (id) {
                default:
                    cart.addproductById(id);
                    break;
                case 0:
                    System.out.println("Введите номер id продукта для удаления:");
                    sc = new Scanner(System.in);
                    id = sc.nextInt();
                    cart.deleteFromCart(id);
                    break;
                case -1:
                    exit = true;
                    break;
                case -2:
                    cart.showProductToCart();
                    break;
            }
        }
        context.close();
    }
}
