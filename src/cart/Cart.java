package cart;

import cart.interfaces.ICart;
import item.Item;

import java.util.List;

public class Cart implements ICart {
    private String cartID;
    private int cartCapacity;
    private List<Item> items;

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
    public boolean isFull() {
        return items.size() == cartCapacity;
    }

    public List<Item> getItems() {
        return items;
    }
}
