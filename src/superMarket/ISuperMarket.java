package superMarket;

public interface ISuperMarket{
    void createCart(String cartID, int maxVolume);

    void pay(String cartID);

    void emptyCart(String cartID);
}
