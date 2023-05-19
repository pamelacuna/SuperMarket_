package cart.exceptions;

public class EmptyCartException extends Exception {

    public EmptyCartException(){
        super("Carrinho vazio!");
    }
}
