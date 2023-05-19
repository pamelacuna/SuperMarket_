package item.exceptions;

public class ExistentItemException extends Exception {

    public ExistentItemException(){
        super("Artigo existente!");
    }
}
