package superMarket;

import cart.Cart;
import cart.exceptions.CartExceededCapacityException;
import cart.exceptions.EmptyCartException;
import cart.exceptions.ExistentCartException;
import cart.exceptions.NonExistentCartException;
import item.Item;
import item.exceptions.ExistentItemException;
import item.exceptions.NonExistentItemException;
import superMarket.iterface.ISuperMarket;

import java.util.LinkedList;
import java.util.List;

public class SuperMarket implements ISuperMarket {

    private List<Cart> carts;
    private List<Item> items;

    public SuperMarket() {
        carts = new LinkedList<>();
        items = new LinkedList<>();
    }

    @Override
    public void depositItemIntoCart(String itemID, String cartID) {
        if(!checkCartExists(cartID)){
            try {
                throw new NonExistentCartException();
            } catch (NonExistentCartException e) {
                System.out.println(e);
            }
        } else if(!checkItemExists(itemID)){
            try {
                throw new NonExistentItemException();
            } catch (NonExistentItemException e) {
                System.out.println(e);
            }
        } else if(isCartFull(cartID)){
            try {
                throw new CartExceededCapacityException();
            } catch (CartExceededCapacityException e) {
                System.out.println(e);
            }
        } else {
            Cart cart = searchCart(cartID);
            Item item = searchItem(itemID);
            cart.getItems().add(item);
            System.out.println("Artigo adicionado com sucesso.");
        }
    }

    @Override
    public void removeItem(String itemID, String cartID) {
        if(!checkCartExists(cartID)){
            try {
                throw new NonExistentCartException();
            } catch (NonExistentCartException e) {
                System.out.println(e);
            }
        } else if(!checkItemExists(itemID)){
            try {
                throw new NonExistentItemException();
            } catch (NonExistentItemException e) {
                System.out.println(e);
            }
        }  else {
            Cart cart = searchCart(cartID);
            Item item = searchItem(itemID);
            cart.getItems().remove(item);
            System.out.println("Artigo removido com sucesso.");
        }
    }

    @Override
    public void listItems(String cartID) {
        Cart cart = searchCart(cartID);
        if(!checkCartExists(cartID)){
            try {
                throw new NonExistentCartException();
            } catch (NonExistentCartException e) {
                System.out.println(e);
            }
        } else if (cart.getItems().isEmpty()){
            try {
                throw new EmptyCartException();
            } catch (EmptyCartException e) {
                System.out.println(e);
            }
        } else {
            cart.getItems()
                    .stream()
                    .forEach(item -> System.out.println(item.getItemID() + " " + item.getPrice()));
        }
    }

    public Cart searchCart(String cartID){
        for (Cart cart1 : carts) {
            if (cart1.getCartID().equals(cartID)) {
                return cart1;
            }
        }
        return null;
    }

    public Item searchItem(String itemID){
        for (Item item1 : items) {
            if (item1.getItemID().equals(itemID)) {
                return item1;
            }
        }
        return null;
    }
    @Override
    public void pay(String cartID) {
        Cart cart = searchCart(cartID);
        if(!checkCartExists(cartID)){
            try {
                throw new NonExistentCartException();
            } catch (NonExistentCartException e) {
                System.out.println(e);
            }
        } else if (cart.getItems().isEmpty()){
            try {
                throw new EmptyCartException();
            } catch (EmptyCartException e) {
                System.out.println(e);
            }
        } else {
            System.out.println(
                    cart.getItems()
                            .stream()
                            .mapToInt(Item::getPrice)
                            .sum()
            );
        }
    }

    public boolean isCartFull(String cartID){
        for (Cart cart1 : carts) {
            if (cart1.getCartID().equals(cartID)) {
                return cart1.isFull();
            }
        }
        return true;
    }
    public void addCartToSuperMarket(Cart cart) {
        if (checkCartExists(cart.getCartID())) {
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


    private boolean checkCartExists(String cart) {
        for (Cart cart1 : carts) {
            if (cart1.getCartID().equals(cart)) {
                return false;
            }
        }
        return true;
    }

    public void addItemToSuperMarket(String itemID) {
        if (checkItemExists(itemID)) {
            Item item = searchItem(itemID);
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

    private boolean checkItemExists(String item) {
        for (Item item1 : items) {
            if (item1.getItemID().equals(item)) {
                return false;
            }
        }
        return true;
    }


}
