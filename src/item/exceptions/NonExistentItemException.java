package item.exceptions;

public class NonExistentItemException extends Exception {

    public NonExistentItemException(){
        super("Artigo inexistente!");
    }
}
