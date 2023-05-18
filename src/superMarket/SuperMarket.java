package superMarket;

public interface SuperMarket {
    void createCart(String cartID, int maxVolume);

    void pay(String cartID);

    void emptyCart(String cartID);
}
