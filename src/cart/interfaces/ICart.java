package cart.interfaces;

import java.util.Iterator;

public interface ICart {
    void depositItem(Item item);
    void removeItem(Item item);
    boolean isFull();
    Iterator<Item> listItems();
}
