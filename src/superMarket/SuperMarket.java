package superMarket;

import cart.Cart;
import item.Item;
import item.exceptions.ExistentItemException;
import superMarket.iterface.ISuperMarket;

import java.util.LinkedList;
import java.util.List;

public class SuperMarket implements ISuperMarket{

    private List<Cart> carts;
    private List<Item> items;

    public SuperMarket(){
        carts= new LinkedList<>();
        items = new LinkedList<>();
    }

    @Override
    public void pay(String cartID){

    }

    @Override
    public void addItem(Item item){
        if(checkItem(item)){
            items.add(item);
            System.out.println("Artigo criado com sucesso.");
        }else{
            try{
                throw new ExistentItemException();
            }catch (ExistentItemException e){
                System.out.println(e);
            }
        }
    }

    private boolean checkItem(Item item){
        for (Item item1 : items){
            if(item1.getName().equals(item.getName())){
                return false;
            }
        }
        return true;
    }


}
