package superMarket;

import cart.Cart;
import cart.exceptions.ExistentCartException;
import item.Item;
import item.exceptions.ExistentItemException;
import superMarket.iterface.ISuperMarket;

import java.util.LinkedList;
import java.util.List;

public class SuperMarket implements ISuperMarket {

    private List<Cart> cart;
    private List<Item> item;

    public SuperMarket() {
        cart = new LinkedList<>();
        item = new LinkedList<>();
    }

    @Override
    public void pay(String cartID) {

    }

    public void addCart(Cart cart) {
        if (checkCart(cart)) {
            carts.add(cart);
            System.out.println("Carrinho criado com sucesso.");
        } else {
            try {
                throw new ExistentCartException();
            } catch (ExistentCartException e) {
                System.out.println(e);
            }
        }
    }

    private boolean checkCart(Cart carts) {
        for (Cart cart1 : cart) {
            if (cart1.getName().equals(carts.getName())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void addItem(Item item) {
        if (checkItem(item)) {
            items.add(item);
            System.out.println("Artigo criado com sucesso.");
        } else {
            try {
                throw new ExistentItemException();
            } catch (ExistentItemException e) {
                System.out.println(e);
            }
        }
    }

    private boolean checkItem(Item item) {
        for (Item item1 : items) {
            if (item1.getName().equals(item.getName())) {
                return false;
            }
        }
        return true;
    }


}
