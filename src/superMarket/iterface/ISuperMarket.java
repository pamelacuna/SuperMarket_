package superMarket.iterface;

import item.Item;

public interface ISuperMarket{

    void depositItemIntoCart(String itemID, String cartID);

    void removeItem(String itemID, String cartID);

    void listItems(String cartID);


    void pay(String cartID);

    void addItemToSuperMarket(String itemID);
}
