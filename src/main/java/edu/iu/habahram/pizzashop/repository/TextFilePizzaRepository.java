package edu.iu.habahram.pizzashop.repository;

import edu.iu.habahram.pizzashop.model.*;
import org.springframework.stereotype.Repository;

@Repository
public class TextFilePizzaRepository implements PizzaRepository{
    @Override
    public String prepareTheOrder(OrderData orderData) {
        PizzaStore pizzaStore = null;
        if(orderData.store().equalsIgnoreCase("chicago")) {
            pizzaStore = new ChicagoPizzaStore();
        }
        if(orderData.store().equalsIgnoreCase("new york")) {
            pizzaStore = new NewYorkPizzaStore();
        }
        Pizza pizza = pizzaStore.orderPizza(orderData.item());
        return pizza.toString();
    }
}
