package item;

public class Item{

    private String itemID;
    private int volume;
    private int price;

    public Item(String name, int volume, int price){
        this.itemID = name;
        this.volume = volume;
        this.price = price;
    }

    public String getItemID(){
        return itemID;
    }

    public int getVolume(){
        return volume;
    }

    public int getPrice(){
        return price;
    }

    @Override
    public String toString(){
        return "Item{" +
                "name='" + itemID + '\'' +
                ", volume=" + volume +
                ", price=" + price +
                '}';
    }

}
