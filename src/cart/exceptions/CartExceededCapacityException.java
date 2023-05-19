package cart.exceptions;

public class CartExceededCapacityException extends Exception {

    public CartExceededCapacityException(){
        super("Capacidade excedida!");
    }
}
