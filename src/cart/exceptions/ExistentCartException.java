package cart.exceptions;

public class ExistentCartException extends Exception {
    public ExistentCartException(){

        super("Carrinho existente!");
    }
}
