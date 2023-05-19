package superMarket.iterface;

import cart.Cart;
import item.Item;

public interface ISuperMarket{

    void pay(String cartID);

    void addItem(Item item);
}
