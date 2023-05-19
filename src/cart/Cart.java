package cart;

import cart.interfaces.ICart;

import java.util.Iterator;

public class Cart implements ICart {
    private String cartID;
    private int cartCapacity;

    public Cart(String cartID, int cartCapacity) {
        this.cartID = cartID;
        this.cartCapacity = cartCapacity;
    }

    public String getCartID() {
        return cartID;
    }

    public int getCartCapacity() {
        return cartCapacity;
    }

    @Override
    public void depositItem(Item item) {

    }

    @Override
    public void removeItem(Item item) {

    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public Iterator<Item> listItems() {
        return null;
    }
}
